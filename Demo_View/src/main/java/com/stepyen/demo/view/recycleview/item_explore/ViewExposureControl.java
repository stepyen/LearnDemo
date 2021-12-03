package com.stepyen.demo.view.recycleview.item_explore;

import android.text.TextUtils;

/**
 * date：2021/12/2
 * author：stepyen
 * description：
 */
public abstract class ViewExposureControl {
    private boolean isVisible;
    private boolean hasAttachedToWindow;
    private boolean dataChange;
    private String mKey;


    public void setVisible(boolean visible){
        if(isVisible == visible){
            return;
        }
        isVisible = visible;

        if(isVisible && hasAttachedToWindow && !TextUtils.isEmpty(mKey)){
            dataChange = false;
            onViewShow();
        }
    }

    public void onAttachedToWindow() {
        hasAttachedToWindow = true;

        if(isVisible && dataChange && hasAttachedToWindow){
            dataChange = false;
            onViewShow();
        }
    }

    public void onDetachedFromWindow() {
        hasAttachedToWindow = false;
        if(!TextUtils.isEmpty(mKey)){
            //已设置过数据 在列表中移除后  标记数据变动 重新添加后 重新刷新状态
            dataChange = true;
        }
    }

    public void onDataChanged(String key){
        if(TextUtils.equals(mKey,key)){
            return;
        }
        mKey = key;
        dataChange = true;
        if(isVisible && dataChange && hasAttachedToWindow){
            dataChange = false;
            onViewShow();
        }
    }

    public abstract void onViewShow();
}
