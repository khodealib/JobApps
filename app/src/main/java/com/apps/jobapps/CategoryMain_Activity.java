package com.apps.jobapps;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.CategoryMain_Adapter;
import com.example.item.Item_CategoryMain;
import com.example.util.AlertDialogManager;
import com.example.util.Constant;
import com.example.util.JsonUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.onesignal.OneSignal;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CategoryMain_Activity extends AppCompatActivity {

	ListView listcategory;
	ArrayList<Item_CategoryMain> arrayOfCategory ;
	CategoryMain_Adapter categorydAdapter;
	TextView txttitle;
	ImageView imgfavourite;
	AlertDialogManager alert = new AlertDialogManager();
	Item_CategoryMain item;
	private AdView mAdView;
	StartAppAd startAppAd;
	final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 102;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);

		OneSignal.startInit(this).init();
		StartAppSDK.init(this, getString(R.string.startapp_app_id),false);
		StartAppAd.disableSplash();

		setContentView(R.layout.categorymain_activity);

		startAppAd = new StartAppAd(this);
		startAppAd.loadAd(new AdEventListener() {

			@Override
			public void onReceiveAd(Ad arg0) {
				// TODO Auto-generated method stub
				startAppAd.showAd(); // show the ad
				startAppAd.loadAd(); // load the next ad
			}

			@Override
			public void onFailedToReceiveAd(Ad arg0) {
				// TODO Auto-generated method stub

			}
		});

		mAdView = (AdView) findViewById(R.id.adView);
		mAdView.loadAd(new AdRequest.Builder().build());

		txttitle=(TextView)findViewById(R.id.text_title);

		imgfavourite=(ImageView)findViewById(R.id.img_favo);
		imgfavourite.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intentfav=new Intent(getApplicationContext(),Favourite_Activity.class);
				startActivity(intentfav);
			}
		});

		listcategory = (ListView) findViewById(R.id.listView_category);
		arrayOfCategory= new ArrayList<Item_CategoryMain>();

		if (JsonUtils.isNetworkAvailable(CategoryMain_Activity.this)) {
			new MyTask().execute(Constant.CATEGORY_URL);
		} else {
			showToast(getString(R.string.conne_msg1));
			alert.showAlertDialog(CategoryMain_Activity.this, getString(R.string.conne_msg2),
					getString(R.string.conne_msg3), false);
		}


		listcategory.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				item=arrayOfCategory.get(position);
				Constant.CATEGORYID=item.getCategoryId();
				Constant.CATEGORYNAME=item.getCategoryName();
				//Log.e("item", ""+Constant.CATEGORYID);
				Intent intentsub=new Intent(getApplicationContext(),CategoryList_Activity.class);
				startActivity(intentsub);

			}
		});
		checkPer();

	}
	private	class MyTask extends AsyncTask<String, Void, String> {

		ProgressDialog pDialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			pDialog = new ProgressDialog(CategoryMain_Activity.this);
			pDialog.setMessage(getString(R.string.loading));
			pDialog.setCancelable(false);
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... params) {
			return JsonUtils.getJSONString(params[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);

			if (null != pDialog && pDialog.isShowing()) {
				pDialog.dismiss();
			}

			if (null == result || result.length() == 0) {
				showToast(getString(R.string.conne_msg4));
				alert.showAlertDialog(CategoryMain_Activity.this, getString(R.string.conne_msg4),
						getString(R.string.conne_msg5), false);

			} else {

				try {
					JSONObject mainJson = new JSONObject(result);
					JSONArray jsonArray = mainJson.getJSONArray(Constant.CATEGORY_ARRAY_NAME);
					JSONObject objJson = null;
					for (int i = 0; i < jsonArray.length(); i++) {
						objJson = jsonArray.getJSONObject(i);

						Item_CategoryMain objItem = new Item_CategoryMain();

						objItem.setCategoryId(objJson.getInt(Constant.CATEGORY_CID));
						objItem.setCategoryName(objJson.getString(Constant.CATEGORY_NAME));
						objItem.setImageurl(objJson.getString(Constant.CATEGORY_IMAGE));

						arrayOfCategory.add(objItem);
					}

				} catch (JSONException e) {
					e.printStackTrace();
				}


				setAdapterToListview();
			}

		}
	}

	public void setAdapterToListview() {
		categorydAdapter = new CategoryMain_Adapter(CategoryMain_Activity.this, R.layout.categoymain_item,
				arrayOfCategory);
		listcategory.setAdapter(categorydAdapter);
	}

	public void showToast(String msg) {
		Toast.makeText(CategoryMain_Activity.this, msg, Toast.LENGTH_LONG).show();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) 
	{
		switch (item.getItemId()) 
		{

		case R.id.About:
			Intent intentabout=new Intent(getApplicationContext(),About_Activity.class);
			startActivity(intentabout);
			return true;

		}

		return(super.onOptionsItemSelected(item));
	}

	public void checkPer()
	{

		if ((ContextCompat.checkSelfPermission(CategoryMain_Activity.this,"android.permission.WRITE_EXTERNAL_STORAGE") != PackageManager.PERMISSION_GRANTED)) {

			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
				requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"},
						MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
			}
		} else {
			// user already provided permission
			// perform function for what you want to achieve
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

		boolean canUseExternalStorage = false;

		switch (requestCode) {
			case MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE: {
				if (grantResults.length > 0
						&& grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					canUseExternalStorage = true;
				}

				if (!canUseExternalStorage) {
					Toast.makeText(CategoryMain_Activity.this, "You cannot see images without requested permission", Toast.LENGTH_SHORT).show();
				} else {
					// user now provided permission
					// perform function for what you want to achieve

				}
			}
		}
	}

	@Override
	public void onResume(){
		super.onResume();
	} 
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			// Toast.makeText(appContext, "BAck", Toast.LENGTH_LONG).show();
			AlertDialog.Builder alert = new AlertDialog.Builder(
					CategoryMain_Activity.this);
			alert.setTitle(getString(R.string.app_name));
			alert.setIcon(R.drawable.app_icon);
			alert.setMessage("Are You Sure You Want To Quit?");

			alert.setPositiveButton("Yes",
					new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,
						int whichButton) {
					finish();
				}

			});

			alert.setNegativeButton("Rate App",
					new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {

					final String appName = getPackageName();
					try {
						startActivity(new Intent(Intent.ACTION_VIEW,
								Uri.parse("market://details?id="
										+ appName)));
					} catch (android.content.ActivityNotFoundException anfe) {
						startActivity(new Intent(
								Intent.ACTION_VIEW,
								Uri.parse("http://play.google.com/store/apps/details?id="
										+ appName)));
					}
				}
			});
			alert.show();
			return true;
		}

		return super.onKeyDown(keyCode, event);

	}
}
