package com.stepyen.demo.base.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.File;
import java.io.FileInputStream;

/**
 * date：2020/12/14
 * author：stepyen
 * description：
 */
public class BitmapUtil {

    public static Bitmap getImageFile(Uri contentUri, Context ctx, int targetWidth, int targetHeight) throws Exception {
        Bitmap tmpBmp = null;
        try {
            if (contentUri == null)
                return null;
            ContentResolver cr = ctx.getContentResolver();
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inJustDecodeBounds = true;

            if (contentUri.toString().indexOf("content") != -1)
                BitmapFactory.decodeStream(cr.openInputStream(contentUri), null, opts);
            else {
                BitmapFactory.decodeFile(contentUri.toString(), opts);
            }
            int imWidth = opts.outWidth;
            int imHeight = opts.outHeight;

            int scale = 1;
            if (imWidth > imHeight)
                scale = Math.round(imWidth / targetWidth);
            else
                scale = Math.round(imHeight / targetHeight);
            scale = scale == 0 ? 1 : scale;

            opts.inJustDecodeBounds = false;
            opts.inSampleSize = scale;
            if (contentUri.toString().indexOf("content") != -1) {
                tmpBmp = BitmapFactory.decodeStream(cr.openInputStream(contentUri), null, opts);
            } else {
                FileInputStream fis = new FileInputStream(new File(contentUri.toString()));
                tmpBmp = BitmapFactory.decodeStream(fis, null, opts);
            }
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmpBmp;
    }
}
