package io.pure.sixgrid.drawer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;

import io.pure.sixgrid.R;

import java.util.List;

public class AppsFragment extends Fragment {
	DrawerAdapter drawerAdapterObject;
	GridView drawerGrid;
	class Pac{
		Drawable icon;
		String name;
		String label;
	}
	Pac[] pacs;
	PackageManager pm;
	
	public AppsFragment()
	{}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.drawer, container, false);
		drawerGrid = (GridView)rootView.findViewById(R.id.appsgrid);
		pm = getActivity().getPackageManager();
		set_pacs();
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
		
		if (prefs.getBoolean("appanim", true) == true) {
			Animation anim = AnimationUtils.loadAnimation(getActivity(), R.anim.grid);
			drawerGrid.setAnimation(anim);
			drawerGrid.animate();
		}
		
		drawerAdapterObject = new DrawerAdapter(getActivity(), pacs);
		drawerGrid.setAdapter(drawerAdapterObject);
		drawerGrid.setOnItemClickListener(new DrawerClickListener(getActivity(), pacs, pm));
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_PACKAGE_ADDED);
		filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
		filter.addAction(Intent.ACTION_PACKAGE_CHANGED);
		filter.addDataScheme("package");
		getActivity().registerReceiver(new PacReceiver(), filter);
		
		return rootView;
	}

	public void set_pacs(){
		final Intent mainIntent = new Intent(Intent.ACTION_MAIN,null);
		mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		List<ResolveInfo> pacsList = pm.queryIntentActivities(mainIntent, 0);
		pacs = new Pac[pacsList.size()];
		for(int I=0;I<pacsList.size();I++){
			pacs[I]= new Pac();
			pacs[I].icon=pacsList.get(I).loadIcon(pm);
			pacs[I].name=pacsList.get(I).activityInfo.packageName;
			pacs[I].label=pacsList.get(I).loadLabel(pm).toString();
		}
		
		new SortApps().exchange_sort(pacs);
	}
	
	public class PacReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			set_pacs();
		}

	}

}
