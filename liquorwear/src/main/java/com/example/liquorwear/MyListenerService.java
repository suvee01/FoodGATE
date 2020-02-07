package com.example.liquorwear;

import android.content.Intent;
import android.util.Log;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

public class MyListenerService extends WearableListenerService {
    public static final String TAG="MyDataMAP...";
    public static final String WEARABLE_DATA_PATH = "/wearable/data/path";


    public void onMessageReceived(MessageEvent messageEvent) {
        if(messageEvent.getPath().equals(WEARABLE_DATA_PATH)){
            final String message = new String(messageEvent.getData());
            Intent startIntent = new Intent(this, LiquorWear.class);
            startIntent.putExtra("message",message);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startIntent);

            Log.v(TAG,"Main Activity has been started");


        }else {
            super.onMessageReceived(messageEvent);
        }
    }
}
