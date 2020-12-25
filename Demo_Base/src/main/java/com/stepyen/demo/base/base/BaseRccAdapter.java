package com.stepyen.demo.base.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * date：2019/6/24
 * author：stepyen
 * description：
 */
public abstract class BaseRccAdapter<T> extends RecyclerView.Adapter<BaseRccViewHolder> {

    protected final List<T> mData = new ArrayList<>();
    private OnItemClickListener mClickListener;
    private OnItemLongClickListener mLongClickListener;

    /**
     * 当前点击的条目
     */
    private int mLastPosition = -1;

    public BaseRccAdapter() {
        this(null);
    }

    public BaseRccAdapter(List<T> list) {
        if (list != null) {
            mData.addAll(list);
        }


    }

    @NonNull
    @Override
    public BaseRccViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final BaseRccViewHolder holder = new BaseRccViewHolder(LayoutInflater.from(parent.getContext()).inflate(getItemLayoutId(viewType), parent, false));
        if (mClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickListener.onItemClick(holder.itemView, holder.getLayoutPosition());
                }
            });
        }
        if (mLongClickListener != null) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mLongClickListener.onItemLongClick(holder.itemView, holder.getLayoutPosition());
                    return true;
                }
            });
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseRccViewHolder holder, int position) {
        bindData(holder, position, mData.get(position));
    }

    public T getItem(int pos) {
        return mData.get(pos);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public BaseRccAdapter add(int pos, T item) {
        mData.add(pos, item);
        notifyItemInserted(pos);
        return this;
    }

    public BaseRccAdapter delete(int pos) {
        mData.remove(pos);
        notifyItemRemoved(pos);
        return this;
    }

    public BaseRccAdapter<T> refresh(Collection<T> collection) {
        if (collection != null) {
            mData.clear();
            mData.addAll(collection);
            notifyDataSetChanged();
            mLastPosition = -1;
        }
        return this;
    }

    public BaseRccAdapter<T> loadMore(Collection<T> collection) {
        if (collection != null) {
            mData.addAll(collection);
            notifyDataSetChanged();
        }
        return this;
    }

    public BaseRccAdapter<T> load(T item) {
        if (item != null) {
            mData.add(item);
            notifyDataSetChanged();
        }
        return this;
    }

    public BaseRccAdapter setOnItemClickListener(OnItemClickListener listener) {
        mClickListener = listener;
        return this;
    }

    public BaseRccAdapter setOnItemLongClickListener(OnItemLongClickListener listener) {
        mLongClickListener = listener;
        return this;
    }

    /**
     * 适配的布局
     *
     * @param viewType
     * @return
     */
    abstract public int getItemLayoutId(int viewType);

    public int getLastPosition() {
        return mLastPosition;
    }

    public BaseRccAdapter<T> setLastPosition(int lastPosition) {
        mLastPosition = lastPosition;
        return this;
    }

    /**
     * 绑定数据
     *
     * @param holder
     * @param position
     * @param item
     */
    abstract public void bindData(BaseRccViewHolder holder, int position, T item);

    public interface OnItemClickListener {
        /**
         * 条目点击
         *
         * @param itemView
         * @param pos
         */
        void onItemClick(View itemView, int pos);
    }

    public interface OnItemLongClickListener {
        /**
         * 条目长按
         *
         * @param itemView
         * @param pos
         */
        void onItemLongClick(View itemView, int pos);
    }
}