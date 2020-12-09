package com.example.adapter;

import java.util.List;
import com.apps.jobapps.R;
import com.example.imageloader.ImageLoader;
import com.example.item.Item_CategoryMain;
import com.example.util.Constant;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CategoryMain_Adapter extends  ArrayAdapter<Item_CategoryMain> {


	private Activity activity;
	private List<Item_CategoryMain> itemsCategory;
	private Item_CategoryMain objCategoryBean;
	private int row;
	public ImageLoader imageLoader;

	public CategoryMain_Adapter(Activity act, int resource, List<Item_CategoryMain> arrayList) {
		super(act, resource, arrayList);
		this.activity = act;
		this.row = resource;
		this.itemsCategory = arrayList;
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

		if ((itemsCategory == null) || ((position + 1) > itemsCategory.size()))
			return view;

		objCategoryBean = itemsCategory.get(position);


		holder.imgv_category=(ImageView)view.findViewById(R.id.imageView_cateogry);
		holder.txt_category=(TextView)view.findViewById(R.id.textView_category);


		imageLoader.DisplayImage(Constant.SERVER_IMAGE_UPFOLDER+objCategoryBean.getImageurl().toString(), holder.imgv_category);
		holder.txt_category.setText(objCategoryBean.getCategoryName().toString());

		return view;

	}

	public class ViewHolder {

		public ImageView imgv_category;
		public  TextView txt_category;

	}
} 



