package com.dfpbacas.subgame.LogicObj;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.dfpbacas.subgame.DisplayGameFragment;
import com.example.SubGameObj.ObjectDrawer;
import com.example.SubGameObj.Entity.EnemyShip;
import com.example.SubGameObj.Entity.Submarine;
import com.example.SubGameObj.Event.Explosion;
import com.example.SubGameObj.Utils.Position;
import com.example.SubGameObj.Weapon.DepthCharge;
import com.example.SubGameObj.Weapon.Torpedo;

public class AndroidObjectDrawer extends ObjectDrawer {
	
	private DisplayGameFragment mGameFragment = null;
	private Canvas mCanvas = null;
	
	public void setGameFragment (DisplayGameFragment frag) {
		this.mGameFragment = frag;
	}
	
	private boolean nullCheck(Object obj) {
		if (obj == null) {
			return true;
		}
		return false;
	}
	
	@Override
	public void drawDepthCharge(DepthCharge arg0) {
		if (!this.nullCheck(arg0)) {
			Paint temp = new Paint();
			temp.setColor(Color.RED);
			temp.setTextSize(10);
			this.mCanvas.drawText("" + arg0.getTimeToDetonate(), arg0.getPosition().getX(), arg0.getPosition().getY(), temp);
		}
	}

	@Override
	public void drawEnemyShip(EnemyShip arg0) {
		if (!this.nullCheck(arg0)) {
			Paint temp = new Paint();
			temp.setColor(Color.BLACK);
			this.mCanvas.drawCircle(arg0.getPosition().getX(), arg0.getPosition().getY(), 10, temp);
		}
	}

	@Override
	public void drawExplosion(Explosion arg0) {
		Paint temp = new Paint();
		temp.setColor(Color.RED);
		temp.setAlpha(100);
		this.mCanvas.drawCircle(arg0.getPosition().getX(), arg0.getPosition().getY(), arg0.getRadius(), temp);
	}

	@Override
	public void drawMap() {
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
	public void drawSubmarine(Submarine arg0) {
		if (!this.nullCheck(arg0)) {
			Paint temp = new Paint();
			temp.setColor(Color.GREEN);
			this.mCanvas.drawCircle(arg0.getPosition().getX(), arg0.getPosition().getY(), 10, temp);
			temp.setColor(Color.WHITE);
			temp.setTextSize(25);
			this.mCanvas.drawText("Health: " + arg0.getHealth().getHealth(), 100f, 100f, temp);
		}
	}

	@Override
	public void drawTorpedo(Torpedo arg0) {
		if (!this.nullCheck(arg0)) {
			Paint temp = new Paint();
			temp.setColor(Color.WHITE);
			temp.setAlpha(100);
			this.mCanvas.drawCircle(arg0.getPosition().getX(), arg0.getPosition().getY(), 5, temp);
		}
	}

	@Override
	public void postChanges() {
		this.mGameFragment.postCanvas(this.mCanvas);
		this.mCanvas = null;
	}

	@Override
	public void prepareDrawer() {
		this.mCanvas = this.mGameFragment.lockCanvas();
	}

}
