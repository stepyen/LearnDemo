package com.stepyen.demo.zycropimage.cropimage;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.stepyen.demo.base.utils.FileUtil;
import com.stepyen.demo.zycropimage.R;
import com.stepyen.xutil.display.DensityUtils;
import com.stepyen.xutil.display.ScreenUtils;
import java.io.FileInputStream;
import java.io.InputStream;

public class CropImageActivity extends Activity implements OnClickListener{
	public static final String TAG = "CropImageActivity"; 
	
	CropImageView mCropImageView;
	FrameLayout mContent;
	Button mConfirmBtn;
	Button mRotateBtn;
	Button mCancelBtn;
//	ImageView mImageView;
	
	public static final String CUSTOM_URI = "CUSTOM_URI";
	public static final String CUSTOM_SAVENAME = "CUSTOM_SAVENAME";
	public static final String CUSTOM_SAVEPATH = "CUSTOM_SAVEPATH";
	/**长宽比例：长/宽*/
	public static final String CUSTOM_RATIO = "CUSTOM_RATIO";
	public static final String CUSTOM_MINWIDTH = "CUSTOM_MINWIDTH";
	public static final int defaultWPWidth = 960;
	public static final int defaultWPHeight = 800;
	private final float maxWidthRate = 1.8f; // 图片和屏幕的宽的最大倍数，用于大图缩放
	private final float maxHeightRate = 1.8f;// 图片和屏幕的高的最大倍数，用于大图缩放
	
	private final float maxRate = 3.0f;//图片和屏幕的宽的极限倍数，超过无法显示，用于大图缩放（值待验证）
	
	private int mSrcBitmapInSampleSize = 1;// 对原图进行缩小的倍数
	private int mScreenWidth = 0;
	private int mScreenHeight = 0;
	
	private String mSaveName = "";
	private String mSavePath = "";
	private float mRatio = 1;
	private int minWidth = 0;
	private Bitmap mBitmap = null;
	String imagePath;
	int rotate = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.demo_cropimage_activity_common_content);
		init();
	}
	
	private void init(){
		initData();
		initView();
		initSet();
	}
	private void initData(){
		mScreenWidth = ScreenUtils.getScreenWidth();
		mScreenHeight = ScreenUtils.getScreenHeight();
		
		Bundle bundle = getIntent().getExtras();
		mSaveName = bundle.getString(CUSTOM_SAVENAME);
		mSavePath = bundle.getString(CUSTOM_SAVEPATH);
		mRatio = bundle.getFloat(CUSTOM_RATIO,1);
		minWidth = bundle.getInt(CUSTOM_MINWIDTH, 0);
		Uri uri = bundle.getParcelable(CUSTOM_URI);
		imagePath = uri.toString();
		mBitmap = getSrcBitmap(imagePath,rotate);
		
		
	}
	private void initView(){
		mContent = (FrameLayout)findViewById(R.id.content);
//		mImageView = new ImageView(this);
//		mImageView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT
//				, FrameLayout.LayoutParams.MATCH_PARENT));
//		mContent.addView(mImageView);
		mCropImageView = new CropImageView(this);
		mCropImageView.setLayoutParams(new LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT
				, FrameLayout.LayoutParams.MATCH_PARENT,1));
		
		
		mConfirmBtn = new Button(this);
		mConfirmBtn.setLayoutParams(new LayoutParams(0, DensityUtils.dp2px(50), 1));
		mConfirmBtn.setBackgroundColor(Color.GREEN);
		mConfirmBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX,getResources().getDimensionPixelOffset(R.dimen.demo_cropimage_common_textsize_big));
		mConfirmBtn.setTextColor(Color.WHITE);
		mConfirmBtn.setText(R.string.demo_cropimage_cropImage_confirm);
		mConfirmBtn.setOnClickListener(this);
		
//		mRotateBtn = new Button(this);
//		mRotateBtn.setLayoutParams(new LayoutParams(0, DensityUtils.dp2px( 50), 1));
//		mRotateBtn.setBackgroundColor(Color.GREEN);
//		mRotateBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX,getResources().getDimensionPixelOffset(R.dimen.demo_cropimage_common_textsize_big));
//		mRotateBtn.setTextColor(Color.WHITE);
//		mRotateBtn.setText("旋转");
//		mRotateBtn.setOnClickListener(this);
		
		mCancelBtn = new Button(this);
		mCancelBtn.setLayoutParams(new LayoutParams(0,DensityUtils.dp2px( 50), 1));
		mCancelBtn.setBackgroundColor(Color.GREEN);
		mCancelBtn.setTextSize(TypedValue.COMPLEX_UNIT_PX,getResources().getDimensionPixelOffset(R.dimen.demo_cropimage_common_textsize_big));
		mCancelBtn.setTextColor(Color.WHITE);
		mCancelBtn.setText(R.string.demo_cropimage_cropImage_cancel);
		mCancelBtn.setOnClickListener(this);
		
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.HORIZONTAL);
		layout.setGravity(Gravity.CENTER);
		layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		layout.addView(mConfirmBtn);
