package com.dfpbacas.subgame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DisplayGameFragment extends Fragment {

	private SubGameSurfaceView mGameSurface = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mGameSurface = (SubGameSurfaceView) inflater.inflate(R.layout.display_game_frag_layout, container, false);
		return mGameSurface;
	}

}
