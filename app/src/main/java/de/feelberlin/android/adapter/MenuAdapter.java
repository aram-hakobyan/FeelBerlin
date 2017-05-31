package de.feelberlin.android.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import de.feelberlin.android.manager.FontsManager;
import de.feelberlin.android.view.FBTextView;
import de.feelberlin.android.view.MenuOption;

public class MenuAdapter extends BaseAdapter {

    private Context context;
    private List<MenuOption> options = new ArrayList<>();

    public MenuAdapter(Context context, List<MenuOption> options) {
        this.context = context;
        this.options = options;
    }

    @Override
    public int getCount() {
        return options.size();
    }

    @Override
    public Object getItem(int position) {
        return options.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String option = options.get(position).getText();
        final int icon = options.get(position).getDrawable();

        final FBTextView optionView;
        if (convertView == null) {
            optionView = new FBTextView(parent.getContext());
        } else {
            optionView = (FBTextView) convertView;
        }

        optionView.setText(option);
        optionView.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0);
        optionView.setCompoundDrawablePadding(40);
        optionView.setTextColor(Color.parseColor("#FFFFFF"));
        optionView.setTextSize(18);
        optionView.setPadding(90, 160, 0, 0);
        optionView.setTypeface(FontsManager.getInstance().getLight(context));

        return optionView;
    }
}