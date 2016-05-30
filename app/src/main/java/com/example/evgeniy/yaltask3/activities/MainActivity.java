package com.example.evgeniy.yaltask3.activities;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.evgeniy.yaltask3.R;
import com.example.evgeniy.yaltask3.adapters.PagerAdapter;
import com.example.evgeniy.yaltask3.ui.contract.MainActivityContract;
import com.example.evgeniy.yaltask3.ui.presenter.MainActivityPresenter;
import com.example.evgeniy.yaltask3.utils.ServiceApiHolder;
import com.facebook.FacebookSdk;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import io.realm.Realm;


/**
 * Created by Evgeniy
 */
public class MainActivity extends AppCompatActivity implements MainActivityContract.MAView {

    @BindView(R.id.drawer)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.fab)
    FloatingActionButton mFab;

    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.tabs)
    TabLayout mTabLayout;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    private MainActivityContract.MAPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FacebookSdk.sdkInitialize(getApplicationContext());

        ButterKnife.bind(this);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        setTitle(R.string.app_title);

        mPresenter = new MainActivityPresenter(this, this);
        mPresenter.onCreate();

        if (mTabLayout != null) {
            mTabLayout.setupWithViewPager(mViewPager);
        }

        // Adding menu icon to Toolbar
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Set behavior of Navigation drawer
        if (mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        // This method will trigger on item Click of navigation menu
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {
                            // Set item in checked state
                            int id = menuItem.getItemId();

                            switch (id) {
                                case R.id.all_appeals:
                                    break;
                                case R.id.appeals_on_map:
                                    break;
                                case R.id.menu_loginn:
                                    mPresenter.onLoginClick();
                                    break;
                            }
                            mDrawerLayout.closeDrawer(GravityCompat.START);
                            return true;
                        }
                    });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if (id == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void fabClick(View v) {
        Snackbar.make(v, "Snackbar!",
                Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void setPagerAdapter(PagerAdapter adapter) {
        mViewPager.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        Realm realmService = ServiceApiHolder.getRealmService(this);
        if (!realmService.isClosed()) {
            realmService.close();
        }
        super.onDestroy();
    }
}