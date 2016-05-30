package com.example.evgeniy.yaltask3.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.evgeniy.yaltask3.R;
<<<<<<< HEAD
import com.example.evgeniy.yaltask3.ui.contract.DetailContract;
import com.example.evgeniy.yaltask3.ui.presenter.DetailPresenter;
=======
import com.example.evgeniy.yaltask3.ui.presenter.DetailPresenter;
import com.example.evgeniy.yaltask3.ui.presenter.DetailPresenterImpl;
import com.example.evgeniy.yaltask3.ui.view.DetailView;
>>>>>>> 97f039340c747a39b8c3773db3fb5e50edfa06cc


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Evgeniy
 */
<<<<<<< HEAD
public class DetailActivity extends AppCompatActivity implements DetailContract.DDView {

    @BindView(R.id.communal_services)
    TextView mTV_ValueCategory;
    @BindView(R.id.dnipropetrovsk)
    TextView mTV_ValueResponsible;
    @BindView(R.id.problem_description)
    TextView mTV_Description;
    @BindView(R.id.textInWorking)
    TextView mTV_ValueStatus;

    @BindView(R.id.creation_date)
    TextView mTV_ValueCreated;
    @BindView(R.id.registration_date)
    TextView mTV_ValueRegistered;
    @BindView(R.id.deadline)
    TextView mTV_ValueDeadline;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar_actionbar)
    Toolbar mToolbar;
=======
public class DetailActivity extends AppCompatActivity implements DetailView {

    @BindView(R.id.communal_services) TextView mTV_ValueCategory;
    @BindView(R.id.dnipropetrovsk) TextView mTV_ValueResponsible;
    @BindView(R.id.problem_description) TextView mTV_Description;
    @BindView(R.id.textInWorking) TextView mTV_ValueStatus;

    @BindView(R.id.creation_date) TextView mTV_ValueCreated;
    @BindView(R.id.registration_date) TextView mTV_ValueRegistered;
    @BindView(R.id.deadline) TextView mTV_ValueDeadline;

    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
    @BindView(R.id.toolbar_actionbar) Toolbar mToolbar;

    private DetailPresenter mDetailPresenter;
>>>>>>> 97f039340c747a39b8c3773db3fb5e50edfa06cc

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
<<<<<<< HEAD
        DetailContract.DDPresenter mDetailPresenter = new DetailPresenter(this);
        mDetailPresenter.onCreate(getIntent(), this);

        initRecyclerView();
    }

    // Initialize RecyclerView
    public void initRecyclerView() {
=======
        mDetailPresenter = new DetailPresenterImpl(this);
        mDetailPresenter.onCreate(getIntent(), this);

        initRecyclerView();




      //  Intent intent = getIntent();
      //  AppealEntity entity = (AppealEntity) intent.getSerializableExtra(getString(R.string.key_for_entity));

     //   if (entity != null) {
     //       setEntityData(entity, toolbar);
      //  } else {
      //      finish();
      //  }
    }



    // Initialize RecyclerView
    public void initRecyclerView() {

>>>>>>> 97f039340c747a39b8c3773db3fb5e50edfa06cc

        if (mRecyclerView != null) {
            mRecyclerView.setHasFixedSize(true);

            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            mRecyclerView.setLayoutManager(mLayoutManager);
        }
    }

    // Back button close application
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    // onClick for views
    public void toastShow(View v) {
        String toastMessage = v.getClass().getSimpleName();
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void closeView() {
        finish();
    }

    @Override
    public void setTitle(String title) {
        if (mToolbar != null) {
            mToolbar.setTitle(title);
        }
<<<<<<< HEAD
=======

>>>>>>> 97f039340c747a39b8c3773db3fb5e50edfa06cc
    }

    @Override
    public void setValues(String valueCreated, String valueRegistered, String valueDeadline,
                          String strCategory, String strResponsible, String strDescription, String strState) {

        mTV_ValueRegistered.setText(valueRegistered);
        mTV_ValueCreated.setText(valueCreated);
        mTV_ValueDeadline.setText(valueDeadline);

        mTV_ValueCategory.setText(strCategory);
        mTV_ValueResponsible.setText(strResponsible);
        mTV_Description.setText(strDescription);
        mTV_ValueStatus.setText(strState);
    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {
        mRecyclerView.setAdapter(adapter);
<<<<<<< HEAD
    }

=======

    }

    @Override
    public void onClick(View view) {

    }
>>>>>>> 97f039340c747a39b8c3773db3fb5e50edfa06cc
}
