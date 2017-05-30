package de.feelberlin.android.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.CirclePageIndicator;

import butterknife.ButterKnife;
import butterknife.OnClick;
import de.feelberlin.android.Navigator;
import de.feelberlin.android.R;
import de.feelberlin.android.adapter.OnboardingPagerAdapter;

public class SplashActivity extends BaseActivity {

    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                setContentView(R.layout.activity_splash_onboarding);
                ButterKnife.bind(SplashActivity.this);
                setupPager();
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    private void setupPager() {
        ViewPager viewPager = ButterKnife.findById(this, R.id.pager);
        OnboardingPagerAdapter adapterViewPager = new OnboardingPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);

        CirclePageIndicator indicator = ButterKnife.findById(this, R.id.indicator);
        indicator.setViewPager(viewPager);
    }

    @OnClick(R.id.btn_get_in)
    public void getInAction() {
        Navigator.navigateToSignIn(this);
        finish();
    }

    @OnClick(R.id.skip)
    public void skipAction() {
        Navigator.navigateToHome(this);
        finish();
    }
}
