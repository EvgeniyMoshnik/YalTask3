package com.example.evgeniy.yaltask3.ui.contract;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Evgeniy
 */
public interface DetailContract {

    interface DDModel extends Serializable{

        long getId();

        String getTitle();

        String getState();

        List<String> getUrlList();

        String getDescription();

        String getResponsible();

        String getCategory();

        String getStartDate();

        String getCreatedDate();

        String getDeadline();

    }

    interface DDPresenter {

        void onCreate(Intent intent, DDView dataView);

    }

    interface DDView {


        void closeView();

        void setTitle(String title);

        void setValues(String valueCreated, String valueRegistered, String valueDeadline,
                       String strCategory, String strResponsible, String strDescription, String strState);

        void setAdapter(RecyclerView.Adapter adapter);


    }
}
