package com.example.ht10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    WebView web;
    EditText inputText;
    String lastPage;
    String nextPage;
    String searchPage  = "google.fi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webview);
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());

        inputText = findViewById(R.id.editTextTextPersonName);
        web.loadUrl("http://www.google.fi");
    }

    public void search(View v){

        if (inputText.getText().toString().equals("index.html")) {
            web.loadUrl("file:///android_asset/index.html");

        }
        else {

            lastPage = searchPage;
            web.loadUrl("http://" + inputText.getText().toString());
            searchPage = inputText.getText().toString();
            nextPage = searchPage;
        }


    }

    public void refresh(View v){
        web.reload();
    }

    public void back(View v){
        web.loadUrl("http://"+lastPage);
        nextPage = searchPage;

    }

    public void next(View v){
         web.loadUrl("http://"+nextPage);
        
        
    }

    public void javaRead(View v){
        web.evaluateJavascript("javascritp:shoutOut()",null);
    }

    public void javaRead2(View v){
        web.evaluateJavascript("javascritp:initialize()",null);
    }

}