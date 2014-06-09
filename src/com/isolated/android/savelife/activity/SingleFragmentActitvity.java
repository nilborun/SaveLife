package com.isolated.android.savelife.activity;

import com.isolated.android.savelife.R;
import com.isolated.android.savelife.R.id;
import com.isolated.android.savelife.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

public abstract class SingleFragmentActitvity extends ActionBarActivity {
	
	public abstract Fragment creatFragment();
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_main);
		
		FragmentManager fragmentManager=getSupportFragmentManager();
		Fragment fragment=fragmentManager.findFragmentById(R.id.container);
		if(fragment==null){
			fragment=creatFragment();
			fragmentManager.beginTransaction().add(R.id.container,fragment).commit();
					
		}
		
	}
	
	

}
