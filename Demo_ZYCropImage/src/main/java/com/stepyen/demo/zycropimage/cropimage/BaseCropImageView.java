package com.stepyen.demo.zycropimage.cropimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.stepyen.demo.base.utils.BitmapUtil;

import java.util.ArrayList;


public class BaseCropImageView extends ImageViewTouchBase {
	public final static String TAG = "CropImageView";
	public final static int STATE_SAVING = 0x01;
	public final static int STATE_WAITTINGTOPICK = 0x02;
	public final static int STATE_NORMAL = 0x03;
	
	public static final String NO_FILTER_KEY = "no_filter";

	ArrayList<HighlightView> mHighlightViews = new ArrayList<HighlightView>();
	HighlightView mMotionHighlightView = null;
	float mLastX, mLastY;
	int mMotionEdge;
	Paint paint = new Paint();
	Bitmap mFilterBitmap = null;
	String mFilterName = null;
	int mBW = 0;
	int mBH = 0;
	private RectF mCropRect = new RectF();
	private Context mContext;
	private int mState = STATE_NORMAL;
	
	
	public void setState(int state){
		mState = state;
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
		if (mBitmapDisplayed.getBitmap() != null) {
			for (HighlightView hv : mHighlightViews) {
				hv.mMatrix.set(getImageMatrix());
				hv.invalidate();
				// if (hv.mIsFocused) {
				centerBasedOnHighlightView(hv);
				// }
			}
		}
	}
	
	public BaseCropImageView(Context context){
		this(context, null);
	}

