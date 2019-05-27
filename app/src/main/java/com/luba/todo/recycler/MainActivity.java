package com.luba.todo.recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener {
    private RewardedVideoAd mRewardedVideoAd;
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();
        ArrayList<Item> list = new ArrayList();
        button = findViewById(R.id.button);
        list.add(new Item("Hi there! I salut you in this simple app", "5.02.19", 1));
        list.add(new Item("Hi!", "5.02.19", 2));
        list.add(new Item("You can watch this wonderful video!", "6.02.19", 1));
        list.add(new Item("Watch this cool ad!", "", 3));
        mRecycleView = findViewById(R.id.recyclerView);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager((this));
        mAdapter = new Adapter(list);
        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);


    }
    public void clickButton(View view) {
        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();
        }
        else Toast.makeText(this, "Video is loading, wait a little amd try again, please", Toast.LENGTH_SHORT).show();
    }

    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917",
                new AdRequest.Builder().build());
    }

    @Override
    public void onRewarded(RewardItem reward) {
       // Toast.makeText(this, "onRewarded! currency: " + reward.getType() + "  amount: " +  reward.getAmount(), Toast.LENGTH_SHORT).show();
        // Reward the user.
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
       // Toast.makeText(this, "onRewardedVideoAdLeftApplication", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdClosed() {
        Toast.makeText(this, "thanks for attention!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {

    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }
}
