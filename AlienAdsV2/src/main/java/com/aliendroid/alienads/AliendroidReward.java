package com.aliendroid.alienads;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.ads.mediation.facebook.FacebookExtras;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adlisteners.VideoListener;



import java.util.Map;

public class AliendroidReward {
    public static boolean unlockreward = false;
    public static StartAppAd rewardedVideo;
    private static RewardedAd mRewardedAd;

    //Uranus
    //Uranus
    public static void LoadRewardAdmob(Activity activity, String selectBackupAds, String idReward, String idBackupReward) {
        try {
            Bundle extras = new FacebookExtras()
                    .setNativeBanner(true)
                    .build();
            AdRequest adRequest = new AdRequest.Builder()
                    .addNetworkExtrasBundle(FacebookAdapter.class, extras)
                    .build();
            RewardedAd.load(activity, idReward,
                    adRequest, new RewardedAdLoadCallback() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            mRewardedAd = null;
                        }

                        @Override
                        public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                            mRewardedAd = rewardedAd;

                        }
                    });
            switch (selectBackupAds) {

                case "STARTAPP":
                    rewardedVideo = new StartAppAd(activity);
                    rewardedVideo.setVideoListener(new VideoListener() {
                        @Override
                        public void onVideoCompleted() {
                            unlockreward = true;
                        }
                    });

                    rewardedVideo.loadAd(StartAppAd.AdMode.REWARDED_VIDEO, new AdEventListener() {
                        @Override
                        public void onReceiveAd(com.startapp.sdk.adsbase.Ad ad) {

                        }

                        @Override
                        public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {

                        }
                    });
                    break;
                case "UNITY":
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void LoadRewardStartApp(Activity activity, String selectBackupAds, String idReward, String idBackupReward) {
        rewardedVideo = new StartAppAd(activity);
        rewardedVideo.setVideoListener(new VideoListener() {
            @Override
            public void onVideoCompleted() {
                unlockreward = true;
            }
        });

        rewardedVideo.loadAd(StartAppAd.AdMode.REWARDED_VIDEO, new AdEventListener() {
            @Override
            public void onReceiveAd(com.startapp.sdk.adsbase.Ad ad) {

            }

            @Override
            public void onFailedToReceiveAd(com.startapp.sdk.adsbase.Ad ad) {

            }
        });
        switch (selectBackupAds) {
            case "ADMOB":
            case "GOOGLE-ADS":
                Bundle extras = new FacebookExtras()
                        .setNativeBanner(true)
                        .build();
                AdRequest adRequest = new AdRequest.Builder()
                        .addNetworkExtrasBundle(FacebookAdapter.class, extras)
                        .build();
                RewardedAd.load(activity, idBackupReward,
                        adRequest, new RewardedAdLoadCallback() {
                            @Override
                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                mRewardedAd = null;
                            }

                            @Override
                            public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                                mRewardedAd = rewardedAd;

                            }
                        });
                break;


        }
    }


    public static void ShowRewardAdmob(Activity activity, String selecBackuptAds, String idReward, String idBackupReward) {
        if (mRewardedAd != null) {
            Activity activityContext = activity;
            mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                    unlockreward = true;
                    LoadRewardAdmob(activity, selecBackuptAds, idReward, idBackupReward);
                }
            });
        } else {
            switch (selecBackuptAds) {

                case "STARTAPP":

                    if (rewardedVideo.isReady()) {
                        rewardedVideo.showAd();
                    }
                    break;
                case "UNITY":

                    break;
            }
            LoadRewardAdmob(activity, selecBackuptAds, idReward, idBackupReward);
        }
    }

    public static void ShowRewardStartApp(Activity activity, String selecBackuptAds, String idReward, String idBackupReward) {
        if (rewardedVideo.isReady()) {
            rewardedVideo.showAd();
            LoadRewardStartApp(activity, selecBackuptAds, idReward, idBackupReward);
        } else {
            switch (selecBackuptAds) {

                case "GOOGLE-ADS":
                case "ADMOB":
                    if (mRewardedAd != null) {
                        Activity activityContext = activity;
                        mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                            @Override
                            public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                unlockreward = true;
                                LoadRewardAdmob(activity, selecBackuptAds, idReward, idBackupReward);
                            }
                        });
                    }
                    break;
                case "UNITY":

                    break;
            }
            LoadRewardStartApp(activity, selecBackuptAds, idReward, idBackupReward);
        }
    }
}
