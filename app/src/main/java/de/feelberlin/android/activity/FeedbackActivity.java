package de.feelberlin.android.activity;

import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.feelberlin.android.R;
import de.feelberlin.android.view.FBButton;

public class FeedbackActivity extends BaseActivity {

    @BindView(R.id.input)
    AppCompatEditText input;

    @BindView(R.id.btn_send)
    FBButton btnSendFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ButterKnife.bind(this);

        input.addTextChangedListener(textWatcher);
    }

    @OnClick(R.id.btn_send)
    public void sendFeedback() {
        if (input.getText() == null || TextUtils.isEmpty(input.getText().toString()))
            return;

        // TODO: 5/28/17
    }

    @OnClick(R.id.back)
    public void backAction() {
        finish();
    }

    private TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            btnSendFeedback.setVisibility(s.length() != 0 ? View.VISIBLE : View.GONE);
        }
    };
}
