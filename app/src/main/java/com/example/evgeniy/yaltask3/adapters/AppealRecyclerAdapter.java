package com.example.evgeniy.yaltask3.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.evgeniy.yaltask3.R;
import com.example.evgeniy.yaltask3.data.model.AppealEntity;
import com.example.evgeniy.yaltask3.utils.ServiceApiHolder;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Evgeniy
 */
public class AppealRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<AppealEntity> mModel;

    private OnItemClickListener mOnItemClickListener;
    private DateFormat mFormatter;

    private String mDays;
    private String mEmptyString;

    private static final int ITEM = 1;
    private static final int PROGRESS = 0;

    public AppealRecyclerAdapter(Context context, OnItemClickListener listener) {
        mContext = context;
        mOnItemClickListener = listener;
        mFormatter = ServiceApiHolder.getFormatter(context);
        mModel = new ArrayList<>();

        mDays = mContext.getResources().getString(R.string.days);
        mEmptyString = context.getString(R.string.emptyString);
    }

    public void setModel(List<AppealEntity> model) {
        mModel = model;
    }


    public boolean addAll(Collection<? extends AppealEntity> collection) {
        return mModel.addAll(collection);
    }

    public int size() {
        return mModel.size();
    }

    public void clear() {
        mModel.clear();
    }

    public void add(AppealEntity object) {
        mModel.add(object);
    }

    public void remove(int location) {
        mModel.remove(location);
    }

    public boolean contains(AppealEntity entity) {
        return mModel.contains(entity);
    }

    public class AppealViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

<<<<<<< HEAD
        @BindView(R.id.category_title)
        TextView mTvCategoryTitle;
        @BindView(R.id.task_desc)
        TextView mTvTaskDesc;
        @BindView(R.id.amount_days)
        TextView mTvDaysAmount;
        @BindView(R.id.date_created)
        TextView mTvDateCreated;
        @BindView(R.id.likes_amount)
        TextView mTvLikesAmount;
        @BindView(R.id.category_icon)
        ImageView mIvCategoryIcon;
=======
        @BindView(R.id.category_title) TextView mTvCategoryTitle;
        @BindView(R.id.task_desc) TextView mTvTaskDesc;
        @BindView(R.id.amount_days) TextView mTvDaysAmount;
        @BindView(R.id.date_created) TextView mTvDateCreated;
        @BindView(R.id.likes_amount) TextView mTvLikesAmount;
        @BindView(R.id.category_icon) ImageView mIvCategoryIcon;
>>>>>>> 97f039340c747a39b8c3773db3fb5e50edfa06cc

        public AppealViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(mModel.get(position));
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mModel.get(position) != null ? ITEM : PROGRESS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        RecyclerView.ViewHolder result = null;

        switch (viewType) {
            case ITEM:
                v = LayoutInflater.from(mContext).inflate(R.layout.item_list_card, parent, false);
                result = new AppealViewHolder(v);
                break;
            case PROGRESS:
                v = LayoutInflater.from(mContext).inflate(R.layout.progress_item, parent, false);
                result = new ProgressViewHolder(v);
                break;
        }
        return result;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder vHolder, int position) {

        if (vHolder instanceof AppealViewHolder) {
            AppealEntity appealEntity = mModel.get(position);
            AppealViewHolder holder = (AppealViewHolder) vHolder;

            holder.mTvCategoryTitle.setText(appealEntity.getCategory().getName());
            holder.mTvTaskDesc.setText(appealEntity.getBody());
            holder.mTvLikesAmount.setText(String.valueOf(appealEntity.getLikesCounter()));
            holder.mTvDateCreated.setText(mFormatter.format(appealEntity.getCreatedDate()));

            Picasso.with(mContext)
                    .load(R.drawable.ic_doc)
                    .into(holder.mIvCategoryIcon);

            Date date = appealEntity.getCreatedDate();

            int daysAmount = -1;
            if (date != null) {
                daysAmount = (int) TimeUnit.DAYS
                        .convert(System.currentTimeMillis() - date.getTime(), TimeUnit.MILLISECONDS);
           }

            holder.mTvDaysAmount.setText((daysAmount > -1) ? String.valueOf(daysAmount)
                    .concat(" ").concat(mDays) : mEmptyString);

        } else {
            ((ProgressViewHolder) vHolder).mProgressBar.setIndeterminate(true);
        }

    }

    @Override
    public int getItemCount() {
        return mModel.size();
    }

    public interface OnItemClickListener {
        void onItemClick(AppealEntity entity);
    }

    public class ProgressViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.progress_bar2)
        ProgressBar mProgressBar;

        public ProgressViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
