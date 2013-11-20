package com.dfpbacas.subgame;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class MainActivity extends FragmentActivity {
	
	private MenuFrag mMenuFragment = null;
	private final String MENU_FRAG_TAG = "menu_frag_tag";
	
	private DisplayGameFragment mDisplayGameFragment = null;
	private final String DISPLAY_GAME_FRAG_TAG = "display_game_frag_tag";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mDisplayGameFragment = (DisplayGameFragment) this.getSupportFragmentManager().findFragmentByTag(DISPLAY_GAME_FRAG_TAG);
		if (mDisplayGameFragment == null) {
			mDisplayGameFragment = new DisplayGameFragment();
			this.getSupportFragmentManager().beginTransaction().add(android.R.id.content, mDisplayGameFragment, DISPLAY_GAME_FRAG_TAG).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
