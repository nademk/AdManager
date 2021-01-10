package com.nademk.library;

import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

public class BannerAdActivity extends AppCompatActivity {

    public void showAdmobBanner(String banner_id, int ad_container){

        LinearLayout adContainer = findViewById(ad_container);
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setAdUnitId(banner_id);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        adContainer.addView(adView, params);
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });

    }

    public void showFacebookBanner(String banner_id, int ad_container){

        try {
            com.facebook.ads.AdView adView = new com.facebook.ads.AdView(this, banner_id, com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            LinearLayout adContainer = findViewById(ad_container);
            if (adContainer != null && adView != null) {
                adContainer.addView(adView);

                com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                    @Override
                    public void onError(Ad ad, AdError adError) {
                        // Ad error callback
                    }

                    @Override
                    public void onAdLoaded(Ad ad) {
                        // Ad loaded callback
                    }

                    @Override
                    public void onAdClicked(Ad ad) {
                        // Ad clicked callback
                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {
                        // Ad impression logged callback
                    }
                };

                // Request an ad
                adView.loadAd(adView.buildLoadAdConfig().withAdListener(adListener).build());
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
