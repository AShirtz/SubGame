package com.dfpbacas.subgame;

import com.dfpbacas.subgame.LogicObj.AndroidObjectDrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DisplayGameFragment extends Fragment {

	private SubGameSurfaceView mGameSurface = null;
	private AndroidObjectDrawer mObjectDrawer = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mObjectDrawer = new AndroidObjectDrawer();
		mGameSurface = (SubGameSurfaceView) inflater.inflate(R.layout.display_game_frag_layout, container, false);
		mGameSurface.setGameFragment(this);
		mObjectDrawer.setSurfaceHolder(mGameSurface.getHolder());
		return mGameSurface;
	}
	
	public void viewCreated() {
		this.mObjectDrawer.prepareDrawer();
		this.mObjectDrawer.drawMap();
		this.mObjectDrawer.postChanges();
	}
}
