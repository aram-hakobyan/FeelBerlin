package de.feelberlin.android.activity;

import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.Switch;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.feelberlin.android.R;

public class NotificationSettingsActivity extends BaseActivity implements Switch.OnCheckedChangeListener {

    @BindView(R.id.switch_ntf)
    SwitchCompat switchNtf;

    @BindView(R.id.switch_vibrate)
    SwitchCompat switchVibrate;

    @BindView(R.id.switch_sound)
    SwitchCompat switchSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_settings);
        ButterKnife.bind(this);

        switchNtf.setOnCheckedChangeListener(this);
        switchVibrate.setOnCheckedChangeListener(this);
        switchSound.setOnCheckedChangeListener(this);
    }

    @OnClick(R.id.back)
    public void backAction() {
        finish();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.switch_ntf:
                // TODO: 5/28/17
                break;
            case R.id.switch_vibrate:
                // TODO: 5/28/17
                break;
            case R.id.switch_sound:
                // TODO: 5/28/17
                break;
        }
    }
}
