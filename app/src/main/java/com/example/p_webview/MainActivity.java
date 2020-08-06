package com.example.p_webview;
/*
*
 shouldOverrideUrlLoading:url:https://tw.mobi.yahoo.com/
 onPageFinished:url:https://tw.yahoo.com/?guccounter=1&guce_referrer=aHR0cHM6Ly93d3cuZ29vZ2xlLmNvbS8&guce_referrer_sig=AQAAADst7IjMOTg-WvXIkjPrUzVsy0RzZ3prrUU1Hc2XnyY9a9TAp8BD2AtCvTYsS_xjVo11YJ6GeVBzn0DgxYIrVr9CJvItdnWxtB3dM1IVCROxiLaSs_VN3dY0sq9IJkEqhKNr9mlfZljTC81O0gcanXVj1vpyVokHat4FxPeyai2f
 onPageStarted:url:https://tw.mobi.yahoo.com//favicon:
 onPageFinished:url:https://tw.mobi.yahoo.com/
*
*
*
*
* */
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webView);
        initWebView();

    }



    private  void initWebView(){
//        webView.loadUrl("https://tw.yahoo.com/?guccounter=1&guce_referrer=aHR0cHM6Ly93d3cuZ29vZ2xlLmNvbS8&guce_referrer_sig=AQAAADst7IjMOTg-WvXIkjPrUzVsy0RzZ3prrUU1Hc2XnyY9a9TAp8BD2AtCvTYsS_xjVo11YJ6GeVBzn0DgxYIrVr9CJvItdnWxtB3dM1IVCROxiLaSs_VN3dY0sq9IJkEqhKNr9mlfZljTC81O0gcanXVj1vpyVokHat4FxPeyai2f"); //連接外部url要接的web("網址");
        webView.loadUrl("https://tw.yahoo.com/?guccounter=1&guce_referrer=aHR0cHM6Ly93d3cuZ29vZ2xlLmNvbS8&guce_referrer_sig=AQAAADst7IjMOTg-WvXIkjPrUzVsy0RzZ3prrUU1Hc2XnyY9a9TAp8BD2AtCvTYsS_xjVo11YJ6GeVBzn0DgxYIrVr9CJvItdnWxtB3dM1IVCROxiLaSs_VN3dY0sq9IJkEqhKNr9mlfZljTC81O0gcanXVj1vpyVokHat4FxPeyai2f");//file內部檔案:三根斜線通訊協定/安卓程式_asset存放區不加s因為只有單一頁面/html頁面
        WebViewClient webViewClient = new WebViewClient();//網頁視野客戶端處理物件
        webView.setWebViewClient(client);//設定網頁客戶端使用(webViewClient ),這樣使用我們自己的view到下一頁
        // 3.設定讓js可以使用
        WebSettings Settings = webView.getSettings();//webView.取得設定物件(回傳WebSettings)
        Settings.setJavaScriptEnabled(true); //設定js是否開啟(bollean是/否)
        //4.一開始圖片很大張,讓圖片可以縮放,打開三個設定才能進行縮放
        Settings.setSupportZoom(true);//設定圖片支援縮放(是/否)
        Settings.setBuiltInZoomControls(true);//設定內部的縮放控制開關(是/否)
        Settings.setDisplayZoomControls(true);//設定顯示縮放控制開關(是/否)

        //5.讓圖片大小直接跟你的螢幕寬依樣
        Settings.setUseWideViewPort(true);//設定使用者的圖片跟螢幕裝置一樣寬
        Settings.setLoadWithOverviewMode(true);//設定當你讀黨時圖片寬就跟全景一樣寬
    }


    private WebViewClient client = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.v("hank","shouldOverrideUrlLoading:" + "url:" + url);
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.v("hank","onPageFinished:" + "url:" + url);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError
        error) {
            super.onReceivedError(view, request, error);
            Log.v("hank","onReceivedError:" + "request:" + request.getMethod() + "/WebResourceError:" + error.getDescription() +"/getErrorCode:" + error.getErrorCode());
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.v("hank","onPageStarted:" + "url:" + url +"/favicon:" );

        }
    };
}
