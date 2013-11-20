package com.dfpbacas.subgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SubGameSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
	
	private SurfaceHolder mSurfaceHolder = null;
	
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
		mSurfaceHolder = this.getHolder();
		mSurfaceHolder.addCallback(this);
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		Canvas canvas = mSurfaceHolder.lockCanvas();
		canvas.drawColor(Color.BLACK);
		mSurfaceHolder.unlockCanvasAndPost(canvas);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		
	}

}
