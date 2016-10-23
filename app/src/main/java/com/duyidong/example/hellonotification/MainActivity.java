package com.duyidong.example.hellonotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notifyMe(View view) {
        Log.i("", "Sending local notification");

        EditText editHello = (EditText) findViewById(R.id.editText_hello);
        String hello = editHello.getText().toString();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.btn_plus)
                .setContentTitle("My Notification")
                .setContentText(hello + " " + int2String(counter ++) + ".");

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(9999, builder.build());
    }

    public void notifyServer(View view) {
    }

    private String int2String(int num) {
        if (num == 1) {
            return "once";
        }
        else if (num == 2) {
            return "twice";
        }
        else {
            return num + " times";
        }
    }
}
