package com.firestudio.projectsportsnews.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.firestudio.projectsportsnews.R;

public class DetailActivity extends AppCompatActivity {
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        webView = findViewById(R.id.webview);
        Intent intent = getIntent();
        String newsUrl = intent.getStringExtra("url");

        webView.loadUrl(newsUrl);
    }
}