	public BaseCropImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.mContext = context;
		// setBackgroundColor(0xffffffff);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		postDelayed(new Runnable() {
			@Override
			public void run() {
				invalidate();
			}
		}, 500);
	}

	@Override
	protected void zoomTo(float scale, float centerX, float centerY) {
		super.zoomTo(scale, centerX, centerY);
		for (HighlightView hv : mHighlightViews) {
			hv.mMatrix.set(getImageMatrix());
			hv.invalidate();
		}
	}

	@Override
	protected void zoomIn() {
		super.zoomIn();
		for (HighlightView hv : mHighlightViews) {
			hv.mMatrix.set(getImageMatrix());
			hv.invalidate();
		}
	}

	@Override
	protected void zoomOut() {
		super.zoomOut();
		for (HighlightView hv : mHighlightViews) {
			hv.mMatrix.set(getImageMatrix());
			hv.invalidate();
		}
	}

	@Override
	protected void postTranslate(float deltaX, float deltaY) {
		super.postTranslate(deltaX, deltaY);
		for (int i = 0; i < mHighlightViews.size(); i++) {
			HighlightView hv = mHighlightViews.get(i);
			hv.mMatrix.postTranslate(deltaX, deltaY);
			hv.invalidate();
		}
	}

	// According to the event's position, change the focus to the first
	// hitting cropping rectangle.
	private void recomputeFocus(MotionEvent event) {
		for (int i = 0; i < mHighlightViews.size(); i++) {
			HighlightView hv = mHighlightViews.get(i);
			hv.setFocus(false);
			hv.invalidate();
		}

		for (int i = 0; i < mHighlightViews.size(); i++) {
			HighlightView hv = mHighlightViews.get(i);
			int edge = hv.getHit(event.getX(), event.getY());
			if (edge != HighlightView.GROW_NONE) {
				if (!hv.hasFocus()) {
					hv.setFocus(true);
					hv.invalidate();
				}
				break;
			}
		}
		invalidate();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		CropImageActivity cropImage = (CropImageActivity) mContext;
		if (mState == STATE_SAVING) {
			return false;
		}

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			if (mState == STATE_WAITTINGTOPICK) {
				recomputeFocus(event);
			} else {
				for (int i = 0; i < mHighlightViews.size(); i++) {
					HighlightView hv = mHighlightViews.get(i);
					int edge = hv.getHit(event.getX(), event.getY());
					if (edge != HighlightView.GROW_NONE) {
						mMotionEdge = edge;
						mMotionHighlightView = hv;
						mLastX = event.getX();
						mLastY = event.getY();
						mMotionHighlightView.setMode(edge == HighlightView.MOVE ? HighlightView.ModifyMode.Move
								: HighlightView.ModifyMode.Grow);
						break;
					}
				}
			}
			break;
		case MotionEvent.ACTION_UP:
			if (mState == STATE_WAITTINGTOPICK) {
				for (int i = 0; i < mHighlightViews.size(); i++) {
					HighlightView hv = mHighlightViews.get(i);
					if (hv.hasFocus()) {
						//TODO
//						cropImage.mCrop = hv;
						for (int j = 0; j < mHighlightViews.size(); j++) {
							if (j == i) {
								continue;
							}
							mHighlightViews.get(j).setHidden(true);
						}
						centerBasedOnHighlightView(hv);
						//TODO
						setState(STATE_NORMAL);
//						((CropImageActivity) mContext).mWaitingToPick = false;
						return true;
					}
				}
			} else if (mMotionHighlightView != null) {
				centerBasedOnHighlightView(mMotionHighlightView);
				mMotionHighlightView.setMode(HighlightView.ModifyMode.None);
			}
			mMotionHighlightView = null;
			break;
		case MotionEvent.ACTION_MOVE:
			if (mState == STATE_WAITTINGTOPICK) {
				recomputeFocus(event);
			} else if (mMotionHighlightView != null) {
				mMotionHighlightView.handleMotion(mMotionEdge, event.getX() - mLastX, event.getY() - mLastY);
				mLastX = event.getX();
				mLastY = event.getY();

				if (true) {
					// This section of code is optional. It has some user
					// benefit in that moving the crop rectangle against
					// the edge of the screen causes scrolling but it means
					// that the crop rectangle is no longer fixed under
					// the user's finger.
					ensureVisible(mMotionHighlightView);
				}
			}
			break;
		}

		switch (event.getAction()) {
		case MotionEvent.ACTION_UP:
			center(true, true);
			break;
		case MotionEvent.ACTION_MOVE:
			// if we're not zoomed then there's no point in even allowing
			// the user to move the image around. This call to center puts
			// it back to the normalized location (with false meaning don't
			// animate).
			if (getScale() == 1F) {
				center(true, true);
			}
			break;
		}

		return true;
	}

	// Pan the displayed image to make sure the cropping rectangle is visible.
	private void ensureVisible(HighlightView hv) {
		Rect r = hv.mDrawRect;

		int panDeltaX1 = Math.max(0, mLeft - r.left);
		int panDeltaX2 = Math.min(0, mRight - r.right);

		int panDeltaY1 = Math.max(0, mTop - r.top);
		int panDeltaY2 = Math.min(0, mBottom - r.bottom);

		int panDeltaX = panDeltaX1 != 0 ? panDeltaX1 : panDeltaX2;
		int panDeltaY = panDeltaY1 != 0 ? panDeltaY1 : panDeltaY2;
		panDeltaY = 0;
		if (panDeltaX != 0 || panDeltaY != 0) {
			panBy(panDeltaX, panDeltaY);
		}
	}

	// If the cropping rectangle's size changed significantly, change the
	// view's center and scale according to the cropping rectangle.
	private void centerBasedOnHighlightView(HighlightView hv) {
		Rect drawRect = hv.mDrawRect;

		float width = drawRect.width();
		float height = drawRect.height();

		float thisWidth = getWidth();
		float thisHeight = getHeight();

		float z1 = thisWidth / width * .6F;
		float z2 = thisHeight / height * .6F;

		float zoom = Math.min(z1, z2);
		zoom = zoom * this.getScale();
		zoom = Math.max(1F, zoom);
		// 暂时不进行图片缩放
		// if ((Math.abs(zoom - getScale()) / zoom) > .1) {
		// float[] coordinates = new float[] { hv.mCropRect.centerX(),
		// hv.mCropRect.centerY() };
		// getImageMatrix().mapPoints(coordinates);
		// zoomTo(zoom, coordinates[0], coordinates[1], 300F);
		// }

		ensureVisible(hv);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		if (getDrawable() instanceof BitmapDrawable && ((BitmapDrawable) getDrawable()).getBitmap() != null
				&& ((BitmapDrawable) getDrawable()).getBitmap().isRecycled()) {
			return;
		}

		int loc[] = new int[2];
		getLocationOnScreen(loc);

		Rect rect = new Rect();
		rect.left = getLeft();
		rect.right = getRight();
		rect.bottom = getBottom();
		rect.top = getTop();
		super.onDraw(canvas);
		for (int i = 0; i < mHighlightViews.size(); i++) {
			mHighlightViews.get(i).draw(canvas);
		}
		if (mFilterName == null) {
			//TODO
//			setFilterImage(SettingsPreference.getInstance().getScreenFilterEffects());
		}
		if (mFilterBitmap != null) {

			Rect src = new Rect();
			Rect dest = new Rect();
			src.left = 0;
			src.right = mFilterBitmap.getWidth();
			src.top = 0;
			src.bottom = mFilterBitmap.getHeight();
			RectF destF = new RectF();
			if (mHighlightViews.size() > 0 && mHighlightViews.get(0) != null) {
				RectF tempF = mHighlightViews.get(0).getOriCropRect();
				destF.set(tempF);
			} else {
				destF.set(mCropRect);
			}
			getImageMatrix().mapRect(destF);
			dest.set((int) destF.left, (int) destF.top, (int) destF.right, (int) destF.bottom);
			canvas.drawBitmap(mFilterBitmap, src, dest, paint);
		}
	}

	public void add(HighlightView hv) {
		mHighlightViews.add(hv);
		invalidate();
	}

	public void remove(HighlightView hv) {
		mHighlightViews.remove(hv);
		invalidate();
	}
	
	public void removeAllHighlightView() {
		mHighlightViews.clear();
		invalidate();
	}

	public void setFilterImage(String name) {
		if (name.equals(NO_FILTER_KEY)) {
			mFilterName = name;
			mFilterBitmap = null;
			return;
		}
		mFilterName = name;
		Bitmap b;
		float scaleX = mBW / (float) this.getWidth();
		float scaleY = mBH / (float) this.getHeight();
		float scale = 0;

		scale = scaleX < scaleY ? scaleX : scaleY;

		try {
			b = BitmapUtil.getImageFile(Uri.parse(name), getContext(), (int) (mBW * scale), (int) (mBH * scale));
			mFilterBitmap = b;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//TODO
//	public void applyFilter() {
//		if (mFilterName != null) {
//			SettingsPreference.getInstance().setScreenFilterEffects(mFilterName);
//			Intent intent = new Intent(LauncherBrocastReceiverController.ACTION_APPLY_FILTER);
//			intent.putExtra("filterPath", mFilterName);
//			getContext().sendBroadcast(intent);
//		}
//	}

	public void setImageWH(int w, int h) {
		mBW = w;
		mBH = h;
	}

	public void setCropRect(RectF rect) {
		mCropRect.set(rect);
	}
}
