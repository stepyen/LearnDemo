package com.stepyen.demo.picture.activity;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.stepyen.demo.picture.R;
import com.stepyen.lib.fileprovider.FileProvider7;

import java.io.File;
import java.io.IOException;

/**
 * date：2020/12/10
 * author：stepyen
 * description：
 */
public class PictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        findViewById(R.id.cropBtn).setOnClickListener(v->{
//            startPhotoZoom(new File(getExternalFilesDir(""), "test.jpg").getAbsolutePath());
            test(new File(getExternalFilesDir(""), "test.jpg").getAbsolutePath());
        });




    }

    private Uri uriClipUri;
    public void startPhotoZoom(String path ) {
        //com.android.camera.action.CROP，这个action是调用系统自带的图片裁切功能
        Intent intent = new Intent("com.android.camera.action.CROP");
//        intent.setDataAndType(Uri.fromFile(new File(path)), "image/*");//裁剪的图片uri和图片类型

        FileProvider7.setIntentDataAndType(this,intent,"image/*",new File(path),true);
        intent.putExtra("crop", "true");//设置允许裁剪，如果不设置，就会跳过裁剪的过程，还可以设置putExtra("crop", "circle")
        intent.putExtra("aspectX", 1);//裁剪框的 X 方向的比例,需要为整数
        intent.putExtra("aspectY", 1);//裁剪框的 Y 方向的比例,需要为整数
        intent.putExtra("outputX", 300);//返回数据的时候的X像素大小。
        intent.putExtra("outputY", 300);//返回数据的时候的Y像素大小。
        //uritempFile为Uri类变量，实例化uritempFile
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            //开启临时访问的读和写权限
//            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            //针对7.0以上的操作
//            intent.setClipData(ClipData.newRawUri(MediaStore.EXTRA_OUTPUT, uri));
//            uriClipUri = Uri.fromFile(new File(getExternalFilesDir(""), "test2.jpg"));;

//            uriClipUri = FileProvider7.getUriForFile(this, new File(getExternalFilesDir(""), "test2.jpg"));

            File file = new File(getExternalFilesDir(""), "test2.jpg");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            uriClipUri = FileProvider7.getUriForFile(this,file);

//            }
//        else {//如果是7.0的相册
//                //设置裁剪的图片地址Uri
//                uriClipUri = Uri.parse("file://" + "/" + Environment.getExternalStorageDirectory().getPath() + "/" + "clip.jpg");
//            }

//        } else {
//            uriClipUri = Uri.parse("file://" + "/" + Environment.getExternalStorageDirectory().getPath() + "/" + "clip.jpg");
        }
        //Android 对Intent中所包含数据的大小是有限制的，一般不能超过 1M，否则会使用缩略图 ,所以我们要指定输出裁剪的图片路径
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriClipUri);
        intent.putExtra("return-data", false);//是否将数据保留在Bitmap中返回
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());//输出格式，一般设为Bitmap格式及图片类型
        intent.putExtra("noFaceDetection", true);//人脸识别功能
        startActivityForResult(intent, 123);//裁剪完成的标识

    }


    private void test(String path) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        FileProvider7.setIntentDataAndType(this,intent,"image/*",new File(path),true);
        intent.putExtra("crop", "true"); //就会调用裁剪，如果不设置，就会跳过裁剪的过程。
        //剪裁框大小，不指定的话就可以随意设置大小
        if (Build.MANUFACTURER.equals("HUAWEI")) {
            intent.putExtra("aspectX", 9998);
            intent.putExtra("aspectY", 9999);
        } else {
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
        }
//        intent.putExtra("aspectX", 1);
//        intent.putExtra("aspectY", 1);
        //输出的图片，返回的是像素大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);
        //上面两个值会生成一个bitmap
        intent.putExtra("scale", true);
        intent.putExtra("outputFormat", "JPG");
        intent.putExtra("noFaceDetection", true); //人脸识别
        intent.putExtra("return-data", true);  //是否要返回值，这个一定要
        startActivityForResult(intent, 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123) {

            Bitmap bitmap = data.getParcelableExtra("data");
            ImageView iv = findViewById(R.id.iv);
            iv.setImageBitmap(bitmap);

        }
    }
}
