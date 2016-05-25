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
import com.example.evgeniy.yaltask3.data.AppealEntity;
import com.example.evgeniy.yaltask3.data.State;
import com.example.evgeniy.yaltask3.fragments.AppealRecyclerFragment;
import com.example.evgeniy.yaltask3.rest.ApiService;
import com.example.evgeniy.yaltask3.rest.RestClientHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Evgeniy
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.drawer) DrawerLayout mDrawerLayout;
    @BindView(R.id.fab) FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        setTitle(R.string.app_title);

        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        if (tabs != null) {
            tabs.setupWithViewPager(viewPager);
        }

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
       // mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        // Adding menu icon to Toolbar
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Set behavior of Navigation drawer
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        // This method will trigger on item Click of navigation menu
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {
                            // Set item in checked state
                            menuItem.setChecked(true);
                            // Closing drawer on item click
                            mDrawerLayout.closeDrawers();
                            return true;
                        }
                    });
        }
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



    }


}