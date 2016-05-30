package com.example.evgeniy.yaltask3.ui.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Evgeniy
 */
public interface DetailView {

    void closeView();

    void setTitle(String title);

    void setValues(String valueCreated, String valueRegistered, String valueDeadline,
                   String strCategory, String strResponsible, String strDescription, String strState);

    void setAdapter(RecyclerView.Adapter adapter);

    void onClick(View view);

}
