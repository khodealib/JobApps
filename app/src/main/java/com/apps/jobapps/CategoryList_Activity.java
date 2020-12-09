package com.apps.jobapps;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.CategoryList_Adapter;
import com.example.item.Item_CategoryList;
import com.example.util.AlertDialogManager;
import com.example.util.Constant;
import com.example.util.JsonUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;


public class CategoryList_Activity  extends AppCompatActivity
{
	ListView gridView;
	ArrayList<Item_CategoryList> arrayOfCateList ;
	CategoryList_Adapter categorylistadpter;
	AlertDialogManager alert = new AlertDialogManager();
	Item_CategoryList itemcatelist;
	private Item_CategoryList objAllBean;
	int textlength = 0;
	private ArrayList<Item_CategoryList> arraylist;
	
	ArrayList<String> allListjobid,allListjobcid,allListjobimage,allListjobname,allListjobdesc,
	allListjobsalary,allListjobvacancy,allListjobdesignation,allListjobskill,
	allListjobmail,allListjobphone,allListjobsite,allListjobcomname,allListjobaddress,
	allListjobquali,allListmaplati,allListmaplongi;

	String[] allArrayjobid,allArrayjobcid,allArrayjobimage,allArrayjobname,allArrayjobdesc,
	allArrayjobsalary,allArrayjobvacancy,allArrayjobdesignation,allArrayjobskill,
	allArrayjobmail,allArrayjobphone,allArrayjobsite,allArrayjobcomname,
	allArrayjobaddress,allArrayjobquali,allArraymaplati,allArraymaplongi; 
	private AdView mAdView;
 
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.categorylist_activity);
		
		mAdView = (AdView) findViewById(R.id.adView);
		mAdView.loadAd(new AdRequest.Builder().build());
 
 		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#003e86")));
 		SpannableString s = new SpannableString(Constant.CATEGORYNAME);
 		getSupportActionBar().setTitle(s);
 
		gridView = (ListView)findViewById(R.id.categorylist_grid);
		arrayOfCateList= new ArrayList<Item_CategoryList>();
		this.arraylist = new ArrayList<Item_CategoryList>();

		allListjobid=new ArrayList<String>();
		allListjobcid=new ArrayList<String>();
		allListjobimage=new ArrayList<String>();
		allListjobname=new ArrayList<String>();
		allListjobdesc=new ArrayList<String>();
		allListjobsalary=new ArrayList<String>();
		allListjobvacancy=new ArrayList<String>();
		allListjobdesignation=new ArrayList<String>();
		allListjobskill=new ArrayList<String>();
		allListjobmail=new ArrayList<String>();
		allListjobphone=new ArrayList<String>();
		allListjobsite=new ArrayList<String>();
		allListjobcomname=new ArrayList<String>();
		allListjobaddress=new ArrayList<String>();
		allListjobquali=new ArrayList<String>();
		allListmaplati=new ArrayList<String>();
		allListmaplongi=new ArrayList<String>();
 
		allArrayjobid=new String[allListjobid.size()];
		allArrayjobcid=new String[allListjobcid.size()];
		allArrayjobimage=new String[allListjobimage.size()];
		allArrayjobname=new String[allListjobname.size()];
		allArrayjobdesc=new String[allListjobdesc.size()];
		allArrayjobsalary=new String[allListjobsalary.size()];
		allArrayjobvacancy=new String[allListjobvacancy.size()];
		allArrayjobdesignation=new String[allListjobdesignation.size()];
		allArrayjobskill=new String[allListjobskill.size()];
		allArrayjobmail=new String[allListjobmail.size()];
		allArrayjobphone=new String[allListjobphone.size()];
		allArrayjobsite=new String[allListjobsite.size()];
		allArrayjobcomname=new String[allListjobcomname.size()];
		allArrayjobaddress=new String[allListjobaddress.size()];
		allArrayjobquali=new String[allListjobquali.size()];
		allArraymaplati=new String[allListmaplati.size()];
		allArraymaplongi=new String[allListmaplongi.size()];


		if (JsonUtils.isNetworkAvailable(CategoryList_Activity.this)) {
			new MyTask().execute(Constant.CATEGORYLIST_URL+Constant.CATEGORYID);
		} else {
			showToast(getString(R.string.conne_msg1));
			alert.showAlertDialog(CategoryList_Activity.this, getString(R.string.conne_msg2),
					getString(R.string.conne_msg3), false);
		}

		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				objAllBean=arrayOfCateList.get(position);
				String pos=objAllBean.getJob_Id();
				String jid=objAllBean.getJob_Id();
				String jcid=objAllBean.getJob_Catid();
				String jimage=objAllBean.getJob_Image();
				String jname=objAllBean.getJob_Name();
				String jdesc=objAllBean.getJob_Desc();
				String jsalary=objAllBean.getJob_Salary();
				String jvacancy=objAllBean.getJob_Vacancy();
				String jdesignation=objAllBean.getJob_Designation();
				String jskill=objAllBean.getJob_Skill();
				String jmail=objAllBean.getJob_Mail();
				String jphone=objAllBean.getJob_Phoneno();
				String jsite=objAllBean.getJob_Site();
				String jcomname=objAllBean.getJob_Comname();
				String jaddress=objAllBean.getJob_Address();
				String jcountry=objAllBean.getJob_Country();
				String jmaplati=objAllBean.getJob_Maplati();
				String jmaplongi=objAllBean.getJob_Maplongi();

				Intent intplay=new Intent(getApplicationContext(),JobDetails_Activity.class);
				intplay.putExtra("POSITION", pos);
				intplay.putExtra("JID", jid);
				intplay.putExtra("JCID", jcid);
				intplay.putExtra("JIMAGE", jimage);
				intplay.putExtra("JNAME", jname);
				intplay.putExtra("JDESC", jdesc);
				intplay.putExtra("JSALARY", jsalary);
				intplay.putExtra("JVACANCY", jvacancy);
				intplay.putExtra("JDESIGN", jdesignation);
				intplay.putExtra("JSKILL", jskill);
				intplay.putExtra("JMAIL", jmail);
				intplay.putExtra("JPHONE", jphone);
				intplay.putExtra("JSITE", jsite);
				intplay.putExtra("JCOMNAME", jcomname);
				intplay.putExtra("JADDRESS", jaddress);
				intplay.putExtra("JCOUNTRY", jcountry);
				intplay.putExtra("JMAPLATI", jmaplati);
				intplay.putExtra("JMAPLONGI", jmaplongi);

 				startActivity(intplay);
			}
		});
	}
 
	private	class MyTask extends AsyncTask<String, Void, String> {

		ProgressDialog pDialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			pDialog = new ProgressDialog(CategoryList_Activity.this);
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
				alert.showAlertDialog(CategoryList_Activity.this, getString(R.string.conne_msg4),
						getString(R.string.conne_msg5), false);

			} else {

				try {
					JSONObject mainJson = new JSONObject(result);
					JSONArray jsonArray = mainJson.getJSONArray(Constant.CATEGORY_ARRAY_NAME);
					JSONObject objJson = null;
					for (int i = 0; i < jsonArray.length(); i++) {
						objJson = jsonArray.getJSONObject(i);

						Item_CategoryList objItem = new Item_CategoryList();

						objItem.setJob_Id(objJson.getString(Constant.JOB_ID));
						objItem.setJob_Catid(objJson.getString(Constant.JOB_CAT_ID));
						objItem.setJob_Image(objJson.getString(Constant.JOB_IMAGE));
						objItem.setJob_Name(objJson.getString(Constant.JOB_NAME));
						objItem.setJob_Desc(objJson.getString(Constant.JOB_DESC));
						objItem.setJob_Salary(objJson.getString(Constant.JOB_SALARY));
						objItem.setJob_Vacancy(objJson.getString(Constant.JOB_VACANCY));
						objItem.setJob_Designation(objJson.getString(Constant.JOB_DESIGN));
						objItem.setJob_Skill(objJson.getString(Constant.JOB_SKILL));
						objItem.setJob_Mail(objJson.getString(Constant.JOB_MAIL));
						objItem.setJob_Phoneno(objJson.getString(Constant.JOB_PHNENO));
						objItem.setJob_Site(objJson.getString(Constant.JOB_SITE));
						objItem.setJob_Comname(objJson.getString(Constant.JOB_COMNAME));
						objItem.setJob_Address(objJson.getString(Constant.JOB_ADDRESS));
						objItem.setJob_Country(objJson.getString(Constant.JOB_QUALI));
						objItem.setJob_Maplati(objJson.getString(Constant.JOB_MAPLATI));
						objItem.setJob_Maplongi(objJson.getString(Constant.JOB_MAPLONGI));
 
						arrayOfCateList.add(objItem);
 
					}


				} catch (JSONException e) {
					e.printStackTrace();
				}

				arraylist.addAll(arrayOfCateList);
				setAdapterToListview();
			}

		}
	}
	public void setAdapterToListview() {
		categorylistadpter = new CategoryList_Adapter(CategoryList_Activity.this, R.layout.categorylist_item,
				arrayOfCateList);
		gridView.setAdapter(categorylistadpter);
	}

	public void showToast(String msg) {
		Toast.makeText(CategoryList_Activity.this, msg, Toast.LENGTH_LONG).show();
	}

	public void filter(String charText) {
		charText = charText.toLowerCase(Locale.getDefault());
		arrayOfCateList.clear();
		if (charText.length() == 0) {
			arrayOfCateList.addAll(arraylist);
		} 
		else 
		{
			for (Item_CategoryList wp : arraylist) 
			{
				if (wp.getJob_Name().toLowerCase(Locale.getDefault()).contains(charText)) 
				{
					arrayOfCateList.add(wp);
				}
			}
		}

		setAdapterToListview();
	}
 
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_search, menu);

		final SearchView searchView = (SearchView) menu.findItem(R.id.search)
				.getActionView();

		final MenuItem searchMenuItem = menu.findItem(R.id.search);
		searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				if(!hasFocus) {
					searchMenuItem.collapseActionView();
					searchView.setQuery("", false);
				}
			}
		});


		searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
			@Override
			public boolean onQueryTextChange(String newText) {


				String text = newText.toString().toLowerCase(Locale.getDefault());
				filter(text);

				return false;
			}

			@Override
			public boolean onQueryTextSubmit(String query) {
				// Do something
				return true;
			}
		});
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem)
	{       
		switch (menuItem.getItemId()) 
		{
		case android.R.id.home: 
			onBackPressed();
			break;

		default:
			return super.onOptionsItemSelected(menuItem);
		}
		return true;
	}
 }
