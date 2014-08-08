package io.pure.sixgrid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import io.pure.sixgrid.fragments.AboutFragment;
import io.pure.sixgrid.fragments.HomeFragment;

public class SixPagerAdapter extends FragmentPagerAdapter
{
	public SixPagerAdapter(FragmentManager fm) {
		super(fm);
	}
	
	public Fragment getItem(int position) {
		switch (position) {
			case 0:
				return new HomeFragment();
			case 1:
				return new AboutFragment();
		}
		
		return null;
	}
	
	public int getCount() {
		return 2;
	}
}
