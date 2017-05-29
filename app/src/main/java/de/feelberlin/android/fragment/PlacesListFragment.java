package de.feelberlin.android.fragment;

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
import de.feelberlin.android.R;
import de.feelberlin.android.adapter.PlacesAdapter;
import de.feelberlin.android.model.Place;
import de.feelberlin.android.util.AppUtils;
import de.feelberlin.android.view.EndlessRecyclerViewScrollListener;
import de.feelberlin.android.view.GridSpacingItemDecoration;

public class PlacesListFragment extends Fragment {

    @BindView(R.id.progress)
    ContentLoadingProgressBar progressBar;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private EndlessRecyclerViewScrollListener scrollListener;
    private PlacesAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_places_list, container, false);
        ButterKnife.bind(this, view);

        adapter = new PlacesAdapter(getContext());

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

    public void loadPosts() {
        progressBar.show();

        // FIXME: 5/29/2017
        List<Place> places = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Place p = new Place();
            places.add(p);
        }

        adapter.addAll(places);
        progressBar.hide();
    }

}
