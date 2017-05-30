package de.feelberlin.android.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

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

public class UpdatesFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.progress)
    ContentLoadingProgressBar progressBar;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    private EndlessRecyclerViewScrollListener scrollListener;
    private UpdatesAdapter adapter;
    private Dialog dialog;

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

        if (getActivity() instanceof ToolbarListener) {
            adapter.setToolbarListener((ToolbarListener) getActivity());
        }

        scrollListener = new EndlessRecyclerViewScrollListener(mLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                loadPosts();
            }
        };
        recyclerView.addOnScrollListener(scrollListener);

        swipeRefreshLayout.setColorSchemeResources(
                R.color.colorPrimary,
                R.color.colorPrimaryDark);
        swipeRefreshLayout.setOnRefreshListener(this);

        loadPosts();
        return view;
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
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        adapter.clearAll();
        loadPosts();
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
        dialog.setContentView(R.layout.dialog_filter_updates);

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
