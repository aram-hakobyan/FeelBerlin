package de.feelberlin.android.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import de.feelberlin.android.fragment.onboarding.OnboardingFragment;

/**
 * Created by Apple on 5/27/17.
 */

public class OnboardingPagerAdapter extends FragmentPagerAdapter {
    private static int PAGE_COUNT = 3;

    public OnboardingPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return OnboardingFragment.newInstance(position);
    }

}
