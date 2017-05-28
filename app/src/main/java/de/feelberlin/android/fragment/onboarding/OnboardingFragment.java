package de.feelberlin.android.fragment.onboarding;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.feelberlin.android.R;

/**
 * Created by Apple on 5/27/17.
 */

public class OnboardingFragment extends Fragment {

    private int page;

    public static OnboardingFragment newInstance(int page) {
        OnboardingFragment fragmentFirst = new OnboardingFragment();
        Bundle args = new Bundle();
        args.putInt("page", page);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("page", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int layoutRes = -1;
        switch (page) {
            case 0:
                layoutRes = R.layout.onboarding_first;
                break;
            case 1:
                layoutRes = R.layout.onboarding_second;
                break;
            case 2:
                layoutRes = R.layout.onboarding_third;
                break;
        }

        if (layoutRes == -1)
            throw new RuntimeException("Wrong argument!");

        View view = inflater.inflate(layoutRes, container, false);
        return view;
    }
}
