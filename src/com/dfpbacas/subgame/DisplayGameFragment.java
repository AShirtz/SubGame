package com.dfpbacas.subgame;

import com.dfpbacas.subgame.LogicObj.AndroidObjectDrawer;
import com.example.SubGameObj.GameController;
import com.example.SubGameObj.Entity.EnemyShip;
import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Utils.Position;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;

public class DisplayGameFragment extends Fragment implements SurfaceHolder.Callback, View.OnTouchListener {

	private SubGameSurfaceView mGameSurface = null;
	private GameThread mGameThread = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mGameSurface = (SubGameSurfaceView) inflater.inflate(R.layout.display_game_frag_layout, container, false);
		mGameSurface.getHolder().addCallback(this);
		mGameSurface.setOnTouchListener(this);
		mGameSurface.setWillNotDraw(false);
		return mGameSurface;
	}
	
	public Canvas lockCanvas () {
		return mGameSurface.getHolder().lockCanvas();
	}
	
	public void postCanvas (Canvas canvas) {
		mGameSurface.getHolder().unlockCanvasAndPost(canvas);
		mGameSurface.postInvalidate();
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		this.mGameThread = new GameThread(this);
		this.mGameThread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
		case (MotionEvent.ACTION_DOWN) : 
			Log.v("onTouchEvent", "down");
			this.mGameThread.mGameController.setPointer(new Position((int)event.getX(), (int) event.getY()));
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
	
	public class GameThread extends Thread {
		
		private AndroidObjectDrawer mObjectDrawer = null;
		private GameController mGameController = null;
		private boolean mRunning = true;
		
		public  GameThread (DisplayGameFragment frag) {
			mObjectDrawer = new AndroidObjectDrawer();
			mGameController = GameController.getInstance(mObjectDrawer, frag.mGameSurface.getWidth(), frag.mGameSurface.getHeight());
			mObjectDrawer.setGameFragment(frag);
		}
		
		@Override
		public void run () {
			mRunning = true;
			mGameController.createPlayerSub();
			while (mRunning) {
				synchronized (mGameController) {
					mGameController.onTurn(); 
				}
				mGameController.drawGame();
				if (mGameController.getPlayerSub().isDestroyed()) {
					mRunning = false;
				}
			}
		}
	}
}
