package de.feelberlin.android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.feelberlin.android.R;
import de.feelberlin.android.model.Update;
import de.feelberlin.android.view.FBButton;


public class UpdatesAdapter extends RecyclerView.Adapter<UpdatesAdapter.MyViewHolder> {

    private Context context;
    private List<Update> updates;
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

    public UpdatesAdapter(Context context) {
        this.context = context;
        this.updates = new ArrayList<>();
    }

    public void addAll(List<Update> list) {
        this.updates.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_update_article, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Update update = updates.get(position);

        holder.contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                positionCurrent = position;
            }
        });
    }

    @Override
    public int getItemCount() {
        return updates.size();
    }

}
