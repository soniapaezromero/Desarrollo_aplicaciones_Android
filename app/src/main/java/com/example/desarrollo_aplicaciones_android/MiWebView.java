package com.example.desarrollo_aplicaciones_android;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MiWebView extends AppCompatActivity {
  private WebView Visor;
  private String direccionWeb;
  String url;
  Bundle datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        datos = this.getIntent().getExtras();
        direccionWeb=datos.getString("direccion");
        url="http://"+direccionWeb;
        Visor = (WebView) findViewById(R.id.visorWeb);
        final WebSettings ajustesVisorWeb = Visor.getSettings();
        Visor.setWebViewClient(new WebViewClient());
        ajustesVisorWeb.setJavaScriptEnabled(true);
        Visor.loadUrl(url);

    }

}
