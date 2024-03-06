package com.example.todoapp.act;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.todoapp.R;
import com.example.todoapp.model.MyWebViewClient;
import com.example.todoapp.model.WebAppInterface;

/**
 * create an activity for show an url website in a WebView
 * @author Quentin Le Lan
 */
public class showOnWeb extends AppCompatActivity {

    /**
     * the webView
     */
    WebView view;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_on_web);
        view=(WebView)findViewById(R.id.web);

        WebSettings params=view.getSettings();
        params.setJavaScriptEnabled(true);
        params.setBuiltInZoomControls(true);
        view.addJavascriptInterface(new WebAppInterface(this),"Android");
        view.setWebViewClient(new MyWebViewClient());
        String url="";
        Bundle bundle=getIntent().getExtras();
        if(bundle.containsKey("url")){
            url=bundle.getString("url");
        }
        this.view.loadUrl(url);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean ret=false;
        if(keyCode==KeyEvent.KEYCODE_BACK && this.view.canGoBack()){
            this.view.goBack();
            ret=true;
        }else{
            ret=super.onKeyDown(keyCode,event);
        }
        return ret;
    }

    @Override
    public void finish(){
        Intent returnIntent = new Intent();
        setResult(5,returnIntent);
        super.finish();
    }
}