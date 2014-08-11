package io.pure.sixgrid.preference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import io.pure.sixgrid.MainActivity;
import io.pure.sixgrid.R;
import io.pure.sixgrid.adapter.SixColorAdapter;

public class ColorProfiles extends Activity implements AdapterView.OnItemClickListener
{
	SharedPreferences mPrefs = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.color);
		
		GridView gv = (GridView)findViewById(R.id.colorshow);
		gv.setAdapter(new SixColorAdapter(this));
		gv.setOnItemClickListener(this);
		
		mPrefs = getSharedPreferences("io.pure.sixgrid", MODE_PRIVATE);
	}

	@Override
	public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
	{
		switch (p3) {
			case 0:
				mPrefs.edit().remove("cprofile").commit();
				mPrefs.edit().putString("cprofile", "default").commit();
				Intent cprofileint = new Intent(this, MainActivity.class);
				startActivity(cprofileint);
				overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
				finish();
				break;
			case 1:
				mPrefs.edit().remove("cprofile").commit();
				mPrefs.edit().putString("cprofile", "mkbhd").commit();
				Intent cprofileint2 = new Intent(this, MainActivity.class);
				startActivity(cprofileint2);
				overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
				finish();
				break;
			case 2:
				mPrefs.edit().remove("cprofile").commit();
				mPrefs.edit().putString("cprofile", "chess").commit();
				Intent cprofileint3 = new Intent(this, MainActivity.class);
				startActivity(cprofileint3);
				overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
				finish();
				break;
			case 3:
				mPrefs.edit().remove("cprofile").commit();
				mPrefs.edit().putString("cprofile", "power").commit();
				Intent cprofileint4 = new Intent(this, MainActivity.class);
				startActivity(cprofileint4);
				overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
				finish();
				Toast.makeText(getApplicationContext(), "The power saver profile is for AMOLED screens only. You may still use it as a pitch black background.", Toast.LENGTH_LONG).show();
				break;
			case 4:
				mPrefs.edit().remove("cprofile").commit();
				mPrefs.edit().putString("cprofile", "dusk").commit();
				Intent cprofileint5 = new Intent(this, MainActivity.class);
				startActivity(cprofileint5);
				overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
				finish();
				break;
			case 5:
				mPrefs.edit().remove("cprofile").commit();
				mPrefs.edit().putString("cprofile", "rainbow").commit();
				Intent cprofileint6 = new Intent(this, MainActivity.class);
				startActivity(cprofileint6);
				overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
				finish();
				break;
		}
	}

	@Override
	public void onBackPressed()
	{
		Intent i = new Intent(this, MainActivity.class);
		i.putExtra("var", true);
		startActivity(i);
		overridePendingTransition(R.anim.slide_up_bottom, R.anim.slide_down_bottom);
		finish();
	}
}
