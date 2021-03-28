package com.ridoy.onlinepdfview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView=findViewById(R.id.webviewid);
        progressBar=findViewById(R.id.progressbarid);

        progressBar.setVisibility(View.VISIBLE);

        String url="https://students.iusb.edu/academic-success-programs/academic-centers-for-excellence/docs/Basic%20Math%20Review%20Card.pdf";
        String finalurl="https://drive.google.com/viewerng/viewer?embedded=true&url="+url;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                getSupportActionBar().setTitle("Loading...");

                if (newProgress==100){
                    progressBar.setVisibility(View.GONE);
                    getSupportActionBar().setTitle(R.string.app_name);
                }
            }
        });
        webView.loadUrl(finalurl);

    }
}