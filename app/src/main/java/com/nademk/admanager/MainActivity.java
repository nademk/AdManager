package com.nademk.admanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nademk.library.BannerAdActivity;
import com.nademk.library.InterstitialAdUtility;

public class MainActivity extends BannerAdActivity {

    Button fbAd, admobAd;

    String fb_banner_id = "IMG_16_9_APP_INSTALL#1754475978035647_1754511554698756";
    String admob_banner_id = "ca-app-pub-3940256099942544/6300978111";
    String fb_interstitial_id = "IMG_16_9_APP_INSTALL#1754475978035647_1754497424700169";
    String admob_interstitial_id = "ca-app-pub-3940256099942544/1033173712";
    int interstitial_ad_frequency = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fbAd = findViewById(R.id.facebook_interstitial);
        admobAd = findViewById(R.id.admob_interstitial);

        fbAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InterstitialAdUtility.showFbInterstitial(MainActivity.this, fb_interstitial_id, interstitial_ad_frequency);
            }
        });

        admobAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InterstitialAdUtility.showAdmobInterstitial(MainActivity.this, admob_interstitial_id, interstitial_ad_frequency);
            }
        });

        showAdmobBanner(admob_banner_id, R.id.admobAdlyt);
        showFacebookBanner(fb_banner_id, R.id.facebookAdLyt);


    }
}