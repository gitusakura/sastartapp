package com.kimganteng.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.aliendroid.alienads.AlienOpenAds;
import com.aliendroid.alienads.AliendroidBanner;
import com.aliendroid.alienads.AliendroidInitialize;
import com.aliendroid.alienads.AliendroidIntertitial;
import com.aliendroid.alienads.AliendroidMediumBanner;
import com.aliendroid.alienads.AliendroidNative;
import com.aliendroid.alienads.AliendroidReward;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlienOpenAds.LoadOpenAds("");
        RelativeLayout layAds = findViewById(R.id.layAds);
        RelativeLayout layAds2 = findViewById(R.id.layAds2);
        RelativeLayout layAds3 = findViewById(R.id.layAds3);
        RelativeLayout layAds7 = findViewById(R.id.layNative4);
        RelativeLayout layNative = findViewById(R.id.layNative);
        AliendroidInitialize.SelectAdsAdmob(this,"KOSONG","SDGREGFD");

        AliendroidNative.MediumNativeNonStroke(this,layNative,"STARTAPPx","ca-app-pub-3940256099942544/2247696110","8d8bffb4fc9bc946",
                "","","","","");

        AliendroidNative.SmallNativeAdmobNonStroke(this,layAds,"STARTAPPx","ca-app-pub-3940256099942544/2247696110","8d8bffb4fc9bc946",
                "","","","","");

        AliendroidNative.SmallNativeAdmobRectangle(this,layAds2,"STARTAPP","xxca-app-pub-3940256099942544/2247696110","8d8bffb4fc9bc946",
                "","","","","");
        AliendroidNative.SmallNativeAdmobWhite(this,layAds3,"STARTAPP","xxca-app-pub-3940256099942544/2247696110","8d8bffb4fc9bc946",
                "","","","","");


        //AliendroidMediumBanner.MediumBannerIron(this,layNative,"","Home_Screen","");

        //AliendroidReward.LoadRewardAdmob(this,"APPLOVIN-D","ca-app-pub-3940256099942544/5224354917","");
        AliendroidIntertitial.LoadIntertitialAdmob(this,"STARTAPP","8d8bffb4fc9bc946","1234235235","a","b","c","d","e");

    }

    public void showreward(View view){

        AliendroidIntertitial.ShowIntertitialAdmob(MainActivity.this,"STARTAPP","8d8bffb4fc9bc946","",0,"a","b","c","d","e");
        //AliendroidReward.ShowRewardAdmob(MainActivity.this,"APPLOVIN-D","ca-app-pub-3940256099942544/5224354917","");
    }
}