package com.example.evgeniy.yaltask3.ui.presenter;

import android.content.Intent;

import com.example.evgeniy.yaltask3.ui.view.DetailView;

/**
 * Created by Evgeniy
 */
public interface DetailPresenter {

    void onCreate(Intent intent, DetailView detailView);

    void onDestroy();

    void onModelChange();
}
