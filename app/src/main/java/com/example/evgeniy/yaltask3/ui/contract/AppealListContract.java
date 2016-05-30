package com.example.evgeniy.yaltask3.ui.contract;

import android.support.v7.widget.RecyclerView;

import com.example.evgeniy.yaltask3.data.model.AppealEntity;

import java.util.List;

/**
 * Created by Evgeniy
 */
public interface AppealListContract  {

        interface ALModel {

            interface Callback {
                void getResult(List<AppealEntity> data);
            }

            void getDataPage(boolean first, Callback callback);

            void getCachedData(Callback callback);

        }

        interface ALPresenter {

            void init();

            void getNextPage();

         //   void getFirstPage();

         //   boolean isLoading();

        }

        interface ALView {

            void setAdapter(RecyclerView.Adapter adapter);

        }
}
