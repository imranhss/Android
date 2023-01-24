package com.example.testandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondPage extends AppCompatActivity {
private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        webView=findViewById(R.id.web);

        WebSettings webSettings = webView.getSettings();
        webView.setWebViewClient(new SameView());
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://www.youtube.com/");



    }

    public  class SameView extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }


}