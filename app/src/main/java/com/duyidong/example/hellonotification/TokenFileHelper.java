package com.duyidong.example.hellonotification;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by yid on 10/24/2016.
 */

public class TokenFileHelper {
    public static void saveToken(String token) {
        File file = getTokenFile();

        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.write(token);
        }
        catch (IOException e) {
            Log.e("HELLO", e.getMessage(), e);
        }
        finally {
            if (writer != null) {
                try {
                    writer.close();
                }
                catch (Exception e1) {}
            }
        }
    }

    public static String getToken() {
        File file = getTokenFile();
        if (!file.exists()) {
            return null;
        }

        StringWriter sw = new StringWriter();
        char[] buffer = new char[1024];

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            int len = reader.read(buffer);
            while (len > 0) {
                sw.write(buffer, 0, len);
                len = reader.read(buffer);
            }
            return sw.toString();
        }
        catch (IOException e) {
            Log.e("HELLO", e.getMessage(), e);
            return null;
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (Exception e) {}
            }
        }
    }

    private static File getTokenFile() {
        File dir = MainActivity.getMainActivity().getFilesDir();
        return new File(dir.getAbsolutePath() + File.separator + "token.txt");
    }
}
