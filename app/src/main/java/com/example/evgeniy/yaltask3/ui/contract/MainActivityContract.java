package com.example.evgeniy.yaltask3.ui.contract;


import android.support.v4.app.FragmentManager;

import com.example.evgeniy.yaltask3.adapters.PagerAdapter;


/**
 * Created by Evgeniy
 */
public interface MainActivityContract {
    

    interface MAPresenter {

        void onCreate();

        void onLoginClick();
    }

    interface MAView {

        FragmentManager getSupportFragmentManager();

        void setPagerAdapter(PagerAdapter adapter);
    }
}
