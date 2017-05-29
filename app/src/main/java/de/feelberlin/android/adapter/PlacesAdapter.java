package de.feelberlin.android.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.feelberlin.android.R;
import de.feelberlin.android.model.Place;
import de.feelberlin.android.view.FBButton;


public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.MyViewHolder> {

    private Context context;
    private List<Place> places;
    private int positionCurrent;
    private PopupWindow popup;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout layout;
        public TextView title;
        public ImageView thumbnail;

        public FBButton viewMap, contact;

        public MyViewHolder(View view) {
            super(view);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            layout = (LinearLayout) view.findViewById(R.id.layout);
            viewMap = (FBButton) view.findViewById(R.id.view_map);
            contact = (FBButton) view.findViewById(R.id.contact);
        }
    }

    public PlacesAdapter(Context context) {
        this.context = context;
        this.places = new ArrayList<>();
    }

    public void addAll(List<Place> list) {
        this.places.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_place, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Place place = places.get(position);

        holder.contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                positionCurrent = position;
                showPopupMenu(holder.contact);
            }
        });
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    private void showPopupMenu(View anchorView) {
        popup = new PopupWindow(context);
        View layout = LayoutInflater.from(context).inflate(R.layout.popup_contact, null);
        popup.setContentView(layout);
        popup.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popup.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        //noinspection deprecation
        popup.setBackgroundDrawable(new BitmapDrawable());
        popup.showAsDropDown(anchorView);

        layout.findViewById(R.id.send_email).setOnClickListener(onPopupItemClickListener);
        layout.findViewById(R.id.call).setOnClickListener(onPopupItemClickListener);
    }

    private void closePopupMenu() {
        if (popup != null)
            popup.dismiss();
    }

    private View.OnClickListener onPopupItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Place place = places.get(positionCurrent);
            switch (v.getId()) {
                case R.id.send_email:
                    // TODO: 5/29/2017
                    break;
                case R.id.call:
                    // TODO: 5/29/2017
                    break;
            }

            closePopupMenu();
        }
    };


}