//		layout.addView(mRotateBtn);
		layout.addView(mCancelBtn);
		
		LinearLayout layoutMain = new LinearLayout(this);
		layoutMain.setOrientation(LinearLayout.VERTICAL);
		layoutMain.setGravity(Gravity.CENTER);
		layoutMain.setLayoutParams(new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		
		layoutMain.addView(mCropImageView);
		layoutMain.addView(layout);
		
		mContent.addView(layoutMain);
		
	}
	private void initSet(){
		
//		mImageView.setImageBitmap(bitmap);
		mCropImageView.setBitmap(mBitmap,mRatio,minWidth);
	}
	
	
	
	
	
	private Bitmap getSrcBitmap(String path,int rotate) {
		if (path == null) {
			return null;
		}
		InputStream inputStream = null;
		try {
			// 先获取图片大小，来判断是否图片太大
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inJustDecodeBounds = true;
			if (path.indexOf("content://") != -1) {// 在图库中将图片“设置为”91桌面时
				ContentResolver cr = getContentResolver();
				inputStream = cr.openInputStream(Uri.parse(path));
				BitmapFactory.decodeStream(inputStream, null, options);
				inputStream = cr.openInputStream(Uri.parse(path));
			} else {
				if (path.indexOf("file:/") != -1) {// 在图库或其它第三方应用中将图片“设置为”91桌面时
					path = path.substring(path.indexOf(":/") + 1);
				}
				inputStream = new FileInputStream(path);
				BitmapFactory.decodeStream(inputStream, null, options);
				inputStream = new FileInputStream(path);
			}
			// 如果图片太大，对图片进行缩放，防止OOM
			options.inJustDecodeBounds = false;
			options.inSampleSize = 1;
			/**
			 * 读取壁纸图片时，对壁纸图片进行缩小的策略: 1.如果图片大小为默认大小(960x800),不进行缩小
			 * 2.如果图片宽>高，并且图片高 > 屏幕分辨率高x1.8，则进行压缩，压缩倍数为2 3.如果图片高>宽，并且图片宽 >
			 * 屏幕分辨率宽x1.8，则进行压缩，压缩倍数为2
			 */
			if (!isDefaultWallpaperSize(options.outWidth, options.outHeight)) {// 非默认壁纸大小时，若图片太大，进行缩放处理
				if (options.outWidth != -1 && options.outHeight != -1) {
					if (options.outHeight > mScreenHeight * maxRate || options.outWidth > mScreenWidth * maxRate) {
						mSrcBitmapInSampleSize = options.inSampleSize = 2;
					}else if (options.outWidth > options.outHeight) {// 图片宽大于高
						if (options.outHeight > mScreenHeight * maxHeightRate) {
							mSrcBitmapInSampleSize = options.inSampleSize = 2;
						}
					} else {
						if (options.outWidth > mScreenWidth * maxWidthRate) {
							mSrcBitmapInSampleSize = options.inSampleSize = 2;
						}
					}
				}
			}

			return BitmapFactory.decodeStream(inputStream, null, options);
		} catch (Exception e) {
			// 图片太大引起OOM
			Log.e(TAG, e.toString());
			return null;
		}
	}
	
	private boolean isDefaultWallpaperSize(int width, int height) {
		return (defaultWPWidth == width && defaultWPHeight == height) 
				|| (mScreenWidth * 2 == width && mScreenHeight == height);
	}

	@Override
	public void onClick(View v) {
		if(v == mConfirmBtn){
			if(mCropImageView != null){
				Bitmap resultBitmap = mCropImageView.getCropImage();
				boolean resule = FileUtil.saveImageFile(mSavePath, mSaveName, resultBitmap);
				if(resule){
					Intent data = new Intent();
					data.putExtra(CUSTOM_SAVEPATH, mSavePath);
					setResult(RESULT_OK,data);
					if(!mBitmap.isRecycled()){
						mBitmap.recycle();
					}
					if(!resultBitmap.isRecycled()){
						resultBitmap.recycle();
					}
					finish();
				}else{
					setResult(-1);
					if(!mBitmap.isRecycled()){
						mBitmap.recycle();
					}
					if(!resultBitmap.isRecycled()){
						resultBitmap.recycle();
					}
					finish();
				}
			}
				
		}else if(v == mCancelBtn){
			if(!mBitmap.isRecycled()){
				mBitmap.recycle();
			}
			setResult(RESULT_CANCELED);
			finish();
		}else if(v == mRotateBtn){
//			rotate += 90;
//			rotate %= 360;
			if(mBitmap != null && !mBitmap.isRecycled()){
				mBitmap.recycle();
			}
			Bitmap result = getRotateImage(mBitmap, 90);
			if(result != mBitmap && mBitmap != null && !mBitmap.isRecycled()){
				mBitmap.recycle();
				mBitmap = null;
			}
			mBitmap = result;
			mCropImageView.setBitmap(mBitmap,mRatio,minWidth);
		}
		
	}
	public Bitmap getRotateImage(Bitmap bitmap,int rotate){
		if(bitmap == null){
			return null;
		}
		Matrix mMatrix = new Matrix();
		mMatrix.setRotate(rotate);
		Bitmap resultBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), mMatrix, true);
		return resultBitmap;
	}

}
