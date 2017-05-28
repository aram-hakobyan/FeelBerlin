package de.feelberlin.android.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.feelberlin.android.R;
import de.feelberlin.android.activity.ToolbarListener;
import de.feelberlin.android.view.FBTextView;

/**
 * Created by Apple on 5/28/17.
 */

public class CoolPlacesFragment extends Fragment {

    @BindView(R.id.toolbar_title)
    FBTextView title;
    @BindView(R.id.toolbar_action)
    AppCompatImageView action;

    private ToolbarListener toolbarListener;
    private boolean isList;
    private Dialog dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cool_places, container, false);
        ButterKnife.bind(this, view);

        title.setText(R.string.cool_places);
        showList();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (getActivity() instanceof ToolbarListener) {
            toolbarListener = (ToolbarListener) getActivity();
        }
    }

    private void showList() {
        action.setImageResource(R.drawable.menu_list);
        isList = true;
    }

    private void showMap() {
        action.setImageResource(R.drawable.menu_map);
        isList = false;
    }

    @OnClick(R.id.btn_menu)
    public void menuAction() {
        if (toolbarListener != null)
            toolbarListener.onMenuClick();
    }

    @OnClick(R.id.toolbar_action)
    public void actionClick() {
        if (isList) {
            showMap();
        } else {
            showList();
        }
    }

    @OnClick(R.id.filter)
    public void showFilterMenu() {
        dialog = new Dialog(getActivity(),
                R.style.DialogSlideAnim);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().clearFlags(
                WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_filter);

        ButterKnife.findById(dialog, R.id.btn_close).setOnClickListener(onClickListener);

        if (!dialog.isShowing())
            dialog.show();

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        window.setAttributes(lp);
    }

    private void closeFilterMenu() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_close:
                    closeFilterMenu();
                    break;
            }
        }
    };


}
