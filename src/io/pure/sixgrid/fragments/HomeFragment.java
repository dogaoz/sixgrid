package io.pure.sixgrid.fragments;

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
	SharedPreferences mPrivate;
	
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
						getActivity().overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
					}
				});
				
			mThree.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v)
					{
						Intent dialer = new Intent(Intent.ACTION_VIEW);
						dialer.setData(Uri.parse("tel:"));
						startActivity(dialer);
						getActivity().overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
					}
				});
				
			mFour.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v)
					{
						Intent browser = new Intent(Intent.ACTION_VIEW);
						browser.setData(Uri.parse("http:"));
						startActivity(browser);
						getActivity().overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
					}
				});
				
			mFive.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v)
					{
						Intent camera = new Intent("android.media.action.IMAGE_CAPTURE");
						startActivityForResult(camera, 1337);
						getActivity().overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
					}
				});
		
		mSix.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent settings = new Intent(Settings.ACTION_SETTINGS);
				startActivity(settings);
				getActivity().overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
			}
		});
		
		if (getActivity().getIntent().getBooleanExtra("var", false) == true) {
			updateGrids();
		}
		
		setColorProfile();
		
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
				getActivity().overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
				getActivity().finish();
				break;
		}
		
		return true;
	}
	
	private void setColorProfile() {
		mPrivate = getActivity().getSharedPreferences("io.pure.sixgrid", getActivity().MODE_PRIVATE);
		
		switch (mPrivate.getString("cprofile", "default")) {
			case "default":
				mOne.setBackgroundColor(Color.parseColor("#ffffff"));
				mOne.setTextColor(Color.parseColor("#000000"));
				mTwo.setBackgroundColor(Color.parseColor("#aa66cc"));
				mTwo.setTextColor(Color.parseColor("#ffffff"));
				mThree.setBackgroundColor(Color.parseColor("#ffbb33"));
				mThree.setTextColor(Color.parseColor("#ffffff"));
				mFour.setBackgroundColor(Color.parseColor("#33b5e5"));
				mFour.setTextColor(Color.parseColor("#ffffff"));
				mFive.setBackgroundColor(Color.parseColor("#99cc00"));
				mFive.setTextColor(Color.parseColor("#ffffff"));
				mSix.setBackgroundColor(Color.parseColor("#ff4444"));
				mSix.setTextColor(Color.parseColor("#ffffff"));
				break;
			case "mkbhd":
				mOne.setBackgroundColor(Color.parseColor("#ff4444"));
				mOne.setTextColor(Color.parseColor("#ffffff"));
				mTwo.setBackgroundColor(Color.parseColor("#666666"));
				mTwo.setTextColor(Color.parseColor("#ffffff"));
				mThree.setBackgroundColor(Color.parseColor("#666666"));
				mThree.setTextColor(Color.parseColor("#ffffff"));
				mFour.setBackgroundColor(Color.parseColor("#666666"));
				mFour.setTextColor(Color.parseColor("#ffffff"));
				mFive.setBackgroundColor(Color.parseColor("#666666"));
				mFive.setTextColor(Color.parseColor("#ffffff"));
				mSix.setBackgroundColor(Color.parseColor("#ff4444"));
				mSix.setTextColor(Color.parseColor("#ffffff"));
				break;
			case "chess":
				mOne.setBackgroundColor(Color.parseColor("#ffffff"));
				mOne.setTextColor(Color.parseColor("#000000"));
				mTwo.setBackgroundColor(Color.parseColor("#000000"));
				mTwo.setTextColor(Color.parseColor("#ffffff"));
				mThree.setBackgroundColor(Color.parseColor("#ffffff"));
				mThree.setTextColor(Color.parseColor("#000000"));
				mFour.setBackgroundColor(Color.parseColor("#000000"));
				mFour.setTextColor(Color.parseColor("#ffffff"));
				mFive.setBackgroundColor(Color.parseColor("#ffffff"));
				mFive.setTextColor(Color.parseColor("#000000"));
				mSix.setBackgroundColor(Color.parseColor("#000000"));
				mSix.setTextColor(Color.parseColor("#ffffff"));
				break;
			case "dusk":
				mOne.setBackgroundColor(Color.parseColor("#666666"));
				mOne.setTextColor(Color.parseColor("#ff1493"));
				mTwo.setBackgroundColor(Color.parseColor("#ffff00"));
				mTwo.setTextColor(Color.parseColor("#666666"));
				mThree.setBackgroundColor(Color.parseColor("#666666"));
				mThree.setTextColor(Color.parseColor("#00b2ee"));
				mFour.setBackgroundColor(Color.parseColor("#ff1493"));
				mFour.setTextColor(Color.parseColor("#666666"));
				mFive.setBackgroundColor(Color.parseColor("#666666"));
				mFive.setTextColor(Color.parseColor("#ffff00"));
				mSix.setBackgroundColor(Color.parseColor("#00b2ee"));
				mSix.setTextColor(Color.parseColor("#666666"));
				break;
			case "rainbow":
				mOne.setBackgroundColor(Color.parseColor("#ff4444"));
				mOne.setTextColor(Color.parseColor("#ffffff"));
				mTwo.setBackgroundColor(Color.parseColor("#ff8800"));
				mTwo.setTextColor(Color.parseColor("#ffffff"));
				mThree.setBackgroundColor(Color.parseColor("#ffbb33"));
				mThree.setTextColor(Color.parseColor("#ffffff"));
				mFour.setBackgroundColor(Color.parseColor("#99cc00"));
				mFour.setTextColor(Color.parseColor("#ffffff"));
				mFive.setBackgroundColor(Color.parseColor("#0095ef"));
				mFive.setTextColor(Color.parseColor("#ffffff"));
				mSix.setBackgroundColor(Color.parseColor("#aa00ff"));
				mSix.setTextColor(Color.parseColor("#ffffff"));
				break;
			default:
				break;
		}
	}
	
	private void updateGrids()
	{
		mPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

		mOne.setText(mPrefs.getString("nameone", "Empty"));
		mOne.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					Intent p = new Intent(getActivity().getPackageManager().getLaunchIntentForPackage(mPrefs.getString("pkgnameone", "io.pure.sixgrid")));
					startActivity(p);
					getActivity().overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
				}
			});
			
		mTwo.setText(mPrefs.getString("nametwo", "Empty"));
		mTwo.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					Intent p = new Intent(getActivity().getPackageManager().getLaunchIntentForPackage(mPrefs.getString("pkgnametwo", "io.pure.sixgrid")));
					startActivity(p);
					getActivity().overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
				}
			});
		
		mThree.setText(mPrefs.getString("namethree", "Empty"));
		mThree.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					Intent p = new Intent(getActivity().getPackageManager().getLaunchIntentForPackage(mPrefs.getString("pkgnamethree", "io.pure.sixgrid")));
					startActivity(p);
					getActivity().overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
				}
			});
		
		mFour.setText(mPrefs.getString("namefour", "Empty"));
		mFour.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					Intent p = new Intent(getActivity().getPackageManager().getLaunchIntentForPackage(mPrefs.getString("pkgnamefour", "io.pure.sixgrid")));
					startActivity(p);
					getActivity().overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
				}
			});
		
		mFive.setText(mPrefs.getString("namefive", "Empty"));
		mFive.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					Intent p = new Intent(getActivity().getPackageManager().getLaunchIntentForPackage(mPrefs.getString("pkgnamefive", "io.pure.sixgrid")));
					startActivity(p);
					getActivity().overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
				}
			});
		
		mSix.setText(mPrefs.getString("namesix", "Empty"));
		mSix.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					Intent p = new Intent(getActivity().getPackageManager().getLaunchIntentForPackage(mPrefs.getString("pkgnamesix", "io.pure.sixgrid")));
					startActivity(p);
					getActivity().overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
				}
			});
	}
}
