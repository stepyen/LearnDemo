package com.stepyen.demo.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.stepyen.demo.base.common.CommonPath;
import com.stepyen.demo.base.config.PhoneConf;
import com.stepyen.xui.XUI;
import com.stepyen.xutil.XUtil;
import com.superdo.magina.autolayout.AutoLayout;

/**
 * date：2019/6/24
 * author：stepyen
 * description：
 */
public class App extends Application {

    private static final String TAG = "AppTAG";
    public static App app;
    public String packName;
    public static Handler handler = new Handler();
    private static PhoneConf phoneConf;



    public static App get() {
        return app;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

        Log.d(TAG, "attachBaseContext: ");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");

        app = this;

        XUtil.init(this);

        XUI.init(this);
        initAutoLayout();
//        initPage();

        initAOP();

//        initUmeng();

        initLog();

//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);

        packName = getPackageName();

        CommonPath.INSTANCE.init();
    }


    private void initAutoLayout() {
        AutoLayout.init(this, 1920, 1080);
        AutoLayout.setPhoneSize(App.getPhoneConf().getHeight(), App.getPhoneConf().getWidth());
        AutoLayout.setScreenOrientation(AutoLayout.ScreenOrientation.LANDSCAPE);
    }


    public static PhoneConf getPhoneConf() {
        if (phoneConf == null) {
            phoneConf = new PhoneConf(app);
        }
        return phoneConf;
    }
    /**
     * 初始化日志
     */
    private void initLog() {

        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true) //(optional) whether to show thread info or not. Default true
                .methodCount(5) //(optional) how many method line to show, default 2。 显示多少个方法数
                .methodOffset(10) //(optional) hides internal method calls up to offset, default 5。从哪里开始显示的偏移量，为0的时候，就显示内部方法
                .tag("LearnDemoTag") //(optional) global tag for every log, default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

    }

    private void initUmeng() {
//        UMConfigure.init(this, Constant.UM_KEY
//                ,"umeng", UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
//
//        PlatformConfig.setWeixin(Constant.WX_APP_ID, Constant.WX_APP_SECRET);
//        PlatformConfig.setSinaWeibo("569307052", "ea24af1aa72233dd3c11de773df76385","http://sns.whalecloud.com");
//        PlatformConfig.setQQZone(Constant.QQ_APP_ID, Constant.QQ_APP_KEY);
//
//        // 设置每次登录拉取确认界面
//        UMShareConfig config = new UMShareConfig();
//        config.isNeedAuthOnGetUserInfo(true);
//        UMShareAPI.get(this).setShareConfig(config);

    }

    private void initAOP() {
        //初始化插件
//        XAOP.init(this);
        //日志打印切片开启
//        XAOP.debug(BuildConfig.DEBUG);
        //设置动态申请权限切片 申请权限被拒绝的事件响应监听
//        XAOP.setOnPermissionDeniedListener(new PermissionUtils.OnPermissionDeniedListener() {
//            @Override
//            public void onDenied(List<String> permissionsDenied) {
//                ToastUtils.toast("权限申请被拒绝:" + StringUtils.listToString(permissionsDenied, ","));
//            }
//
//        });
    }

//    private void initPage() {
//        PageConfig.getInstance()
//                .setPageConfiguration(new PageConfiguration() { //页面注册
//                    @Override
//                    public List<PageInfo> registerPages(Context context) {
//                        //自动注册页面,是编译时自动生成的，build一下就出来了。如果你还没使用@Page的话，暂时是不会生成的。
////                        return AppPageConfig.getInstance().getPages(); //自动注册页面
//                        return null;
//                    }
//                })
//                .debug("PageLog")       //开启调试
//                .setContainActivityClazz(BaseActivity.class) //设置默认的容器Activity
//                .enableWatcher(false)   //设置是否开启内存泄露监测
//                .init(this);            //初始化页面配置
//    }


    private void initBmob() {
//        BmobConfig config =new BmobConfig.Builder(this)
//        //设置appkey
//        .setApplicationId("007cfa80322d2e231ea583716ab0cf3c")
//        //请求超时时间（单位为秒）：默认15s
//        .setConnectTimeout(30)
//        //文件分片上传时每片的大小（单位字节），默认512*1024
//        .setUploadBlockSize(1024*1024)
//        //文件的过期时间(单位为秒)：默认1800s
//        .setFileExpiration(2500)
//        .build();
//        Bmob.initialize(config);

    }

}
