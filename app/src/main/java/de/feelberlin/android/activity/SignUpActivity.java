package de.feelberlin.android.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import de.feelberlin.android.Navigator;
import de.feelberlin.android.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.sign_in)
    public void signInAction() {
        Navigator.navigateToSignIn(this);
        finish();
    }

    @OnClick(R.id.skip)
    public void skipUpAction() {
        Navigator.navigateToHome(this);
        finish();
    }
}
