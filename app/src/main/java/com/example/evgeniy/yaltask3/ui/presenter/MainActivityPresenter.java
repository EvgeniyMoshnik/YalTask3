package com.example.evgeniy.yaltask3.ui.presenter;

import android.content.Context;
import android.content.Intent;

import com.example.evgeniy.yaltask3.R;
import com.example.evgeniy.yaltask3.activities.FacebookAccountActivity;
import com.example.evgeniy.yaltask3.adapters.PagerAdapter;
import com.example.evgeniy.yaltask3.fragments.AppealRecyclerFragment;
import com.example.evgeniy.yaltask3.ui.contract.MainActivityContract;


/**
 * Created by Evgeniy
 */
public class MainActivityPresenter implements MainActivityContract.MAPresenter {

    private MainActivityContract.MAView mView;
    private Context mContext;

    public MainActivityPresenter(Context context, MainActivityContract.MAView view) {
        mContext = context;
        mView = view;
    }

    @Override
    public void onCreate() {
        PagerAdapter adapter = new PagerAdapter(mView.getSupportFragmentManager());

        adapter.addFragment(AppealRecyclerFragment.getInstance(mContext.getString(R.string.in_progress_filter)),mContext. getResources().getString(R.string.tab_1));
        adapter.addFragment(AppealRecyclerFragment.getInstance(mContext.getString(R.string.done_filter)), mContext.getResources().getString(R.string.tab_2));
        adapter.addFragment(AppealRecyclerFragment.getInstance(mContext.getString(R.string.wait_filter)), mContext.getResources().getString(R.string.tab_3));

        mView.setPagerAdapter(adapter);
    }

    @Override
    public void onLoginClick() {
        mContext.startActivity(new Intent(mContext, FacebookAccountActivity.class));
    }
}
