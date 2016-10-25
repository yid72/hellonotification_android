package com.duyidong.example.hellonotification;

import android.util.Log;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by yid on 10/24/2016.
 */

public class HelloMessagingService extends FirebaseMessagingService {
    class UpdateNotification implements Runnable{
        private String notification;

        public UpdateNotification(String notification) {
            this.notification = notification;
        }

        @Override
        public void run() {
            TextView textViewNotification = (TextView) MainActivity.getMainActivity().findViewById(R.id.textView_server_notification);
            textViewNotification.setText(notification);
        }
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.i("INFO", "From: " + remoteMessage.getFrom());

        String noti = remoteMessage.getNotification().getBody();
        String data = remoteMessage.getData().toString();
        MainActivity.getMainActivity().runOnUiThread(
                new UpdateNotification("Notification=" + noti + ", data=" + data));
    }
}
