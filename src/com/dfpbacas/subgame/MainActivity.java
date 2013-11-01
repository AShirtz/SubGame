package com.dfpbacas.subgame;

import com.dfpbacas.subgame.MenuFrag;
import com.example.SubGameObj.Entity.Ship;
import com.example.SubGameObj.Tests.UnitTests;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private MenuFrag mMenuFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new Thread(new Runnable() {
			@Override
			public void run() {
				UnitTests.runTests();
				Log.v("MainActivity", "UnitTests completed");		
			}
		}).start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
