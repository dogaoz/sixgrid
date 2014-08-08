package io.pure.sixgrid;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class License extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		WebView license = new WebView(this);
		setContentView(license);
		license.loadUrl("file:///android_asset/license.html");
	}
}
