package com.drcdadaab.tumshukuruyesuuser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.NativeExpressAdView;

public class ViewSongActivity extends AppCompatActivity {

    TextView textViewSongContent, textViewSongTitle;
    String title, content, hymnNumber;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_song);

        textViewSongContent = (TextView) findViewById(R.id.textViewSongContent);
        textViewSongTitle = (TextView) findViewById(R.id.textViewSongTitle);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("3664D637B9121DA640F3B3CAAD6DBA70").build();
        mAdView.loadAd(adRequest);


        Intent i = getIntent();
        title = i.getStringExtra("titleKey");
        content = i.getStringExtra("ContentKey");
        hymnNumber = i.getStringExtra("HymnNumberKey");

        textViewSongContent.setText (content);
        textViewSongTitle.setText (title);

        if(TextUtils.isEmpty(hymnNumber)){
            getSupportActionBar().setTitle(title);
        } else{
            getSupportActionBar().setTitle(hymnNumber+".  "+title);
        }


//        NativeExpressAdView adView = (NativeExpressAdView)findViewById(R.id.adView);
//
//        AdRequest request = new AdRequest.Builder().addTestDevice("3664D637B9121DA640F3B3CAAD6DBA70").build();
//        adView.loadAd(request);

    }
}
