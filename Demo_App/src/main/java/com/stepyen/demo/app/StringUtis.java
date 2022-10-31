package com.stepyen.demo.app;

import android.text.TextUtils;

/**
 * date：2022/2/14
 * author：stepyen
 * description：
 */
class StringUtis {

    public static String urlAppendPara(String url, String key, String value) {

        if (TextUtils.isEmpty(url)) {
            return "";
        }

        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
            return url;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(url);

        if (url.contains("?")) {
            sb.append("&");
        }else{
            sb.append("?");
        }

        sb.append(key);
        sb.append("=");
        sb.append(value);

        return sb.toString();
    }

}
