package com.wordpress.medicourses.medibasics;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ValidateActivity extends AppCompatActivity {

    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate);

        SharedPreferences preferences = this.getSharedPreferences("com.wordpress.medicourses.medibasics", Context.MODE_PRIVATE);String valueStatus = preferences.getString("appstatus", "");
        String valueAppValidateCode = preferences.getString("validcode", "");
        String valueAppCode = preferences.getString("appcode", "");

        TextView textCode = findViewById(R.id.serial);
        textCode.setText("app ID: " + valueAppCode);

        Button buttonVal = findViewById(R.id.buttonval);
        EditText editText = findViewById(R.id.inputcode);
        buttonVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codeFinal = editText.getText().toString();
                if (codeFinal.equals(valueAppValidateCode)){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.remove("appstatus");
                    editor.putString("appstatus", "valid");
                    editor.apply();
                    String text1 = "Felicidades, acabas de adquirir la version completa de esta aplicacion";
                    createSimpleDialog(text1);
                } else {
                    String text2 = "El codigo ingresado es incorrecto";
                    createSimpleDialog(text2);
                }
            }
        });

        TextView contentval = findViewById(R.id.contentval);
        contentval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView secView = findViewById(R.id.textval);
                if(secView.getVisibility() == View.VISIBLE){
                    secView.setVisibility(View.GONE);
                }else{
                    secView.setVisibility(View.VISIBLE);
                }
            }
        });

        TextView contentbio = findViewById(R.id.contentserial);
        contentbio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView contView = findViewById(R.id.serial);
                if(contView.getVisibility() == View.VISIBLE){
                    contView.setVisibility(View.GONE);
                }else{
                    contView.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void createSimpleDialog(String string) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String text = string;
        builder.setTitle("Alerta");
        builder.setMessage(text);
        builder.setPositiveButton("Aceptar", null);
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void rollin(View view) {
        url = "https://www.gamee.com/get/wjqre9n1";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}