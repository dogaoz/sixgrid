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
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[] {"Animation", "Grids", "Reset UI"}));
		getListView().setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
	{
		switch (p3)
		{
			case 0:
				Intent anim = new Intent(this, AnimationPicker.class);
				startActivity(anim);
				finish();
				break;
			case 1:
				Intent grid = new Intent(this, CustomizeGrid.class);
				startActivity(grid);
				finish();
				break;
			case 2:
				Intent main = new Intent(this, MainActivity.class);
				startActivity(main);
				finish();
				break;
		}
	}

	@Override
	public void onBackPressed()
	{
		Intent main = new Intent(this, CustomizeGrid.class);
		main.putExtras(getIntent().getExtras());
		main.putExtra("reset", false);
		startActivity(main);
		finish();
	}
}
