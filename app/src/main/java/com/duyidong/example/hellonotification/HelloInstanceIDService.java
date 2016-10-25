package com.duyidong.example.hellonotification;

import android.content.Intent;
import android.util.Log;
import android.widget.EditText;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by yid on 10/24/2016.
 */

public class HelloInstanceIDService extends FirebaseInstanceIdService {
    class UpdateEditToken implements Runnable{
        private String newToken;

        public UpdateEditToken(String newToken) {
            this.newToken = newToken;
        }

        @Override
        public void run() {
            EditText editTextToken = (EditText) MainActivity.getMainActivity().findViewById(R.id.editText_token);
            editTextToken.setText(newToken);
        }
    }

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.i("Info", "Refreshed token: " + refreshedToken);

        TokenFileHelper.saveToken(refreshedToken);

        MainActivity.getMainActivity().runOnUiThread(new UpdateEditToken(refreshedToken));

//        EmailUtil.sendEmail("hello notification token", refreshedToken);
    }
}
