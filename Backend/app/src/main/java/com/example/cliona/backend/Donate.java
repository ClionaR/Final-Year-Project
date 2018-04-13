package com.example.cliona.backend;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;

public class Donate extends Activity implements View.OnClickListener{

    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        WebView myWebView = (WebView) findViewById(R.id.donate);
        myWebView.loadUrl("https://www.dspca.ie/donate/");
    }

    public void onClick(View v) {
        finish();

    }


}
