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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.evgeniy.yaltask3.R;
import com.example.evgeniy.yaltask3.adapters.PagerAdapter;
<<<<<<< HEAD
import com.example.evgeniy.yaltask3.ui.contract.MainActivityContract;
import com.example.evgeniy.yaltask3.ui.presenter.MainActivityPresenter;
import com.example.evgeniy.yaltask3.utils.ServiceApiHolder;
import com.facebook.FacebookSdk;

=======
import com.example.evgeniy.yaltask3.data.AppealEntity;
import com.example.evgeniy.yaltask3.data.State;
import com.example.evgeniy.yaltask3.fragments.AppealRecyclerFragment;
import com.example.evgeniy.yaltask3.rest.ApiService;
import com.example.evgeniy.yaltask3.rest.RestClientHolder;

import java.util.List;
>>>>>>> 97f039340c747a39b8c3773db3fb5e50edfa06cc

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
<<<<<<< HEAD
import io.realm.Realm;
=======
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
>>>>>>> 97f039340c747a39b8c3773db3fb5e50edfa06cc

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

<<<<<<< HEAD
    private MainActivityContract.MAPresenter mPresenter;
=======
    @BindView(R.id.drawer) DrawerLayout mDrawerLayout;
    @BindView(R.id.fab) FloatingActionButton mFab;
>>>>>>> 97f039340c747a39b8c3773db3fb5e50edfa06cc

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        FacebookSdk.sdkInitialize(getApplicationContext());
=======
>>>>>>> 97f039340c747a39b8c3773db3fb5e50edfa06cc
        ButterKnife.bind(this);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        setTitle(R.string.app_title);

        mPresenter = new MainActivityPresenter(this, this);
        mPresenter.onCreate();

        if (mTabLayout != null) {
            mTabLayout.setupWithViewPager(mViewPager);
        }

<<<<<<< HEAD
=======
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
       // mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);

>>>>>>> 97f039340c747a39b8c3773db3fb5e50edfa06cc
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
<<<<<<< HEAD
=======
        //Set FAB
       // mFab = (FloatingActionButton) findViewById(R.id.fab);
      //  mFab.setOnClickListener(new View.OnClickListener() {
     //       @Override
     //       public void onClick(View v) {
      //          Snackbar.make(v, "Snackbar!",
       //                 Snackbar.LENGTH_LONG).show();
        //    }
       // });
    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(AppealRecyclerFragment.getInstance(State.IN_WORK), getResources().getString(R.string.tab_1));
        adapter.addFragment(AppealRecyclerFragment.getInstance(State.DONE), getResources().getString(R.string.tab_2));
        adapter.addFragment(AppealRecyclerFragment.getInstance(State.WAIT), getResources().getString(R.string.tab_3));
        viewPager.setAdapter(adapter);
>>>>>>> 97f039340c747a39b8c3773db3fb5e50edfa06cc
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

<<<<<<< HEAD
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
=======
   // public FloatingActionButton getFloatingActionButton() {
    //    return mFab;
  //  }


    @OnClick(R.id.fab)
    public void fabClick (View v){

        ApiService client = RestClientHolder.getService(this);

        Call<List<AppealEntity>> call = client.getInProgress();

        call.enqueue(new Callback<List<AppealEntity>>() {
            @Override
            public void onResponse(Call<List<AppealEntity>> call, Response<List<AppealEntity>> response) {
                Log.d("REST", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<AppealEntity>> call, Throwable t) {
                Log.d("REST ERROR", t.getLocalizedMessage());
            }
        });



>>>>>>> 97f039340c747a39b8c3773db3fb5e50edfa06cc
    }


}