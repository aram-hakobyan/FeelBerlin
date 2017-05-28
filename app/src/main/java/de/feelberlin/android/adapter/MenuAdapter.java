package de.feelberlin.android.adapter;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import de.feelberlin.android.view.FBTextView;
import de.feelberlin.android.view.MenuOption;

public class MenuAdapter extends BaseAdapter {
    private List<MenuOption> mOptions = new ArrayList<>();

    public MenuAdapter(List<MenuOption> options) {
        mOptions = options;
    }

    @Override
    public int getCount() {
        return mOptions.size();
    }

    @Override
    public Object getItem(int position) {
        return mOptions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String option = mOptions.get(position).getText();
        final int icon = mOptions.get(position).getDrawable();

        final FBTextView optionView;
        if (convertView == null) {
            optionView = new FBTextView(parent.getContext());
        } else {
            optionView = (FBTextView) convertView;
        }

        optionView.setText(option);
        optionView.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0);
        optionView.setCompoundDrawablePadding(20);
        optionView.setTextColor(Color.parseColor("#FFFFFF"));
        optionView.setTextSize(18);
        optionView.setPadding(70, 60, 0, 0);

        return optionView;
    }
}