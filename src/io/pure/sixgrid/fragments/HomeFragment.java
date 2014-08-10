package io.pure.sixgrid.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import io.pure.sixgrid.R;
import io.pure.sixgrid.drawer.AppsFragment;
import io.pure.sixgrid.preference.SimplePreference;

import net.margaritov.preference.colorpicker.ColorPickerPreference;

public class HomeFragment extends Fragment
{
	Button mOne;
	ViewGroup.LayoutParams mOneParams;
	Button mTwo;
	ViewGroup.LayoutParams mTwoParams;
	Button mThree;
	ViewGroup.LayoutParams mThreeParams;
	Button mFour;
	ViewGroup.LayoutParams mFourParams;
	Button mFive;
	ViewGroup.LayoutParams mFiveParams;
	Button mSix;
	ViewGroup.LayoutParams mSixParams;
	SharedPreferences mPrefs;
	
	public HomeFragment()
	{}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.home, container, false);
		
		setHasOptionsMenu(true);
		
		WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int dispwidth = size.x;
		int dispheight = size.y;
		
		mOne = (Button)rootView.findViewById(R.id.one);
		mOneParams = mOne.getLayoutParams();
		mOneParams.width = dispwidth / 2;
		mOneParams.height = dispheight / 3 - 8;
		
		mTwo = (Button)rootView.findViewById(R.id.two);
		mTwoParams = mTwo.getLayoutParams();
		mTwoParams.width = dispwidth / 2;
		mTwoParams.height = dispheight / 3 - 8;
		
		mThree = (Button)rootView.findViewById(R.id.three);
		mThreeParams = mThree.getLayoutParams();
		mThreeParams.width = dispwidth / 2;
		mThreeParams.height = dispheight / 3 - 8;
		
		mFour = (Button)rootView.findViewById(R.id.four);
		mFourParams = mFour.getLayoutParams();
		mFourParams.width = dispwidth / 2;
		mFourParams.height = dispheight / 3 - 8;
		
		mFive = (Button)rootView.findViewById(R.id.five);
		mFiveParams = mFive.getLayoutParams();
		mFiveParams.width = dispwidth / 2;
		mFiveParams.height = dispheight / 3 - 8;
		
		mSix = (Button)rootView.findViewById(R.id.six);
		mSixParams = mSix.getLayoutParams();
		mSixParams.width = dispwidth / 2;
		mSixParams.height = dispheight / 3 - 8;
		
			mOne.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v)
					{
						ViewPager viewPager = (ViewPager)getActivity().findViewById(R.id.pager);
						viewPager.setCurrentItem(0, true);
					}
				});
		
			mTwo.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v)
					{
						Intent messages = new Intent(Intent.ACTION_VIEW);
						messages.setData(Uri.parse("sms:"));
						startActivity(messages);
					}
				});
				
			mThree.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v)
					{
						Intent dialer = new Intent(Intent.ACTION_VIEW);
						dialer.setData(Uri.parse("tel:"));
						startActivity(dialer);
					}
				});
				
			mFour.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v)
					{
						Intent browser = new Intent(Intent.ACTION_VIEW);
						browser.setData(Uri.parse("http:"));
						startActivity(browser);
					}
				});
				
			mFive.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v)
					{
						Intent camera = new Intent("android.media.action.IMAGE_CAPTURE");
						startActivityForResult(camera, 1337);
					}
				});
		
		mSix.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent settings = new Intent(Settings.ACTION_SETTINGS);
				startActivity(settings);
			}
		});
		
		if (getActivity().getIntent().getBooleanExtra("var", false) == true) {
			updateGrids();
		}
		
		return rootView;
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.menu, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId()) {
			case R.id.customize:
				Intent c = new Intent(getActivity(), SimplePreference.class);
				startActivity(c);
				getActivity().finish();
				break;
		}
		
		return true;
	}
	
	public void updateGrids()
	{
		mPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

		mOne.setText(mPrefs.getString("nameone", "Empty"));
		mOne.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					Intent p = new Intent(getActivity().getPackageManager().getLaunchIntentForPackage(mPrefs.getString("pkgnameone", "io.pure.sixgrid")));
					startActivity(p);
				}
			});
		mOne.setBackgroundColor(Color.parseColor((ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(mPrefs.getInt("colorone", 0)))))));
		mOne.setTextColor(Color.parseColor((ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(mPrefs.getInt("textcolorone", 0)))))));

		mTwo.setText(mPrefs.getString("nametwo", "Empty"));
		mTwo.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					Intent p = new Intent(getActivity().getPackageManager().getLaunchIntentForPackage(mPrefs.getString("pkgnametwo", "io.pure.sixgrid")));
					startActivity(p);
				}
			});
		mTwo.setBackgroundColor(Color.parseColor((ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(mPrefs.getInt("colortwo", 0)))))));
		mTwo.setTextColor(Color.parseColor((ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(mPrefs.getInt("textcolortwo", 0)))))));

		mThree.setText(mPrefs.getString("namethree", "Empty"));
		mThree.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					Intent p = new Intent(getActivity().getPackageManager().getLaunchIntentForPackage(mPrefs.getString("pkgnamethree", "io.pure.sixgrid")));
					startActivity(p);
				}
			});
		mThree.setBackgroundColor(Color.parseColor((ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(mPrefs.getInt("colorthree", 0)))))));
		mThree.setTextColor(Color.parseColor((ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(mPrefs.getInt("textcolorthree", 0)))))));

		mFour.setText(mPrefs.getString("namefour", "Empty"));
		mFour.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					Intent p = new Intent(getActivity().getPackageManager().getLaunchIntentForPackage(mPrefs.getString("pkgnamefour", "io.pure.sixgrid")));
					startActivity(p);
				}
			});
		mFour.setBackgroundColor(Color.parseColor((ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(mPrefs.getInt("colorfour", 0)))))));
		mFour.setTextColor(Color.parseColor((ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(mPrefs.getInt("textcolorfour", 0)))))));

		mFive.setText(mPrefs.getString("namefive", "Empty"));
		mFive.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					Intent p = new Intent(getActivity().getPackageManager().getLaunchIntentForPackage(mPrefs.getString("pkgnamefive", "io.pure.sixgrid")));
					startActivity(p);
				}
			});
		mFive.setBackgroundColor(Color.parseColor((ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(mPrefs.getInt("colorfive", 0)))))));
		mFive.setTextColor(Color.parseColor((ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(mPrefs.getInt("textcolorfive", 0)))))));

		mSix.setText(mPrefs.getString("namesix", "Empty"));
		mSix.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					Intent p = new Intent(getActivity().getPackageManager().getLaunchIntentForPackage(mPrefs.getString("pkgnamesix", "io.pure.sixgrid")));
					startActivity(p);
				}
			});
		mSix.setBackgroundColor(Color.parseColor((ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(mPrefs.getInt("colorsix", 0)))))));
		mSix.setTextColor(Color.parseColor((ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(mPrefs.getInt("textcolorsix", 0)))))));
	}
}
