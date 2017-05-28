package de.feelberlin.android.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import de.feelberlin.android.R;
import de.feelberlin.android.activity.ToolbarListener;
import de.feelberlin.android.util.AppUtils;

/**
 * Created by Apple on 5/28/17.
 */

public class AboutFragment extends Fragment {

    private ToolbarListener toolbarListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (getActivity() instanceof ToolbarListener) {
            toolbarListener = (ToolbarListener) getActivity();
        }
    }

    @OnClick(R.id.btn_menu)
    public void menuAction() {
        if (toolbarListener != null)
            toolbarListener.onMenuClick();
    }

    @OnClick(R.id.toolbar_action)
    public void ticketAction() {
        if (toolbarListener != null)
            toolbarListener.onActionClick();
    }

    @OnClick(R.id.set_alarm)
    public void setAlarmAction() {
        AppUtils.setAlarm(getContext());
    }

    @OnClick(R.id.about_share)
    public void shareAboutAction() {
        // TODO: 5/28/17
    }

    @OnClick(R.id.btn_see_agenda)
    public void seeAgendaAction() {
        // TODO: 5/28/17
    }
}
