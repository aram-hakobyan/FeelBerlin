package de.feelberlin.android.activity;

import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import de.feelberlin.android.Navigator;
import de.feelberlin.android.R;

public class SignInActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.sign_up)
    public void signUpAction() {
        Navigator.navigateToSignUp(this);
    }
}
