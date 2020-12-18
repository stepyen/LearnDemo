package com.stepyen.demo.view.dialog;


import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;

import com.stepyen.demo.base.base.BaseDialog;
import com.stepyen.demo.base.utils.L;
import com.stepyen.demo.base.utils.ViewHelp;
import com.stepyen.demo.view.R;
import com.stepyen.xutil.display.DensityUtils;

/**
 * date：2020/10/23
 * author：stepyen
 * description：研究dialog的生命周期
 */
public class DialogLifeCycleDialog extends Dialog {


    private static final String TAG = "DialogLifeCycleDialog";

    private ViewGroup contentView;
    protected Context mContext;

    public DialogLifeCycleDialog(Context context, int layoutId) {
        this(context, R.style.CommonDialog, layoutId);
    }

    public DialogLifeCycleDialog(Context context, View contentView) {
        this(context, R.style.CommonDialog, contentView);
    }

    public DialogLifeCycleDialog(Context context) {
        super(context, R.style.CommonDialog);
    }

    public DialogLifeCycleDialog(Context context, int theme, int layoutId) {
        super(context, theme);
        mContext = context;
        init(layoutId);
    }

    public DialogLifeCycleDialog(Context context, int theme, View contentView) {
        super(context, theme);
        mContext = context;
        init(contentView);
    }

    public void init(int layoutId) {

        contentView = (ViewGroup) getLayoutInflater().inflate(layoutId, null);

        init(contentView);
    }


    private void init(View view) {

        L.d(TAG,"构造函数 init");

        setContentView(view);
        setCanceledOnTouchOutside(true);
        setGravity(Gravity.CENTER);
        getWindow().setDimAmount(0.6f);

        setWindowSize((int) DensityUtils.dp2px(500), WindowManager.LayoutParams.WRAP_CONTENT);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        L.d(TAG,"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        L.d(TAG,"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        L.d(TAG,"onStop");
    }



    /**
     * 设置弹窗的宽和高
     *
     * @param width
     * @param height
     */
    public void setWindowSize(int width, int height) {
        // 获取对话框当前的参数值
        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.width = width;
        p.height = height;
        getWindow().setAttributes(p);
    }

    public void setGravity(int gravity) {
        getWindow().setGravity(gravity);


    }




    @Override
    public <V extends View> V findViewById(int resId) {
        return contentView.findViewById(resId);
    }


    @Override
    public void dismiss() {
        if (getWindow() != null && getWindow().getDecorView() != null) {
            ViewHelp.hideSoftInput(getWindow().getDecorView());
        }
        super.dismiss();

        L.d(TAG,"dismiss");
    }

    @Override
    public void show() {
        super.show();
        L.d(TAG,"show");
    }
}
