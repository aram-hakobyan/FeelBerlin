package de.feelberlin.android.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.feelberlin.android.Navigator;
import de.feelberlin.android.R;
import de.feelberlin.android.api.ResultHandler;
import de.feelberlin.android.api.response.LoginResponse;
import de.feelberlin.android.api.service.UserService;
import de.feelberlin.android.manager.UserManager;
import de.feelberlin.android.view.FBEditText;

public class SignUpActivity extends BaseActivity {

    @BindView(R.id.username)
    FBEditText username;
    @BindView(R.id.email)
    FBEditText email;
    @BindView(R.id.password)
    FBEditText password;
    @BindView(R.id.dob)
    FBEditText birthDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_sign_up)
    public void signUpAction() {
        clearErrors();

        UserService userService = new UserService();
        Map<String, Object> options = new HashMap<>();
        options.put("username", username.getString());
        options.put("email", email.getString());
        options.put("password", password.getString());
        options.put("dob", birthDay.getString());

        String deviceId = UserManager.getInstance().getUUID(this);
        options.put("device_token", deviceId);
        userService.register(deviceId, options, registrationHandler);
    }

    private ResultHandler registrationHandler = new ResultHandler() {
        @Override
        public <ResultType> void onSuccess(ResultType result) {
            LoginResponse response = (LoginResponse) result;
            analyzeResponse(response);
        }

        @Override
        public void onError(String errorMessage) {
            Log.e(SignUpActivity.class.getName(), errorMessage);
        }
    };

    private void clearErrors() {
        email.setError(null);
        password.setError(null);
        birthDay.setError(null);
        username.setError(null);
    }

    private void analyzeResponse(LoginResponse response) {

        if (response.errors != null) {
            if (response.errors.email_already_used != null) {
                email.setError(response.errors.email_already_used);
            }
            if (response.errors.email != null) {
                email.setError(response.errors.email);
            }
            if (response.errors.password != null) {
                password.setError(response.errors.password);
            }
            if (response.errors.username != null) {
                birthDay.setError(response.errors.username);
            }
        } else {
            Toast.makeText(this, response.message, Toast.LENGTH_LONG).show();
        }
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
