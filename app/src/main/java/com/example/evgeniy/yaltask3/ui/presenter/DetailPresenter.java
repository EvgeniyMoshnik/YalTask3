package com.example.evgeniy.yaltask3.ui.presenter;

<<<<<<< HEAD
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

import com.example.evgeniy.yaltask3.R;
import com.example.evgeniy.yaltask3.adapters.ImageAdapter;
import com.example.evgeniy.yaltask3.ui.contract.DetailContract;
=======
import android.content.Intent;

import com.example.evgeniy.yaltask3.ui.view.DetailView;
>>>>>>> 97f039340c747a39b8c3773db3fb5e50edfa06cc

/**
 * Created by Evgeniy
 */
<<<<<<< HEAD
public class DetailPresenter implements DetailContract.DDPresenter {

    private Context mContext;

    private DetailContract.DDView mDetailView;
    private DetailContract.DDModel mModel;


    public DetailPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate(Intent intent, DetailContract.DDView detailView) {
        mDetailView = detailView;

        Serializable data = intent.getSerializableExtra(mContext.getString(R.string.key_for_entity));

        if (data != null && data instanceof DetailContract.DDModel) {
                        mModel = (DetailContract.DDModel) data;
            setEntityData();
        } else {
            mDetailView.closeView();
        }
    }
  //  @Override
  //  public void onDestroy() {

 //   }


    private void setEntityData() {

        mDetailView.setTitle(mModel.getTitle());

        mDetailView.setValues(mModel.getCreatedDate(),
                mModel.getStartDate(),
                mModel.getDeadline(),
                mModel.getCategory(),
                mModel.getResponsible(),
                mModel.getDescription(),
                mModel.getState());


        List<String> urlList = mModel.getUrlList();
        RecyclerView.Adapter adapter = new ImageAdapter(mContext, urlList);

        mDetailView.setAdapter(adapter);


    }

}

=======
public interface DetailPresenter {

    void onCreate(Intent intent, DetailView detailView);

    void onDestroy();

    void onModelChange();
}
>>>>>>> 97f039340c747a39b8c3773db3fb5e50edfa06cc
