package com.example.macosx.citycompare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class QOLActivity extends AppCompatActivity {
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qol);
        webview = findViewById(R.id.webview);


        webview.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Toast.makeText(QOLActivity.this, "Terjadi Error", Toast.LENGTH_SHORT).show();
            }
        });

        //aktifkan fitur tambahan
        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setJavaScriptEnabled(true);

        //load websitenya
        webview.loadUrl("https://www.numbeo.com/quality-of-life/comparison.jsp");
    }
}
