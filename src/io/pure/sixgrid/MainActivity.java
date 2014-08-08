package io.pure.sixgrid;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import io.pure.sixgrid.adapter.SixPagerAdapter;
import io.pure.sixgrid.views.NonSwipeableViewPager;

public class MainActivity extends FragmentActivity
{
	SixPagerAdapter mAdapter;
	NonSwipeableViewPager mPager;
	
	boolean about;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		mAdapter = new SixPagerAdapter(getSupportFragmentManager());
		mPager = (NonSwipeableViewPager)findViewById(R.id.pager);
		
		mPager.setAdapter(mAdapter);
		about = false;
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.about:
				if (!about) {
					mPager.setCurrentItem(1, true);
					item.setTitle("Go Back");
					about = true;
				} else  {
					mPager.setCurrentItem(0, true);
					item.setTitle("About");
					about = false;
				}
		}
		
		return true;
	}
}
