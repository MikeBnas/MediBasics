package com.wordpress.medicourses.medibasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class PdfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        Bundle bundle= getIntent().getExtras();
        String libsource = bundle.getString("param");

        PDFView pdfView = findViewById(R.id.pdfview);

        pdfView.fromAsset(libsource).scrollHandle(new DefaultScrollHandle(this)).load();
    }
}