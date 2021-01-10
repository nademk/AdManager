package com.nademk.library;

import android.content.Context;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;

public class InterstitialAdUtility {

    public static int ADS_COUNTER = 0;

    public static void loadAdmobInterstitial(Context context, String interstitial_id) {

        final InterstitialAd interstitialAd = new InterstitialAd(context);
        interstitialAd.setAdUnitId(interstitial_id);
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                interstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                //ode to be executed when the user closes an ad.
            }
        });
    }

    public static void loadFBInterstitial(Context context, String interstitial_id) {


        try {
            final com.facebook.ads.InterstitialAd interstitialAd = new com.facebook.ads.InterstitialAd(context, interstitial_id);

            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                @Override
                public void onError(Ad ad, AdError adError) {
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    interstitialAd.show();
                }

                @Override
                public void onAdClicked(Ad ad) {
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                }

                @Override
                public void onInterstitialDisplayed(Ad ad) {
                }

                @Override
                public void onInterstitialDismissed(Ad ad) {


                }
            };
            interstitialAd.loadAd(interstitialAd.buildLoadAdConfig().withAdListener(interstitialAdListener).build());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void showAdmobInterstitial(Context context, String interstitial_id, int frequency) {

        if (ADS_COUNTER % frequency == 0 ) {
            loadAdmobInterstitial(context, interstitial_id);
        }

        ADS_COUNTER++;
    }


    public static void showFbInterstitial(Context context, String interstitial_id, int frequency) {

        if (ADS_COUNTER % frequency == 0) {
            loadFBInterstitial(context, interstitial_id);

        }
        ADS_COUNTER++;
    }
}
