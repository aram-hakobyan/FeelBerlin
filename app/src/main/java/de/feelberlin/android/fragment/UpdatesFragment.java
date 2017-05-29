package de.feelberlin.android.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.feelberlin.android.R;
import de.feelberlin.android.activity.ToolbarListener;
import de.feelberlin.android.adapter.UpdatesAdapter;
import de.feelberlin.android.model.Update;
import de.feelberlin.android.util.AppUtils;
import de.feelberlin.android.view.EndlessRecyclerViewScrollListener;
import de.feelberlin.android.view.GridSpacingItemDecoration;

public class UpdatesFragment extends Fragment {

    @BindView(R.id.progress)
    ContentLoadingProgressBar progressBar;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private ToolbarListener toolbarListener;
    private EndlessRecyclerViewScrollListener scrollListener;
    private UpdatesAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_updates, container, false);
        ButterKnife.bind(this, view);

        adapter = new UpdatesAdapter(getContext());

        GridLayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, AppUtils.dpToPx(getContext(), 10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        scrollListener = new EndlessRecyclerViewScrollListener(mLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                loadPosts();
            }
        };
        recyclerView.addOnScrollListener(scrollListener);

        loadPosts();
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

    public void loadPosts() {
        progressBar.show();

        // FIXME: 5/29/2017
        List<Update> updates = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Update p = new Update();
            updates.add(p);
        }

        adapter.addAll(updates);
        progressBar.hide();
    }

}
