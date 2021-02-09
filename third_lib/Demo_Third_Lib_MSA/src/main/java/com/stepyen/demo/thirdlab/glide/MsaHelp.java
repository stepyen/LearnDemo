package com.stepyen.demo.thirdlab.glide;

import android.content.Context;
import android.util.Log;

import com.bun.miitmdid.core.ErrorCode;
import com.bun.miitmdid.core.JLibrary;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.supplier.IIdentifierListener;
import com.bun.supplier.IdSupplier;


/**
 * date：2020-01-08
 * author：stepyen
 * description：移动安全联盟 sdk 帮助类
 */
public class MsaHelp {
    private static final String TAG = "MsaHelp";

    private static volatile MsaHelp instance;

    public MsaHelp() {

    }

    public static MsaHelp getInstance() {
        if (instance == null) {
            synchronized (MsaHelp.class) {
                if (instance == null) {
                    instance = new MsaHelp();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化SDK 在 Application 调用
     *
     * @param context
     */
    public void initSdk(Context context) {
        try {
            JLibrary.InitEntry(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化数据
     * <p>
     * 移动安全联盟 内部错误码
     * ErrorCode.INIT_ERROR_BEGIN                   // 开始
     * ErrorCode.INIT_ERROR_MANUFACTURER_NOSUPPORT  // 不支持的厂商
     * ErrorCode.INIT_ERROR_DEVICE_NOSUPPORT        // 不支持的设备
     * ErrorCode.INIT_ERROR_LOAD_CONFIGFILE         // 加载配置文件失败
     * ErrorCode.INIT_ERROR_RESULT_DELAY            // 信息将会延迟返回，获取数据可能在异步线程，取决于设备
     * ErrorCode.INIT_HELPER_CALL_ERROR             // 反射调用失败
     *
     * @param context
     * @param onMsaListener
     */
    public void initData(Context context, final OnMsaListener onMsaListener) {
        try {
            int errorCode = MdidSdkHelper.InitSdk(context, true, new IIdentifierListener() {
                @Override
                public void OnSupport(boolean b, IdSupplier supplier) {
                    if (onMsaListener != null) {
                        if (supplier == null) {
                            onMsaListener.onSupport(false, null);
                        } else {
                            onMsaListener.onSupport(supplier.isSupported(), supplier);
                            // 有些厂商使用 bind service 实现的，所以使用完 IdSupplier 对象之后，要调 用该方法释放连接
//                            supplier.shutDown();
                        }
                    }
                }
            });

            Log.e(TAG, "errorCode : " + errorCode);

            if (errorCode == ErrorCode.INIT_ERROR_BEGIN ||
                    errorCode == ErrorCode.INIT_ERROR_MANUFACTURER_NOSUPPORT ||
                    errorCode == ErrorCode.INIT_ERROR_DEVICE_NOSUPPORT ||
                    errorCode == ErrorCode.INIT_ERROR_LOAD_CONFIGFILE ||
                    errorCode == ErrorCode.INIT_HELPER_CALL_ERROR
            ) {
                if (onMsaListener != null) {
                    onMsaListener.onSupport(false, null);
                }
            }
        } catch (Exception e) {
            Log.e(TAG,e.toString());
            if (onMsaListener != null) {
                onMsaListener.onSupport(false, null);
            }
        }

    }


    public interface OnMsaListener {
        void onSupport(boolean isSupport, IdSupplier idSupplier);
    }

}
