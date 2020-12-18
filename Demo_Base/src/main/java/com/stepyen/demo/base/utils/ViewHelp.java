package com.stepyen.demo.base.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.stepyen.demo.base.App;

/**
 * date：2019/6/11
 * author：stepyen
 * description：view的帮助类
 */
public class ViewHelp {
    private ViewHelp() {
        throw new Error("Do not need instantiate!");
    }

    /**
     * 获取文本
     */
    public static CharSequence getText(TextView tv) {
        if (tv != null) {
            return tv.getText().toString().trim();
        }

        return "";
    }


    /**
     * 设置控件是否可用
     *
     * @param enable
     */
    public static void enable(View view, boolean enable) {
        if (view == null) {
            throw new IllegalStateException("view is null");
        }
        view.setEnabled(enable);
        if (view instanceof EditText) {
            view.setFocusable(enable);
            view.setFocusableInTouchMode(enable);
        }
    }

    /**
     * EditText设置文本和光标置后
     */
    public static void editTextSetText(EditText editText, CharSequence charSequence) {
        editText.setText(charSequence);
        editText.setSelection(charSequence.length());
    }

    /**
     * EditText获取焦点并显示软键盘
     */
    public static void showSoftInput(Context context, EditText editText) {
        if (null == context ||  null== editText) {
            return;
        }
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        InputMethodManager service = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        service.showSoftInput(editText, InputMethodManager.SHOW_FORCED);
    }


    /**
     * 动态隐藏软键盘
     *
     * @param view 视图
     */
    public static void hideSoftInput(final View view) {
        if (view == null) {
            return;
        }
        InputMethodManager imm = (InputMethodManager) App.get().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }



}
