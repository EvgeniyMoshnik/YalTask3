package com.example.evgeniy.yaltask3.ui.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import java.text.DateFormat;
import java.util.Date;

import com.example.evgeniy.yaltask3.R;
import com.example.evgeniy.yaltask3.adapters.ImageAdapter;
import com.example.evgeniy.yaltask3.data.AppealEntity;
import com.example.evgeniy.yaltask3.ui.view.DetailView;

/**
 * Created by Evgeniy
 */
public class DetailPresenterImpl implements DetailPresenter {

    private Context mContext;
    private DetailView mDetailView;
    private AppealEntity mEntity;

    private String mEmptyString;

    public DetailPresenterImpl(Context context) {
        mContext = context;

        mEmptyString = context.getString(R.string.emptyString);
    }

    @Override
    public void onCreate(Intent intent, DetailView detailView) {
        mDetailView = detailView;

        mEntity = (AppealEntity) intent.getSerializableExtra(mContext.getString(R.string.key_for_entity));

        if(mEntity != null){
            setEntityData();
        } else {
            mDetailView.closeView();
        }


    }

    @Override
    public void onDestroy() {

    }


    @Override
    public void onModelChange() {
        setEntityData();
    }

    private  void setEntityData() {
        DateFormat dateFormat = android.text.format.DateFormat.getMediumDateFormat(mContext);
        Date tempDt = mEntity.getRegistered();
        String valueRegistered = (tempDt != null) ? dateFormat.format(tempDt) : mEmptyString;
        tempDt = mEntity.getCreated();
        String valueCreated = (tempDt != null) ? dateFormat.format(tempDt) : mEmptyString;

        tempDt = mEntity.getDeadline();
        String valueDeadline = (tempDt != null) ? dateFormat.format(tempDt) : mEmptyString;

        mDetailView.setTitle(mEntity.getNumber());
        String strCategory = mEntity.getCategory();
        String strResponsible = mEntity.getResponsible();
        String strDescription = mEntity.getFullText();

        String strState;
        switch (mEntity.getState()) {
            case IN_WORK:
                strState = mContext.getString(R.string.str_in_work);
                break;
            case DONE:
                strState = mContext.getString(R.string.str_done);
                break;
            case WAIT:
                strState = mContext.getString(R.string.str_wait);
                break;
            default:
                strState = mEmptyString;
                break;
        }

        mDetailView.setValues(valueCreated, valueRegistered, valueDeadline,
                strCategory, strResponsible, strDescription, strState);

        RecyclerView.Adapter mAdapter = new ImageAdapter(mContext, mEntity.getImages());

        mDetailView.setAdapter(mAdapter);


    }

}

