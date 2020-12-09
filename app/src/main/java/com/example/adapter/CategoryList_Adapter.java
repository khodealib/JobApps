package com.example.adapter;

import java.util.List;
import com.apps.jobapps.R;
import com.example.imageloader.ImageLoader;
import com.example.item.Item_CategoryList;
import com.example.util.Constant;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CategoryList_Adapter extends ArrayAdapter<Item_CategoryList>
{
	private Activity activity;
	private List<Item_CategoryList> itemsCategorylist;
	private Item_CategoryList objCategorylistBean;
	private int row;
	public ImageLoader imageLoader;

	public CategoryList_Adapter(Activity act, int resource, List<Item_CategoryList> arrayList) {
		super(act, resource, arrayList);
		this.activity = act;
		this.row = resource;
		this.itemsCategorylist = arrayList;
		imageLoader=new ImageLoader(activity);
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

		if ((itemsCategorylist == null) || ((position + 1) > itemsCategorylist.size()))
			return view;

		objCategorylistBean = itemsCategorylist.get(position);


		holder.imgv_categorylist=(ImageView)view.findViewById(R.id.img_catelist);
		holder.txt_categoryname=(TextView)view.findViewById(R.id.text_catelist);

		imageLoader.DisplayImage(Constant.SERVER_IMAGE_THUMB+objCategorylistBean.getJob_Image().toString(), holder.imgv_categorylist);
		holder.txt_categoryname.setText(objCategorylistBean.getJob_Name().toString());

		return view;

	}

	public class ViewHolder {

		public ImageView imgv_categorylist;
		public  TextView txt_categoryname;

	}
} 
