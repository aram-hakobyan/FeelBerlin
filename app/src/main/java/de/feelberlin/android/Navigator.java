package de.feelberlin.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import de.feelberlin.android.activity.BaseActivity;
import de.feelberlin.android.activity.FeedbackActivity;
import de.feelberlin.android.activity.NotificationSettingsActivity;
import de.feelberlin.android.activity.ProfileActivity;
import de.feelberlin.android.activity.SignInActivity;
import de.feelberlin.android.activity.SignUpActivity;

/**
 * Created by Apple on 5/27/17.
 */

public class Navigator {

    private static final int HOME_FRAGMENT_CONTAINER_RESOURCE = R.id.container;
    public static final int REQUEST_CODE_ABOUT = 1;
    public static final int RESULT_CODE_ABOUT = 10;

    public static void setFragment(AppCompatActivity activity, Class fragmentClass) {
        setFragment(activity, fragmentClass, HOME_FRAGMENT_CONTAINER_RESOURCE);
    }

    public static void setFragment(AppCompatActivity activity, Class fragmentClass, int resId) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        try {
            Fragment fragment = (Fragment) fragmentClass.newInstance();
            fragmentManager.beginTransaction().replace(resId, fragment).commitAllowingStateLoss();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setFragmentToBackstack(AppCompatActivity activity, Class fragmentClass) {
        setFragmentToBackstack(activity, fragmentClass, HOME_FRAGMENT_CONTAINER_RESOURCE, null);
    }

    public static void setFragmentToBackstack(AppCompatActivity activity, Class fragmentClass, Bundle args) {
        setFragmentToBackstack(activity, fragmentClass, HOME_FRAGMENT_CONTAINER_RESOURCE, args);
    }

    public static void setFragmentToBackstack(AppCompatActivity activity, Class fragmentClass, int resId, Bundle args) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        try {
            Fragment fragment = (Fragment) fragmentClass.newInstance();
            if (args != null) {
                fragment.setArguments(args);
            }
            fragmentManager.beginTransaction().replace(resId, fragment).addToBackStack(fragmentClass.getName()).commitAllowingStateLoss();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void navigateToSignIn(Context context) {
        context.startActivity(new Intent(context, SignInActivity.class));
    }

    public static void navigateToSignUp(Context context) {
        context.startActivity(new Intent(context, SignUpActivity.class));
    }

    public static void navigateToProfile(BaseActivity context) {
        context.startActivityForResult(new Intent(context, ProfileActivity.class), REQUEST_CODE_ABOUT);
    }

    public static void navigateToNtfSettings(Context context) {
        context.startActivity(new Intent(context, NotificationSettingsActivity.class));
    }

    public static void navigateToFeedback(Context context) {
        context.startActivity(new Intent(context, FeedbackActivity.class));
    }
}
