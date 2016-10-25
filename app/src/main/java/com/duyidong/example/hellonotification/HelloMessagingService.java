package com.duyidong.example.hellonotification;

import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by yid on 10/24/2016.
 */

public class HelloMessagingService extends FirebaseMessagingService {
    class UpdateNotification implements Runnable{
        private String notfication;

        public UpdateNotification(String notification) {
            this.notfication = notfication;
        }

        @Override
        public void run() {
            TextView textViewNotification = (TextView) MainActivity.getMainActivity().findViewById(R.id.textView_server_notification);
            textViewNotification.setText(notfication);
        }
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.i("INFO", "From: " + remoteMessage.getFrom());

        MainActivity.getMainActivity().runOnUiThread(new UpdateNotification(remoteMessage.getNotification().toString()));
    }
}
