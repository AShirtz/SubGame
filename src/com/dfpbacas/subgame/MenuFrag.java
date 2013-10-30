package com.dfpbacas.subgame;

import com.dfpbacas.subgame.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MenuFrag extends Fragment implements View.OnClickListener {
	ImageView mSplashView;
	Button mExit;
	Button mStart;


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.menu_layout, container, false);
		mSplashView = (ImageView)v.findViewById(R.id.menu_view);
		mSplashView.setOnClickListener(this);
		mExit = (Button)v.findViewById(R.id.exit);
		mExit.setOnClickListener(this);
		
		return v;
		//return super.onCreateView(inflater, container, savedInstanceState);
	}
@Override
	public void onClick(View arg0) {
	// TODO Auto-generated method stub
	
	}

}
