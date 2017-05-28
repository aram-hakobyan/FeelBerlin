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
import de.feelberlin.android.Navigator;
import de.feelberlin.android.R;
import de.feelberlin.android.activity.BaseActivity;
import de.feelberlin.android.activity.ToolbarListener;

/**
 * Created by Apple on 5/28/17.
 */

public class MyTicketFragment extends Fragment {

    private ToolbarListener toolbarListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_ticket, container, false);
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
        downloadAction();
    }

    @OnClick(R.id.btn_download)
    public void downloadAction() {
        // TODO: 5/28/17
    }

    @OnClick(R.id.edit_profile)
    public void editProfileAction() {
        Navigator.navigateToProfile((BaseActivity) getActivity());
    }
}
