package com.stepyen.demo.zycropimage;

public class Const {
    /**拍照获得的图片临时文件名*/
    public final static String TAKE_PHOTO_SAVE_NAME = "bz_take_photo_bak.jpg";

    public final static String CROP_FILE_NAME = "bz_crop_file.jpg";
    /**从照相中返回*/
    public final static int REQUEST_TAKE_PHOTO = 0x01;

    /**从本地图片选择中返回*/
    public final static int REQUEST_PICK_PHOTO = 0x02;

    /**截取图片*/
    public final static int REQUEST_CROP_IMAGE = 0x03;
}
