package com.example.crackme0201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private boolean checkSN(String username, String sn){
        try {
            if ((username == null) || (username.length() == 0)) {
                return false;
            }
            if ((sn == null) || (sn.length() != 16)) {
                return false;
            }
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.reset();
            digest.update(username.getBytes());
            byte[] bytes = digest.digest();
            String hexstr = (bytes, "");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hexstr.length(); i += 2) {
                sb.append(hexstr.charAt(i));
            }
            String userSN = sb.toString();
            Log.d("crackme", hexstr);
            Log.d("crackme", userSN);
            if (!userSN.equalsIgnoreCase(sn)) {
                return false;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}