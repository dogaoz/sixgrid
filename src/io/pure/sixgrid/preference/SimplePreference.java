package io.pure.sixgrid.preference;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import io.pure.sixgrid.MainActivity;
import io.pure.sixgrid.R;

public class SimplePreference extends ListActivity implements AdapterView.OnItemClickListener
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple);
		
		setListAdapter(new ArrayAdapter<String>(this, R.layout.simple_item, new String[] {"Animation", "Grids", "Colors", "Reset UI"}));
		getListView().setOnItemClickListener(this);
		getListView().setDividerHeight(0);
	}

	@Override
	public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
	{
		switch (p3)
		{
			case 0:
				Intent anim = new Intent(this, AnimationPicker.class);
				startActivity(anim);
				overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
				finish();
				break;
			case 1:
				Intent grid = new Intent(this, CustomizeGrid.class);
				grid.putExtra("reset", false);
				startActivity(grid);
				overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
				finish();
				break;
			case 2:
				Intent colors = new Intent(this, ColorProfiles.class);
				startActivity(colors);
				overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
				finish();
				break;
			case 3:
				Intent main = new Intent(this, MainActivity.class);
				startActivity(main);
				overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
				finish();
				break;
		}
	}

	@Override
	public void onBackPressed()
	{
		Intent main = new Intent(this, MainActivity.class);
		main.putExtra("var", true);
		startActivity(main);
		overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
		finish();
	}
}
