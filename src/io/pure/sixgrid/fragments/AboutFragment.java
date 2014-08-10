package io.pure.sixgrid.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import io.pure.sixgrid.License;
import io.pure.sixgrid.R;
import io.pure.sixgrid.preference.SimplePreference;

public class AboutFragment extends Fragment
{
	public AboutFragment() {}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.about, container, false);
		
		TextView tv = (TextView)rootView.findViewById(R.id.aboutTextView);
		tv.setMovementMethod(LinkMovementMethod.getInstance());
		
		Button bt = (Button)rootView.findViewById(R.id.license);
		bt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) 
			{
				Intent i = new Intent(getActivity(), License.class);
				startActivity(i);
			}
		});
		
		Button ct = (Button)rootView.findViewById(R.id.custombt);
		ct.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent i = new Intent(getActivity(), SimplePreference.class);
				startActivity(i);
				getActivity().finish();
			}
		});
		
		return rootView;
	}
}
