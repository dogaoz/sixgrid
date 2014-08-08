package io.pure.sixgrid.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.animation.Animation;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import io.pure.sixgrid.R;
import io.pure.sixgrid.drawer.AppsFragment;

public class HomeFragment extends Fragment
{
	Button mApps;
	ViewGroup.LayoutParams mAppsParams;
	Button mMessages;
	ViewGroup.LayoutParams mMessagesParams;
	Button mDialer;
	ViewGroup.LayoutParams mDialerParams;
	Button mBrowser;
	ViewGroup.LayoutParams mBrowserParams;
	Button mCamera;
	ViewGroup.LayoutParams mCameraParams;
	Button mSettings;
	ViewGroup.LayoutParams mSettingsParams;
	
	public HomeFragment()
	{}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.home, container, false);
		
		WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int dispwidth = size.x;
		int dispheight = size.y;
		
		mApps = (Button)rootView.findViewById(R.id.apps);
		mAppsParams = mApps.getLayoutParams();
		mAppsParams.width = dispwidth / 2;
		mAppsParams.height = dispheight / 3 - 8;
		mApps.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				ViewPager viewPager = (ViewPager)getActivity().findViewById(R.id.pager);
				viewPager.setCurrentItem(0, true);
			}
		});
		
		mMessages = (Button)rootView.findViewById(R.id.messages);
		mMessagesParams = mMessages.getLayoutParams();
		mMessagesParams.width = dispwidth / 2;
		mMessagesParams.height = dispheight / 3 - 8;
		mMessages.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent messages = new Intent(Intent.ACTION_VIEW);
				messages.setData(Uri.parse("sms:"));
				startActivity(messages);
			}
		});
		
		mDialer = (Button)rootView.findViewById(R.id.dialer);
		mDialerParams = mDialer.getLayoutParams();
		mDialerParams.width = dispwidth / 2;
		mDialerParams.height = dispheight / 3 - 8;
		mDialer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent dialer = new Intent(Intent.ACTION_VIEW);
				dialer.setData(Uri.parse("tel:"));
				startActivity(dialer);
			}
		});
		
		mBrowser = (Button)rootView.findViewById(R.id.browser);
		mBrowserParams = mBrowser.getLayoutParams();
		mBrowserParams.width = dispwidth / 2;
		mBrowserParams.height = dispheight / 3 - 8;
		mBrowser.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent browser = new Intent(Intent.ACTION_VIEW);
				browser.setData(Uri.parse("http:"));
				startActivity(browser);
			}
		});
		
		mCamera = (Button)rootView.findViewById(R.id.camera);
		mCameraParams = mCamera.getLayoutParams();
		mCameraParams.width = dispwidth / 2;
		mCameraParams.height = dispheight / 3 - 8;
		mCamera.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent camera = new Intent("android.media.action.IMAGE_CAPTURE");
				startActivityForResult(camera, 1337);
			}
		});
		
		mSettings = (Button)rootView.findViewById(R.id.settings);
		mSettingsParams = mSettings.getLayoutParams();
		mSettingsParams.width = dispwidth / 2;
		mSettingsParams.height = dispheight / 3 - 8;
		mSettings.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent settings = new Intent(Settings.ACTION_SETTINGS);
				startActivity(settings);
			}
		});
		
		return rootView;
	}
}
