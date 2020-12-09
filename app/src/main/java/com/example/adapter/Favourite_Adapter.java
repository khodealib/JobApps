package com.example.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.jobapps.R;
import com.example.favorite.Pojo;
import com.example.imageloader.ImageLoader;
import com.example.util.Constant;

public class Favourite_Adapter extends ArrayAdapter<Pojo>
{
	private Activity activity;
	private List<Pojo> pojoitem;
	private Pojo objPojoBean;
	private int row;
	public ImageLoader imageLoader;
	private ArrayList<Pojo> arraylist;
	public Favourite_Adapter(Activity act, int resource, List<Pojo> arrayList) {
		super(act, resource, arrayList);
		this.activity = act;
		this.row = resource;
		this.pojoitem = arrayList;
		imageLoader=new ImageLoader(activity);
		this.arraylist = new ArrayList<Pojo>();
		arraylist.addAll(pojoitem); 
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder holder;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(row, null);

			holder = new ViewHolder();
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		if ((pojoitem == null) || ((position + 1) > pojoitem.size()))
			return view;

		objPojoBean = pojoitem.get(position);

		holder.imgv_categorylist=(ImageView)view.findViewById(R.id.img_favcatelist);
		holder.txt_categoryname=(TextView)view.findViewById(R.id.text_favcatelist);

		imageLoader.DisplayImage(Constant.SERVER_IMAGE_THUMB+objPojoBean.getJob_Image().toString(), holder.imgv_categorylist);
		holder.txt_categoryname.setText(objPojoBean.getJob_Name().toString());

		return view;

	}

	public class ViewHolder {

		public ImageView imgv_categorylist;
		public  TextView txt_categoryname;

	}
	
	public void filter(String charText) {
		charText = charText.toLowerCase(Locale.getDefault());
		pojoitem.clear();
		if (charText.length() == 0) {
			pojoitem.addAll(arraylist);
		} 
		else 
		{
			for (Pojo wp : arraylist) 
			{
				if (wp.getJob_Name().toLowerCase(Locale.getDefault()).contains(charText)) 
				{
					pojoitem.add(wp);
				}
			}
		}

		 notifyDataSetChanged();
	}
} 
