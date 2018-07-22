package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.displaydadjoke.EndpointsAsyncTask;
import com.example.displaydadjoke.FullscreenDadJoke;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.udacity.gradle.builditbigger.R;

import java.util.Objects;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener, EndpointsAsyncTask.AsyncResponse {

    public MainActivityFragment() {
    }

    private InterstitialAd mInterstitialAd;
    private Button mLoadJokeBtn;
    private ProgressBar loadingCircle;

    private boolean interstitialAdClosed = false;

    private String dadJoke;
    private Context mContext;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mContext = Objects.requireNonNull(getActivity()).getApplicationContext();

        //declare and hide loading circle
        loadingCircle = root.findViewById(R.id.progressBar);
        loadingCircle.setVisibility(View.GONE);


        MobileAds.initialize(mContext, getString(R.string.interstitial_ad_initialize_key));
        mInterstitialAd = new InterstitialAd(mContext);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
              @Override
              public void onAdLoaded() {
                  // Code to be executed when an ad finishes loading.
              }
              @Override
              public void onAdFailedToLoad(int errorCode) {
                  // Code to be executed when an ad request fails.
              }
              @Override
              public void onAdOpened() {
                  // Code to be executed when the ad is displayed.
                  interstitialAdClosed = false;
              }
              @Override
              public void onAdLeftApplication() {
                  // Code to be executed when the user has left the app.
              }
              @Override
              public void onAdClosed() {
                  // Code to be executed when when the interstitial ad is closed.
                  interstitialAdClosed = true;
                  mLoadJokeBtn.callOnClick();
              }
          });

        mLoadJokeBtn = root.findViewById(R.id.tell_joke_btn);
        mLoadJokeBtn.setOnClickListener(this);

        if (root.findViewById(R.id.adView) != null) {
            AdView mAdView = root.findViewById(R.id.adView);
            // Create an ad request. Check logcat output for the hashed device ID to
            // get test ads on a physical device. e.g.
            // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();
            mAdView.loadAd(adRequest);
        }
        return root;
    }

    @Override
    public void onClick(View v) {
        loadingCircle.setVisibility(View.VISIBLE);
            if (mInterstitialAd.isLoaded() && !interstitialAdClosed) {
                mInterstitialAd.show();
            } else if (interstitialAdClosed) {
                EndpointsAsyncTask getJokeTask = new EndpointsAsyncTask(this);
                getJokeTask.execute();
            }
            else {
//                Log.d("TAG", "The interstitial wasn't loaded yet.");
                EndpointsAsyncTask getJokeTask = new EndpointsAsyncTask(this);
                getJokeTask.execute();
            }
        }

    @Override
    public void onResume() {
        super.onResume();
        loadingCircle.setVisibility(View.GONE);
    }

    //this override the implemented method from AsyncResponse
    @Override
    public void processFinish(String output){
        //Here you will receive the result fired from async class
        //of onPostExecute(result) method.
        dadJoke = output;
        Intent displayDadJokeIntent = new Intent(mContext, FullscreenDadJoke.class);
        displayDadJokeIntent.putExtra(getString(R.string.dad_joke_api_key), dadJoke);
        mContext.startActivity(displayDadJokeIntent);
    }

}

