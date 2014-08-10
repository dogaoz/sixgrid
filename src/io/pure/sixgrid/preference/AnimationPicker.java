package io.pure.sixgrid.preference;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.ListPreference;

import io.pure.sixgrid.R;

public class AnimationPicker extends PreferenceActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.anim);
		
		ListPreference anim = (ListPreference)findPreference("swipeanim");
		anim.setEntries(new String[] {"Normal", "Fade In", "Fade Out", "Depth", "Depth (No Fade)", "Zoom", "Zoom (No Fade)"});
		anim.setEntryValues(new String[] {"normal", "fadein", "fadeout", "depth", "nfdepth", "zoom", "nfzoom"});
	}
	
	@Override
	public void onBackPressed()
	{
		Intent main = new Intent(AnimationPicker.this, SimplePreference.class);
		main.putExtra("var",true);
		startActivity(main);
		finish();
	}
}
