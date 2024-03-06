package com.example.todoapp.model;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * a private class for define a new shouldOverrideUrlLoading
 * @author Quentin Le Lan
 */
public class MyWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        view.loadUrl(String.valueOf(request));
        return true;
    }
}
