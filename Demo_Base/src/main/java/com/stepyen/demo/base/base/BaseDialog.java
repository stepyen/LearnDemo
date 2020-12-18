package com.stepyen.demo.base.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;

import com.stepyen.demo.base.R;
import com.stepyen.demo.base.utils.ViewHelp;
import com.stepyen.xutil.display.DensityUtils;

/**
 * date：2020/10/23
 * author：stepyen
 * description：
 */
public class BaseDialog<T extends BaseDialog> extends Dialog {

    private ViewGroup contentView;
    protected Context mContext;

    public BaseDialog(Context context, int layoutId) {
        this(context, R.style.CommonDialog, layoutId);
    }

    public BaseDialog(Context context, View contentView) {
        this(context, R.style.CommonDialog, contentView);
    }

    public BaseDialog(Context context) {
        super(context, R.style.CommonDialog);
    }

    public BaseDialog(Context context, int theme, int layoutId) {
        super(context, theme);
        mContext = context;
        init(layoutId);
    }

    public BaseDialog(Context context, int theme, View contentView) {
        super(context, theme);
        mContext = context;
        init(contentView);
    }

    public void init(int layoutId) {

        contentView = (ViewGroup) getLayoutInflater().inflate(layoutId, null);

        init(contentView);
    }


    private void init(View view) {
        setContentView(view);
        setCanceledOnTouchOutside(true);
        setGravity(Gravity.CENTER);
        getWindow().setDimAmount(0.6f);

        setWindowSize((int) DensityUtils.dp2px(500), WindowManager.LayoutParams.WRAP_CONTENT);

    }

    /**
     * 设置弹窗的宽和高
     *
     * @param width
     * @param height
     */
    public T setWindowSize(int width, int height) {
        // 获取对话框当前的参数值
        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.width = width;
        p.height = height;
        getWindow().setAttributes(p);
        return (T) this;
    }

    public T setGravity(int gravity) {
        getWindow().setGravity(gravity);

        return (T) this;
    }

    /**
     * 底部对话框可以使用 R.style.Animation_Bottom_Rising
     *
     * @param resId
     * @return
     */
    public T setWindowAnimations(@StyleRes int resId) {
        getWindow().setWindowAnimations(resId);
        return (T) this;
    }


    @Override
    public <V extends View> V findViewById(int resId) {
        return contentView.findViewById(resId);
    }

    public String getString(int resId) {
        return getContext().getResources().getString(resId);
    }

    public Drawable getDrawable(int resId) {
        return ContextCompat.getDrawable(getContext(), resId);
    }

    @Override
    public void dismiss() {
        if (getWindow()!= null && getWindow().getDecorView() != null) {
            ViewHelp.hideSoftInput(getWindow().getDecorView());
        }
        super.dismiss();
    }
}
