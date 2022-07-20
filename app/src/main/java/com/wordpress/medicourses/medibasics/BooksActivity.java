package com.wordpress.medicourses.medibasics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BooksActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private String url;

    @Override   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        List items = new ArrayList<>();

        items.add(new Book(R.drawable.porrero, "Anatomia Humana Porrero", "Abrir Libro", 1));
        items.add(new Book(R.drawable.marshall, "Bioquimica Medica Ilustrada", "Abrir Libro", 2));
        items.add(new Book(R.drawable.guyton, "Fisiologia Humana Guyton", "Abrir Libro", 3));
        items.add(new Book(R.drawable.langman, "Embriologia Langman", "Abrir Libro", 4));
        items.add(new Book(R.drawable.junqueira, "Histologia Medica Junqueira", "Abrir Libro", 5));
        items.add(new Book(R.drawable.terminos, "Terminologia Medica Anatomica", "Abrir Libro", 6));

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new BookAdapter(items);
        recycler.setAdapter(adapter);
    }

    public void buttonPress(View v) {
        SharedPreferences prefes = this.getSharedPreferences("com.wordpress.medicourses.medibasics", Context.MODE_PRIVATE);
        String valuePr = prefes.getString("appstatus", "");
        String alerText = "Compra la app para acceder a esta seccion";
        switch (v.getId()) {
            case 1:
                Intent intent1 = new Intent(BooksActivity.this, PdfActivity.class);
                intent1.putExtra("param", "ahpf.pdf");
                startActivity(intent1);
                break;
            case 2:
                if(valuePr.equals("unvalid")){
                    createSimpleDialog(alerText);
                } else {
                    Intent intent2 = new Intent(BooksActivity.this, PdfActivity.class);
                    intent2.putExtra("param", "bmmf.pdf");
                    startActivity(intent2);
                }
                break;
            case 3:
                if(valuePr.equals("unvalid")){
                    createSimpleDialog(alerText);
                } else {
                    Intent intent3 = new Intent(BooksActivity.this, PdfActivity.class);
                    intent3.putExtra("param", "fmgf.pdf");
                    startActivity(intent3);
                }
                break;
            case 4:
                if(valuePr.equals("unvalid")){
                    createSimpleDialog(alerText);
                } else {
                    Intent intent4 = new Intent(BooksActivity.this, PdfActivity.class);
                    intent4.putExtra("param", "emlf.pdf");
                    startActivity(intent4);
                }
                break;
            case 5:
                if(valuePr.equals("unvalid")){
                    createSimpleDialog(alerText);
                } else {
                    Intent intent5 = new Intent(BooksActivity.this, PdfActivity.class);
                    intent5.putExtra("param", "hmjf.pdf");
                    startActivity(intent5);
                }
                break;
            case 6:
                if(valuePr.equals("unvalid")){
                    createSimpleDialog(alerText);
                } else {
                    Intent intent6 = new Intent(BooksActivity.this, PdfActivity.class);
                    intent6.putExtra("param", "tmaf.pdf");
                    startActivity(intent6);
                }
                break;
        }
    }

    public void createSimpleDialog(String string) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String text = string;
        builder.setTitle("Alerta");
        builder.setMessage(string);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                acceptButton();
            }
        });
        builder.setNegativeButton("Cancelar", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void acceptButton(){
        Intent intent = new Intent(BooksActivity.this, ValidateActivity.class);
        startActivity(intent);
    }

    public void freebitco(View view) {
        url = "https://freebitco.in/?r=38458341";
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}