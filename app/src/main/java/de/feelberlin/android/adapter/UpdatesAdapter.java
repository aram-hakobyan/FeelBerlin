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


public class UpdatesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int ARTICLE = 0, ARTICLE_WITH_THUMB = 1, VIDEO = 2, GALLERY = 3;

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

    public void clearAll() {
        this.updates.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return updates.size();
    }

    @Override
    public int getItemViewType(int position) {
        Update update = updates.get(position);
        if (update.hasVideo()) {
            return VIDEO;
        }
        return ARTICLE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case ARTICLE:
                View v1 = inflater.inflate(R.layout.card_update_article, viewGroup, false);
                viewHolder = new ViewHolderPost(v1);
                break;
            case ARTICLE_WITH_THUMB:
                View v2 = inflater.inflate(R.layout.card_update_article_with_thumb, viewGroup, false);
                viewHolder = new ViewHolderAd(v2);
                break;
            case VIDEO:
                View v3 = inflater.inflate(R.layout.card_update_article_with_thumb, viewGroup, false);
                viewHolder = new ViewHolderImportantPost(v3);
                break;
            case GALLERY:
                View v4 = inflater.inflate(R.layout.card_update_article_with_thumb, viewGroup, false);
                viewHolder = new ViewHolderPostWithThumb(v4);
                break;
            default:
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case ARTICLE:
                ViewHolderPost vh1 = (ViewHolderPost) viewHolder;
                configureViewHolderArticle(vh1, position);
                break;
            case ARTICLE_WITH_THUMB:
                ViewHolderAd vh2 = (ViewHolderAd) viewHolder;
                configureViewHolderArticleWithThumb(vh2);
                break;
            case VIDEO:
                ViewHolderImportantPost vh3 = (ViewHolderImportantPost) viewHolder;
                configureViewHolderVideo(vh3, position);
                break;
            case GALLERY:
                ViewHolderPostWithThumb vh4 = (ViewHolderPostWithThumb) viewHolder;
                configureViewHolderPostGallery(vh4, position);
                break;
            default:
                break;
        }
    }

    private void configureViewHolderArticle(ViewHolderPost vh1, int position) {
        final Update post = updates.get(position);
        vh1.title.setText("Title");
    }

    private void configureViewHolderArticleWithThumb(ViewHolderAd vh2) {
        // vh2.adView.loadAd(adRequest);
    }

    private void configureViewHolderVideo(ViewHolderImportantPost vh3, int position) {

    }

    private void configureViewHolderPostGallery(ViewHolderPostWithThumb vh4, int position) {

    }

    public class ViewHolderPost extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolderPost(View v) {
            super(v);
           // title = (TextView) v.findViewById(R.id.post_title);
        }
    }

    public class ViewHolderAd extends RecyclerView.ViewHolder {

        public ViewHolderAd(View v) {
            super(v);

        }
    }

    public class ViewHolderImportantPost extends RecyclerView.ViewHolder {
        ImageView image;

        public ViewHolderImportantPost(View v) {
            super(v);
           // image = (ImageView) v.findViewById(R.id.thumbnail);
        }
    }

    public class ViewHolderPostWithThumb extends RecyclerView.ViewHolder {

        public ViewHolderPostWithThumb(View v) {
            super(v);

        }
    }

}
