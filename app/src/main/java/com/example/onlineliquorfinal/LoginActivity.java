package com.example.onlineliquorfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import API.API;
import Model.LoginResponse;
import Model.User;
import com.example.onlineliquorfinal.URL.url;
import com.example.onlineliquorfinal.bll.LoginBLL;
import com.example.onlineliquorfinal.broadcastreciever.BroadCastReceiver;
import com.example.onlineliquorfinal.createChannel.CreateChannel;
import com.example.onlineliquorfinal.strictmode.StrictModeClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class LoginActivity extends AppCompatActivity {

    private EditText et1,et2;
    private Button login;
    private TextView LoginWithGG;
    private TextView signup, Forgetpass;
    public SensorManager sensorManager;
    private NotificationManagerCompat notificationManagerCompat;
    Vibrator vibrator;
    private TextView tvgyro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        notificationManagerCompat= NotificationManagerCompat.from(this);
        CreateChannel channel= new CreateChannel(this);
        channel.createChannel();

        tvgyro= findViewById(R.id.tvgyro);
        sensorGyro();
        sensorLight();
        et1 = findViewById(R.id.username);
        et2 = findViewById(R.id.password);
        login = findViewById(R.id.btn_login);
        LoginWithGG=findViewById(R.id.btnGG);
        Forgetpass=findViewById(R.id.forgot_password);
        signup=findViewById(R.id.tvsignup);


        Forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(LoginActivity.this, ForgetPassActivity.class );
                startActivity(i);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(LoginActivity.this, SignupActivity.class );
                startActivity(i);
            }
        });
            LoginWithGG.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(LoginActivity.this,"You have clicked on Google Login",Toast.LENGTH_SHORT).show();
                }
            });
//    }
//

       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               login();

               DisplayNotification();

           }
       });
}

    private void sensorLight() {
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor sensor= sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        SensorEventListener sensorEventListener= new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if(event.sensor.getType()==Sensor.TYPE_LIGHT){
                    Toast.makeText(LoginActivity.this,"onSensor Change:" + event.values[0], Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
           }





    private void sensorGyro() {
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor= sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        SensorEventListener sensorEventListener= new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if(event.values[1]<0){
                    tvgyro.setText("Left");

                }
                else if (event.values[1]>0){
                    tvgyro.setText("Right");
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        if(sensor!=null){
            sensorManager.registerListener(sensorEventListener, sensor,SensorManager.SENSOR_DELAY_NORMAL);

        }else {
            Toast.makeText(this,"No sensor found",Toast.LENGTH_SHORT).show();

        }

    }

    private void login() {
        String username = et1.getText().toString();
        String password = et2.getText().toString();

        LoginBLL loginBLL = new LoginBLL();

        StrictModeClass.StrictMode();
        if (loginBLL.checkUser(username, password)) {
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();

        } else {
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            et1.requestFocus();
            Vibrator vibrator=(Vibrator) getSystemService(VIBRATOR_SERVICE);
            vibrator.vibrate(2000);
        }
    }

    private void DisplayNotification() {

        Notification notification= new NotificationCompat.Builder(this,CreateChannel.CHANNEL_1)
        .setSmallIcon(R.drawable.ic_notifications_none_black_24dp)
         .setContentTitle("Liquor Mart")
         .setContentText("Login Success:" + et1.getText().toString())
           .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1,notification);


    }
 BroadCastReceiver broadCastReceiver= new BroadCastReceiver(this);

    protected void onStart(){
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadCastReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadCastReceiver);
    }
}
