//ADGSTUDIOS 2021
package com.adg.adgmusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    public WebView bro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!DetectConnection.checkInternetConnection(this)) {
            Intent myIntent = new Intent(MainActivity.this, ConnectionNotFound.class);
            finish();
            MainActivity.this.startActivity(myIntent);
        }
        else {
            bro =(WebView)findViewById(R.id.webView);
            bro.setWebViewClient(new WebViewClient());
            bro.loadUrl("https://adgstudios.co.za/music/adgmusicapp.html");
            WebSettings webSettings = bro.getSettings();
            webSettings.setJavaScriptEnabled(true);
            //make translucent statusBar on kitkat devices
            if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
                setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
            }
            if (Build.VERSION.SDK_INT >= 19) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            }
            //make fully Android Transparent Status bar
            if (Build.VERSION.SDK_INT >= 21) {
                setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            }
        }

    }
    @Override
    public void onBackPressed() {
        if (bro.canGoBack()) {
            bro.goBack();
        } else {
            super.onBackPressed();
        }
    }
    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }



}
