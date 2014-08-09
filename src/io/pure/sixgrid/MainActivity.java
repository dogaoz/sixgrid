package io.pure.sixgrid;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import io.pure.sixgrid.adapter.SixPagerAdapter;
import io.pure.sixgrid.preference.CustomizeGrid;

public class MainActivity extends FragmentActivity
{
	SixPagerAdapter mAdapter;
	ViewPager mPager;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		mAdapter = new SixPagerAdapter(getSupportFragmentManager());
		mPager = (ViewPager)findViewById(R.id.pager);
		
		mPager.setAdapter(mAdapter);
		mPager.setCurrentItem(1);
    }

	@Override
	public void onBackPressed()
	{
		// super.onBackPressed();
		System.out.println("Don't you dare.");
	}
}
