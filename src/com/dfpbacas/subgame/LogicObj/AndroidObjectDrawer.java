package com.dfpbacas.subgame.LogicObj;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.dfpbacas.subgame.DisplayGameFragment;
import com.example.SubGameObj.ObjectDrawer;
import com.example.SubGameObj.Utils.Position;

public class AndroidObjectDrawer extends ObjectDrawer {
	
	private DisplayGameFragment mGameFragment = null;
	private Canvas mCanvas = null;
	
	public void setGameFragment (DisplayGameFragment frag) {
		this.mGameFragment = frag;
	}
	
	@Override
	public void drawDepthCharge(Position arg0) {
		Log.v("AndroidObjectDrawer", "drawDepthCharge: " + arg0.toString() + "\n");
	}

	@Override
	public void drawEnemyShip(Position arg0) {
		Log.v("AndroidObjectDrawer", "drawEnemyShip: " + arg0.toString() + "\n");
		Paint temp = new Paint();
		temp.setColor(Color.WHITE);
		this.mCanvas.drawCircle(arg0.getX(), arg0.getY(), 10, temp);
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
		this.mGameFragment.postCanvas(this.mCanvas);
		this.mCanvas = null;
	}

	@Override
	public void prepareDrawer() {
		Log.v("AndroidObjectDrawer", "prepareDrawer\n");
		this.mCanvas = this.mGameFragment.lockCanvas();
	}

}
