package com.apps.jobapps;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.TextView;

import com.example.adapter.Favourite_Adapter;
import com.example.favorite.DatabaseHandler;
import com.example.favorite.Pojo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Favourite_Activity extends AppCompatActivity {

	ListView grid_fav;
	DatabaseHandler db;
	Favourite_Adapter favo_adapter;
	List<Pojo> allData;
	Pojo pojoitem;
	int textlength = 0;
	ArrayList<String> allListjobid,allListjobcid,allListjobimage,allListjobname,allListjobdesc,
	allListjobsalary,allListjobvacancy,allListjobdesignation,allListjobskill,
	allListjobmail,allListjobphone,allListjobsite,allListjobcomname,allListjobaddress,allListjobquali;

	String[] allArrayjobid,allArrayjobcid,allArrayjobimage,allArrayjobname,allArrayjobdesc,
	allArrayjobsalary,allArrayjobvacancy,allArrayjobdesignation,allArrayjobskill,
	allArrayjobmail,allArrayjobphone,allArrayjobsite,allArrayjobcomname,
	allArrayjobaddress,allArrayjobquali; 
	TextView txt_no;
	private AdView mAdView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		setContentView(R.layout.favorite_activity);

		mAdView = (AdView) findViewById(R.id.adView);
		mAdView.loadAd(new AdRequest.Builder().build());

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		SpannableString s = new SpannableString("My Favorite");
		getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#003e86")));
		getSupportActionBar().setTitle(s);

		db=new DatabaseHandler(getApplicationContext());
		grid_fav=(ListView)findViewById(R.id.favcategorylist_grid);
		txt_no=(TextView)findViewById(R.id.textView1);

		allData=db.getAllData();
		favo_adapter=new Favourite_Adapter(Favourite_Activity.this,R.layout.favorite_item,allData);
		grid_fav.setAdapter(favo_adapter);

		if(allData.size()==0)
		{
			txt_no.setVisibility(View.VISIBLE);
		}
		else
		{
			txt_no.setVisibility(View.INVISIBLE);
		}

		grid_fav.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				pojoitem=allData.get(position);

				String pos=pojoitem.getJob_Id();
				String jid=pojoitem.getJob_Id();
				String jcid=pojoitem.getJob_Catid();
				String jimage=pojoitem.getJob_Image();
				String jname=pojoitem.getJob_Name();
				String jdesc=pojoitem.getJob_Desc();
				String jsalary=pojoitem.getJob_Salary();
				String jvacancy=pojoitem.getJob_Vacancy();
				String jdesignation=pojoitem.getJob_Designation();
				String jskill=pojoitem.getJob_Skill();
				String jmail=pojoitem.getJob_Mail();
				String jphone=pojoitem.getJob_Phoneno();
				String jsite=pojoitem.getJob_Site();
				String jcomname=pojoitem.getJob_Comname();
				String jaddress=pojoitem.getJob_Address();
				String jcountry=pojoitem.getJob_Country();
				String jmaplati=pojoitem.getJob_Maplati();
				String jmaplongi=pojoitem.getJob_Maplongi();


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

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		//Log.e("Name", "Called");
		allData=db.getAllData();
		favo_adapter=new Favourite_Adapter(Favourite_Activity.this,R.layout.favorite_item,allData);
		grid_fav.setAdapter(favo_adapter);

		if(allData.size()==0)
		{
			txt_no.setVisibility(View.VISIBLE);

		}
		else
		{
			txt_no.setVisibility(View.INVISIBLE);

		}

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
				favo_adapter.filter(text);


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
