package io.pure.sixgrid;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import io.pure.sixgrid.adapter.SixPagerAdapter;
import io.pure.sixgrid.preference.CustomizeGrid;
import io.pure.sixgrid.transform.DepthNoFadePageTransformer;
import io.pure.sixgrid.transform.DepthPageTransformer;
import io.pure.sixgrid.transform.FadeInPageTransformer;
import io.pure.sixgrid.transform.FadeOutPageTransformer;
import io.pure.sixgrid.transform.ZoomOutNoFadePageTransformer;
import io.pure.sixgrid.transform.ZoomOutPageTransformer;

public class MainActivity extends FragmentActivity
{
	SharedPreferences mPrefs;
	SixPagerAdapter mAdapter;
	ViewPager mPager;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		getWindow().getDecorView().setBackgroundColor(Color.parseColor("#666666"));
		
		mAdapter = new SixPagerAdapter(getSupportFragmentManager());
		mPager = (ViewPager)findViewById(R.id.pager);
		
		mPager.setAdapter(mAdapter);
		mPager.setCurrentItem(1, true);
		
		mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
	
		switch (mPrefs.getString("swipeanim", "normal")) {
			case "normal":
				mPager.setPageTransformer(true, new ViewPager.PageTransformer() {
					public void transformPage(View v, float position)
					{
						
					}
				});
				break;
			case "fadein":
				mPager.setPageTransformer(true, new FadeInPageTransformer());
				break;
			case "fadeout":
				mPager.setPageTransformer(true, new FadeOutPageTransformer());
				break;
			case "depth":
				mPager.setPageTransformer(true, new DepthPageTransformer());
				break;
			case "nfdepth":
				mPager.setPageTransformer(true, new DepthNoFadePageTransformer());
				break;
			case "zoom":
				mPager.setPageTransformer(true, new ZoomOutPageTransformer());
				break;
			case "nfzoom":
				mPager.setPageTransformer(true, new ZoomOutNoFadePageTransformer());
				break;
		}
    }

	@Override
	public void onBackPressed()
	{
		// super.onBackPressed();
		System.out.println("Don't you dare.");
	}
}
