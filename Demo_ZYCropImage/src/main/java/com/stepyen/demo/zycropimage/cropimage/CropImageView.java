package com.stepyen.demo.zycropimage.cropimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.stepyen.xutil.display.ScreenUtils;

public class CropImageView extends LinearLayout{
	
	BaseCropImageView mBaseCropImageView;
	HighlightView mHighlightView;
	
	Bitmap mSrcBitmap = null;
	int mSrcBitmapWidth;
	int mSrcBitmapHeight;
	private float mBitmapScale = 0.05f;
	private int minWidth = 20;
	
	private final int defaultWPWidth = 960;
	private final int defaultWPHeight = 800;

	public CropImageView(Context context) {
		this(context,null);
		// TODO Auto-generated constructor stub
	}

	public CropImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public void init(){
		initData();
		initView();
		initSet();
	}
	
	private void initData(){
		
	}
	
	private void initView(){
		setOrientation(LinearLayout.VERTICAL);
		setGravity(Gravity.CENTER_HORIZONTAL);
		mBaseCropImageView = new BaseCropImageView(getContext());
		mBaseCropImageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		
		addView(mBaseCropImageView);
	}
	
	private void initSet(){
//		mHighlightView.setBitmapScale(1.0f);
//		mHighlightView.setWallpaperRolling(true);
//		mHighlightView.setShowResize(true);
//		mBaseCropImageView.setCropRect(cropRect)
	}
	
	public void setMinWidth(int minWidth){
		this.minWidth = minWidth;
		
		
	}
	
	/**
	 * 
	 * @param bitmap
	 * @param ratio 高宽比例： 高/宽   ratio = 0时，不按比例缩放
	 * @param minWidth 最小宽度  
	 */
	public void setBitmap(Bitmap bitmap,float ratio,int minWidth){
		if(bitmap == null) 
			return ;
		mSrcBitmap = bitmap;
		mSrcBitmapWidth = mSrcBitmap.getWidth();
		mSrcBitmapHeight = mSrcBitmap.getHeight();
		mBaseCropImageView.setFilterImage(BaseCropImageView.NO_FILTER_KEY);
//		mBaseCropImageView.setImageWH(mSrcBitmapWidth, mSrcBitmapHeight);
		mBaseCropImageView.setImageBitmapResetBase(bitmap, true);
		
		Rect imageRect = new Rect(0, 0, mSrcBitmapWidth, mSrcBitmapHeight);
		RectF cropRect = null;
		boolean maintainAspectRatio = true;
		
		if(minWidth > 0){
			float widthRatio = minWidth*1.0f/imageRect.width();
			if(ratio > 0){
				int minHeight = (int) (minWidth*ratio);
				float heightRatio = minHeight*1.0f/imageRect.height();
				mBitmapScale = widthRatio > heightRatio ? widthRatio : heightRatio;
			}else{
				mBitmapScale = widthRatio;
			}
			if(mBitmapScale > 1 || mBitmapScale <= 0){
				mBitmapScale = 1;
			}
		}
		if(ratio > 0){
			maintainAspectRatio = true;
			float imgRatio = mSrcBitmapHeight*1.0f/mSrcBitmapWidth;
			if(imgRatio > ratio){
				int dif = (int) (imageRect.height() - imageRect.width()*ratio);
				cropRect = new RectF(0, dif/2, imageRect.width(), imageRect.height() - dif/2);
			}else{
				int dif = (int) (imageRect.width() - imageRect.height()/ratio);
				cropRect = new RectF(dif/2, 0, imageRect.width() - dif/2, imageRect.height());
			}
		}else{
			maintainAspectRatio = false;
			cropRect = new RectF(0, imageRect.centerY()/2, mSrcBitmapWidth, imageRect.centerY() + imageRect.centerY()/2);
		}
		if(mHighlightView != null && mBaseCropImageView != null)
			mBaseCropImageView.remove(mHighlightView);
		mHighlightView = new HighlightView(mBaseCropImageView);
//		Matrix mImageMatrix = new Matrix(mBaseCropImageView.getImageMatrix());
//		mImageMatrix.postTranslate(mBaseCropImageView.getPaddingLeft(), mBaseCropImageView.getPaddingTop());
		mHighlightView.setup(mBaseCropImageView.getImageMatrix(), imageRect, cropRect, maintainAspectRatio);
		mHighlightView.setShowResize(true);
		mHighlightView.setBitmapScale(mBitmapScale);
//		mHighlightView.setBitmapScale(0.5f);
		mHighlightView.setWallpaperRolling(false);
		mHighlightView.setFocus(true);
		mHighlightView.invalidate();
		
		mBaseCropImageView.setState(BaseCropImageView.STATE_NORMAL);
		mBaseCropImageView.add(mHighlightView);
		mBaseCropImageView.setCropRect(cropRect);
		if (mBaseCropImageView.getScale() == 1F) 
		{
			mBaseCropImageView.center(true, true);
		}
	}
	
	
	public Bitmap getCropImage(){
		if(mHighlightView == null){
			return null;
		}
		Bitmap croppedImage = genCroppedBitmap();
		return croppedImage;
	}
	
	private Bitmap genCroppedBitmap() {
		
		mBaseCropImageView.setState(BaseCropImageView.STATE_SAVING);
		int rotate = 0;
		// 1.翻转rect区域
		Rect rect = mHighlightView.getCropRect();
		int left = (int) (rect.left);
		int top = (int) (rect.top);
		rect.left = Math.max(0, left);
		rect.top = Math.max(0, top);
		rect.bottom = (int) (rect.bottom);
		rect.right = (int) (rect.right);
		

		// 2.翻转后将原图目标区域缩放后生成新bitmap
		final Bitmap croppedImage;
//		float scale = 1.0f;
//		if (!isDefaultWallpaperSize()) {
//			int compHeight = (rotate % 180 == 0) ? rect.height() : rect.width();
//			scale = (float) SystemUtil.getScreenHeight(getContext(), false) / compHeight;
//		} else {
//			scale = 1.0f;
//		}
		croppedImage = Bitmap.createBitmap(mSrcBitmap, rect.left, rect.top, rect.width(),
				rect.height(), null, true);
//		if (mBitmapScale < 1) {
//			Matrix matrix = new Matrix();
//			matrix.postScale(mBitmapScale, mBitmapScale);
//			croppedImage = Bitmap.createBitmap(mSrcBitmap, rect.left, rect.top, rect.width(),
//					rect.height(), matrix, true);
//		} else {
//			croppedImage = Bitmap.createBitmap(mSrcBitmap, rect.left, rect.top, rect.width(),
//					rect.height(), null, false);
//
//		}
		return croppedImage;
	}
	
	private boolean isDefaultWallpaperSize() {
		return (defaultWPWidth == mSrcBitmapWidth && defaultWPHeight == mSrcBitmapHeight)
				|| (ScreenUtils.getScreenWidth() * 2 == mSrcBitmapWidth && ScreenUtils.getScreenHeight() == mSrcBitmapHeight);
	}

}
