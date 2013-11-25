package com.dfpbacas.subgame.LogicObj;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.SurfaceHolder;

import com.example.SubGameObj.ObjectDrawer;
import com.example.SubGameObj.Utils.Position;

public class AndroidObjectDrawer extends ObjectDrawer {
	
	private SurfaceHolder mSurfaceHolder = null;
	private Canvas mCanvas = null;
	
	public void setSurfaceHolder (SurfaceHolder holder) {
		this.mSurfaceHolder = holder;
	}
	
	@Override
	public void drawDepthCharge(Position arg0) {
		Log.v("AndroidObjectDrawer", "drawDepthCharge: " + arg0.toString() + "\n");
	}

	@Override
	public void drawEnemyShip(Position arg0) {
		Log.v("AndroidObjectDrawer", "drawEnemyShip: " + arg0.toString() + "\n");
	}

	@Override
	public void drawExplosion(Position arg0) {
		Log.v("AndroidObjectDrawer", "drawExplosion: " + arg0.toString() + "\n");
	}

	@Override
	public void drawMap() {
		Log.v("AndroidObjectDrawer", "drawMap\n");
		this.mCanvas.drawColor(Color.BLUE);
	}

	@Override
	public void drawSonarPing(Position arg0) {
		Log.v("AndroidObjectDrawer", "drawSonarPing: " + arg0.toString() + "\n");
	}

	@Override
	public void drawSound(Position arg0) {
		Log.v("AndroidObjectDrawer", "drawSound: " + arg0.toString() + "\n");
	}

	@Override
	public void drawSubmarine(Position arg0) {
		Log.v("AndroidObjectDrawer", "drawSubmarine: " + arg0.toString() + "\n");
	}

	@Override
	public void drawTorpedo(Position arg0) {
		Log.v("AndroidObjectDrawer", "drawTorpedo: " + arg0.toString() + "\n");
	}

	@Override
	public void postChanges() {
		Log.v("AndroidObjectDrawer", "postChanges\n");
		this.mSurfaceHolder.unlockCanvasAndPost(this.mCanvas);
		this.mCanvas = null;
	}

	@Override
	public void prepareDrawer() {
		Log.v("AndroidObjectDrawer", "prepareDrawer\n");
		this.mCanvas = this.mSurfaceHolder.lockCanvas();
	}

}
