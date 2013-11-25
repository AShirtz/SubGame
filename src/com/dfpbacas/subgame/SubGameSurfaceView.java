package com.dfpbacas.subgame;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SubGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
	
	private DisplayGameFragment mGameFrag = null;
	
	public SubGameSurfaceView(Context context) {
		super(context);
		init();
	}

	public SubGameSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	public SubGameSurfaceView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	
	private void init() {
		this.getHolder().addCallback(this);
	}
	
	public void setGameFragment(DisplayGameFragment DGFrag) {
		this.mGameFrag = DGFrag;
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		this.mGameFrag.viewCreated();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		
	}
	
	@Override
	public boolean onTouchEvent (MotionEvent event) {
		switch (event.getAction()) {
		case (MotionEvent.ACTION_DOWN) : 
			Log.v("onTouchEvent", "down");
			break;
		case (MotionEvent.ACTION_MOVE) :
			Log.v("onTouchEvent", "move");
			break;
		case (MotionEvent.ACTION_UP) :
			Log.v("onTouchEvent", "up");
			break;
		}
		return true;
	}

}
