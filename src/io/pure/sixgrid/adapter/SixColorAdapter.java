package io.pure.sixgrid.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.pure.sixgrid.R;

public class SixColorAdapter extends BaseAdapter
{
	private Context ctx;
	
	public SixColorAdapter(Context ctx) {
		this.ctx = ctx;
	}

	@Override
	public Object getItem(int p1)
	{
		// TODO: Implement this method
		return null;
	}

	@Override
	public int getCount()
	{
		return 6;
	}

	@Override
	public long getItemId(int p1)
	{
		// TODO: Implement this method
		return 0;
	}
	
	static class ViewHolder {
		TextView text;
		ImageView icon;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup p3)
	{
		int[] res = new int[] {R.drawable.def, R.drawable.mkbhd, R.drawable.chess, R.drawable.power, R.drawable.dusk, R.drawable.rainbow};
		String[] name = new String[] {"Default", "MKBHD", "Chessboard", "Powersaver", "Dusk", "Rainbow"};
		
		ViewHolder viewHolder;
		LayoutInflater li = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if (convertView==null){
			convertView = li.inflate(R.layout.color_item, null);

			viewHolder = new ViewHolder();
			viewHolder.text= (TextView)convertView.findViewById(R.id.color_text);
			viewHolder.icon= (ImageView)convertView.findViewById(R.id.color_image);

			convertView.setTag(viewHolder);
		}
		else
			viewHolder = (ViewHolder) convertView.getTag();

		viewHolder.text.setText(name[pos]);
		viewHolder.icon.setImageResource(res[pos]);

		return convertView;
	}
}
