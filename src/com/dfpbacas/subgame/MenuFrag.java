package com.dfpbacas.subgame;

import com.dfpbacas.subgame.MainActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MenuFrag extends Fragment implements View.OnClickListener {
	ImageView mSplashView;
	private Button mExit;
	private Button mStart;


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.menu_layout, container, false);
		//mSplashView = (ImageView)v.findViewById(R.layout.menu_layout);
		//mSplashView.setOnClickListener(this);
		mStart = (Button)v.findViewById(R.id.start_game);
		mStart.setOnClickListener(this);
		mExit = (Button)v.findViewById(R.id.exit);
		mExit.setOnClickListener(this);
		
		return v;
		//return super.onCreateView(inflater, container, savedInstanceState);
	}
@Override
	public void onClick(View v) {
	Log.d("test", v.toString());
		if (v.getId() == mStart.getId()) {
			((MainActivity)this.getActivity()).GameScreen(null);
		}
	}

}
