package com.example.cliona.backend;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;

public class NoticeActivity extends Activity implements View.OnClickListener{

    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        WebView myWebView = (WebView) findViewById(R.id.events);
        myWebView.loadUrl("https://www.facebook.com/dspca/");
    }

    public void onClick(View v) {
        finish();

    }


}
