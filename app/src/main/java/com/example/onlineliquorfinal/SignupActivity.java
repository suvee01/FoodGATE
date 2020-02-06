package com.example.onlineliquorfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import API.API;
import Model.User;

import com.example.onlineliquorfinal.Sensor.ShakeDetector;
import com.example.onlineliquorfinal.URL.url;
import com.example.onlineliquorfinal.serverresponse.SignUpResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
        private EditText etfname, etlname, etaddress, etphno, etemail, etusername,etpassword, etconfirmpass;
        private Button btnsignup;
        private TextView tvlogin;

        private ShakeDetector mShakeDetector;
        private SensorManager mSensorManager;
        private Sensor mAccelerometer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etfname=findViewById(R.id.fname);
        etlname=findViewById(R.id.lname);
        etaddress=findViewById(R.id.address);
        etphno=findViewById(R.id.phone);
        etemail=findViewById(R.id.email);
        etusername=findViewById(R.id.susername);
        etpassword=findViewById(R.id.spassword);
        etconfirmpass=findViewById(R.id.cpassword);
        btnsignup=findViewById(R.id.btn_signup);
        tvlogin=findViewById(R.id.tvlogin);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake() {

                etfname.setText("");
                etlname.setText("");
                etaddress.setText("");
                etphno.setText("");
                etemail.setText("");
                etusername.setText("");
                etpassword.setText("");
                etconfirmpass.setText("");

            }
        });

        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(SignupActivity.this, LoginActivity.class );
                startActivity(i);
            }
            });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etpassword.getText().toString().equals(etconfirmpass.getText().toString())){
                    if(validate()){
                        signup();
                    }
                } else{
                    Toast.makeText(SignupActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                etpassword.requestFocus();
                        return;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }


    private void signup() {

        String fname= etfname.getText().toString();
        String lname=etlname.getText().toString();
        String address= etaddress.getText().toString();
        String phone= etphno.getText().toString();
        String email= etemail.getText().toString();
        String username= etusername.getText().toString();
        String password= etpassword.getText().toString();



        User regUser=new User(fname,lname,address,phone,email,username,password);

        API api= url.getInstance().create(API.class);
            Call<SignUpResponse> call=api.register(regUser);

            call.enqueue(new Callback<SignUpResponse>() {
                @Override
                public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(SignupActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Toast.makeText(SignupActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<SignUpResponse> call, Throwable t) {
                    Toast.makeText(SignupActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });




    }

    private boolean validate(){
boolean status=true;
if(etusername.getText().toString().length()<6){
etusername.setError("");
status=false;
}

return status;
}


}
