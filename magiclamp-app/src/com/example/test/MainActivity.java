package com.example.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.widget.Toast;


@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Display display = getWindowManager().getDefaultDisplay(); 
        int width = display.getWidth();
        int height = display.getHeight();
        
        float px;
        
        if (height > width){
        	px = width;
        }else{
        	px = height;
        }
        
        px = (float) (px / 30);
        
        WebView vw = (WebView) findViewById(R.id.web1);
        vw.getSettings().setJavaScriptEnabled(true);
        vw.getSettings().setDatabaseEnabled(true);
        vw.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        vw.getSettings().setDomStorageEnabled(true);
        //vw.getSettings().setRenderPriority(RenderPriority.HIGH);
        //vw.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        //vw.getSettings().setDefaultFontSize((int) 16);
        
        
        
        try { 
        	if( Build.VERSION.SDK_INT >= 11){
        		getWindow().setFlags( 16777216, 16777216);
        	}
        } catch( Exception e) {
        	
        } // FLAG_HARDWARE_ACCELERATED == 16777216 (0x01000000)
        	
        //vw.setWebChromeClient(new WebChromeClient());
        vw.loadUrl("file:///android_asset/www/index.html");
        //vw.loadUrl("file:///android_asset/test.html");
    }


}
