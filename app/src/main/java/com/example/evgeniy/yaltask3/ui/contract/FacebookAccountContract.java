package com.example.evgeniy.yaltask3.ui.contract;

import android.app.Activity;
import android.content.Intent;

import com.facebook.Profile;

/**
 * Created by Evgeniy
 */
public interface FacebookAccountContract {

    interface FPresenter {

        void onCreate();

        void onActivityResult(int requestCode, int resultCode, Intent data);

        void logOut();

        void onDestroy();
    }

    interface FView {

        void updateViews(Profile profile);

        void finish();
        
        Activity getActivity();

    }
}
