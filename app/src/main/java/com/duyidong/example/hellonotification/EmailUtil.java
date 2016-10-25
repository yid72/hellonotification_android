package com.duyidong.example.hellonotification;

import android.content.Intent;
import android.util.Log;

/**
 * Created by yid on 10/24/2016.
 */

public class EmailUtil {
    public static void sendEmail(String subject, String body) {
        String to = "duyidong@gmail.com";

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{to});
        i.putExtra(Intent.EXTRA_SUBJECT, subject);
        i.putExtra(Intent.EXTRA_TEXT, body);
        try {
            MainActivity.getMainActivity().startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Log.e("ERROR", ex.getMessage(), ex);
        }
    }
}
