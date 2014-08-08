package io.pure.sixgrid.drawer;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.GridView;

import io.pure.sixgrid.R;

import java.util.List;

public class AppsActivity extends Activity {
	DrawerAdapter drawerAdapterObject;
	GridView drawerGrid;
	class Pac{
		Drawable icon;
		String name;
		String label;
	}
	Pac[] pacs;
	PackageManager pm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawer);
		drawerGrid = (GridView) findViewById(R.id.appsgrid);
		pm = getPackageManager();
		set_pacs();
		drawerAdapterObject = new DrawerAdapter(this, pacs);
		drawerGrid.setAdapter(drawerAdapterObject);
		drawerGrid.setOnItemClickListener(new DrawerClickListener(this, pacs, pm));
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_PACKAGE_ADDED);
		filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
		filter.addAction(Intent.ACTION_PACKAGE_CHANGED);
		filter.addDataScheme("package");
		registerReceiver(new PacReceiver(), filter);
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
