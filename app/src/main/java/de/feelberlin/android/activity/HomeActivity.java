package de.feelberlin.android.activity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import de.feelberlin.android.Navigator;
import de.feelberlin.android.R;
import de.feelberlin.android.adapter.MenuAdapter;
import de.feelberlin.android.fragment.AboutFragment;
import de.feelberlin.android.fragment.CoolPlacesFragment;
import de.feelberlin.android.fragment.MyTicketFragment;
import de.feelberlin.android.view.MenuOption;
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

public class HomeActivity extends BaseActivity implements DuoMenuView.OnMenuClickListener, ToolbarListener {

    private MenuAdapter menuAdapter;
    private ViewHolder viewHolder;

    private List<MenuOption> options = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewHolder = new ViewHolder();
        setupMenu();
        setupDrawer();
    }

    private void setupMenu() {
        options = new ArrayList<>();
        options.add(new MenuOption(R.drawable.menu_6, getString(R.string.updates))); // 0
        options.add(new MenuOption(R.drawable.menu_4, getString(R.string.cool_places))); // 1
        options.add(new MenuOption(R.drawable.menu_5, getString(R.string.my_ticket))); // 2
        options.add(new MenuOption(R.drawable.menu_3, getString(R.string.about_fb))); // 3

        menuAdapter = new MenuAdapter(options);
        viewHolder.mDuoMenuView.setOnMenuClickListener(this);
        viewHolder.mDuoMenuView.setAdapter(menuAdapter);
    }

    private void setupDrawer() {
        DuoDrawerToggle duoDrawerToggle = new DuoDrawerToggle(this,
                viewHolder.mDuoDrawerLayout,
                null,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        viewHolder.mDuoDrawerLayout.setDrawerListener(duoDrawerToggle);
        viewHolder.mDuoMenuView.setBackground(R.drawable.menu_bg);
        duoDrawerToggle.syncState();

    }

    @Override
    public void onFooterClicked() {
        viewHolder.mDuoDrawerLayout.closeDrawer();
        // TODO: 5/27/17
    }

    @Override
    public void onHeaderClicked() {
        viewHolder.mDuoDrawerLayout.closeDrawer();
        Navigator.navigateToProfile(this);
    }


    @Override
    public void onOptionClicked(int position, Object objectClicked) {
        switch (position) {
            case 1:
                Navigator.setFragment(this, CoolPlacesFragment.class);
                break;
            case 2:
                onActionClick();
                break;
            case 3:
                Navigator.setFragment(this, AboutFragment.class);
                break;
        }

        viewHolder.mDuoDrawerLayout.closeDrawer();
    }

    @Override
    public void onMenuClick() {
        viewHolder.mDuoDrawerLayout.openDrawer();
    }

    @Override
    public void onActionClick() {
        Navigator.setFragment(this, MyTicketFragment.class);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Navigator.REQUEST_CODE_ABOUT) {
            Navigator.setFragment(this, AboutFragment.class);
        }
    }

    private class ViewHolder {
        private DuoDrawerLayout mDuoDrawerLayout;
        private DuoMenuView mDuoMenuView;

        ViewHolder() {
            mDuoDrawerLayout = (DuoDrawerLayout) findViewById(R.id.drawer);
            mDuoMenuView = (DuoMenuView) mDuoDrawerLayout.getMenuView();
        }
    }
}
