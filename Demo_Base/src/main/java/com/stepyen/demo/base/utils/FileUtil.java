package com.stepyen.demo.base.utils;

import android.graphics.Bitmap;
import android.os.Environment;

import com.stepyen.demo.base.App;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * date：2020/12/14
 * author：stepyen
 * description：
 */
public class FileUtil {

    public static boolean saveImageFile(String dirPath, String fileName, Bitmap bmp) {
        try {
            File dir = new File(dirPath);

            if (!dir.exists()) {
                boolean flag = dir.mkdirs();
                if (!flag) {
                    return false;
                }
            }

            if ((fileName == null) || (fileName.trim().length() == 0))
                fileName = System.currentTimeMillis() + ".jpg";
            File picPath = new File(dirPath, fileName);
            FileOutputStream fos = new FileOutputStream(picPath);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 创建一个图片地址
     */
    public static String createImagePath() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        File file = new File(App.get().getExternalFilesDir(Environment.DIRECTORY_PICTURES),sdf.format(date)+ ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        return file.getAbsolutePath();

    }



}
