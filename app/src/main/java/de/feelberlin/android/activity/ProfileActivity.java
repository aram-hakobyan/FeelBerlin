package de.feelberlin.android.activity;

import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import de.feelberlin.android.Navigator;
import de.feelberlin.android.R;

public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back)
    public void backAction() {
        finish();
    }

    @OnClick(R.id.notifications)
    public void ntfAction() {
        Navigator.navigateToNtfSettings(this);
    }

    @OnClick(R.id.help)
    public void helpAction() {
        // TODO: 5/28/17
    }

    @OnClick(R.id.feedback)
    public void feedbackAction() {
        Navigator.navigateToFeedback(this);
    }

    @OnClick(R.id.about)
    public void aboutAction() {
        Intent intent = new Intent();
        setResult(Navigator.REQUEST_CODE_ABOUT, intent);
        finish();
    }
}
