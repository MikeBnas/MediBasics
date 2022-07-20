package com.wordpress.medicourses.medibasics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {

    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = this.getSharedPreferences("com.wordpress.medicourses.medibasics", Context.MODE_PRIVATE);
        String value = prefs.getString("appstatus",null);
        if(value == null){
            SharedPreferences.Editor editor = prefs.edit();

            String idValidation = generateRandomString(32);
            String preCode = idValidation.substring(5, 9);
            String postCode = idValidation.substring(25, 29);
            String validCode = postCode + preCode;
            editor.clear();
            editor.putString("appcode", idValidation);
            editor.putString("validcode", validCode.toUpperCase());
            editor.putString("appstatus", "unvalid");
            editor.apply();
        };

        Button button = findViewById(R.id.btn);
        Button buttonmed = findViewById(R.id.btnmed);

        SharedPreferences prefes = this.getSharedPreferences("com.wordpress.medicourses.medibasics", Context.MODE_PRIVATE);
        String valuePr = prefes.getString("appstatus", "");

        if(valuePr.equals("valid")){
            buttonmed.setVisibility(View.GONE);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BooksActivity.class);
                startActivity(intent);
            }
        });

        buttonmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ValidateActivity.class);
                startActivity(intent);
            }
        });



    }

    static String generateRandomString(int length) {
        String CHAR_LOWER = "bcdfghjklmnpqrstvwxyz";
        String CHAR_VOCALS = "aeiou";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";

        String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_VOCALS + CHAR_UPPER + NUMBER;
        SecureRandom random = new SecureRandom();

        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            sb.append(rndChar);
        }

        String idApp = sb.toString();
        return idApp;
    }

    public void gamee(View view) {
        url = "https://www.gamee.com/get/wjqre9n1";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}