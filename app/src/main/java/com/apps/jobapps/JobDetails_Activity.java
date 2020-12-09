package com.apps.jobapps;

import java.util.ArrayList;
import java.util.List;
import com.apps.jobapps.R;
import com.example.favorite.DatabaseHandler;
import com.example.favorite.Pojo;
import com.example.imageloader.ImageLoader;
import com.example.item.Item_CategoryList;
import com.example.util.AlertDialogManager;
import com.example.util.Constant;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class JobDetails_Activity  extends AppCompatActivity {

	ArrayList<Item_CategoryList> arrayOfJobDetails ;
	AlertDialogManager alert = new AlertDialogManager();
	public DatabaseHandler db;
	String allArrayjobid,allArrayjobcid,allArrayjobimage,allArrayjobname,allArrayjobdesc,
	allArrayjobsalary,allArrayjobvacancy,allArrayjobdesignation,allArrayjobskill,
	allArrayjobmail,allArrayjobphone,allArrayjobsite,allArrayjobcomname,
	allArrayjobaddress,allArrayjobquali,allArraymaplati,allArraymaplongi;
	int position;
	ImageView backicon,imgfavourite,imgshare,imgjob,imgmap;
	TextView txtjobname,txtjobdesc,txtsalary,txtvacancy,txtdesignation,txtskill,txtmail,txtphone,
	txtsite,txtcomname,txtaddress,txtquali;
	public ImageLoader imageLoader;
	private AdView mAdView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jobdetails_activity);

		mAdView = (AdView) findViewById(R.id.adView);
		mAdView.loadAd(new AdRequest.Builder().build());

		db=new DatabaseHandler(getApplicationContext());
		backicon=(ImageView)findViewById(R.id.img_back);
		imgfavourite=(ImageView)findViewById(R.id.img_jobfavo);
		imgshare=(ImageView)findViewById(R.id.img_share);
		imgjob=(ImageView)findViewById(R.id.img_jobs);
		imgmap=(ImageView)findViewById(R.id.img_mapicon);
		imageLoader=new ImageLoader(getApplicationContext());
		txtjobname=(TextView)findViewById(R.id.text_jobname);
		txtjobdesc=(TextView)findViewById(R.id.text_jobdesc);
		txtsalary=(TextView)findViewById(R.id.text_salary);
		txtvacancy=(TextView)findViewById(R.id.text_vacancy);
		txtdesignation=(TextView)findViewById(R.id.text_designation);
		txtskill=(TextView)findViewById(R.id.text_skill);
		txtmail=(TextView)findViewById(R.id.text_mail);
		txtphone=(TextView)findViewById(R.id.text_phone);
		txtsite=(TextView)findViewById(R.id.text_website);
		txtcomname=(TextView)findViewById(R.id.text_comname);
		txtaddress=(TextView)findViewById(R.id.text_address);
		txtquali=(TextView)findViewById(R.id.text_country);

		Intent i=getIntent();

		position=i.getIntExtra("POSITION", 0);

		allArrayjobid=i.getStringExtra("JID");
		allArrayjobcid=i.getStringExtra("JCID");
		allArrayjobimage=i.getStringExtra("JIMAGE");
		allArrayjobname=i.getStringExtra("JNAME");
		allArrayjobdesc=i.getStringExtra("JDESC");
		allArrayjobsalary=i.getStringExtra("JSALARY");
		allArrayjobvacancy=i.getStringExtra("JVACANCY");
		allArrayjobdesignation=i.getStringExtra("JDESIGN");
		allArrayjobskill=i.getStringExtra("JSKILL");
		allArrayjobmail=i.getStringExtra("JMAIL");
		allArrayjobphone=i.getStringExtra("JPHONE");
		allArrayjobsite=i.getStringExtra("JSITE");
		allArrayjobcomname=i.getStringExtra("JCOMNAME");
		allArrayjobaddress=i.getStringExtra("JADDRESS");
		allArrayjobquali=i.getStringExtra("JCOUNTRY");
		allArraymaplati=i.getStringExtra("JMAPLATI");
		allArraymaplongi=i.getStringExtra("JMAPLONGI");

		imageLoader.DisplayImage(Constant.SERVER_IMAGE_UPFOLDER+allArrayjobimage,imgjob);

		txtjobname.setText(allArrayjobname);
		String formattedString=android.text.Html.fromHtml(allArrayjobdesc).toString();
		txtjobdesc.setText(formattedString);
		txtsalary.setText(allArrayjobsalary);
		txtvacancy.setText(allArrayjobvacancy);
		txtdesignation.setText(allArrayjobdesignation);
		txtskill.setText(allArrayjobskill);
		txtmail.setText(allArrayjobmail);
		txtphone.setText(allArrayjobphone);
		txtsite.setText(allArrayjobsite);
		txtcomname.setText(allArrayjobcomname);
		txtaddress.setText(allArrayjobaddress);
		txtquali.setText(allArrayjobquali);

		List<Pojo> pojolist=db.getFavRow(allArrayjobid);
		if(pojolist.size()==0)
		{

			imgfavourite.setImageResource(R.drawable.fav_icon);
		}
		else
		{	
			if(pojolist.get(0).getJob_Id().equals(allArrayjobid));
			{
				imgfavourite.setImageResource(R.drawable.fav_hover_icon);
			}

		}

		backicon.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), "back", 500).show();
				onBackPressed();
			}
		});

		imgfavourite.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				List<Pojo> pojolist=db.getFavRow(allArrayjobid);
				if(pojolist.size()==0)
				{

					Toast.makeText(getApplicationContext(), "Add to Favorite", Toast.LENGTH_SHORT).show();
					db.AddtoFavorite(new Pojo(allArrayjobid,allArrayjobcid,allArrayjobimage,allArrayjobname,allArrayjobdesc,
							allArrayjobsalary,allArrayjobvacancy,allArrayjobdesignation,allArrayjobskill,
							allArrayjobmail,allArrayjobphone,allArrayjobsite,allArrayjobcomname,
							allArrayjobaddress,allArrayjobquali,allArraymaplati,allArraymaplongi));
					imgfavourite.setImageResource(R.drawable.fav_hover_icon);

				}
				else
				{	
					if(pojolist.get(0).getJob_Id().equals(allArrayjobid))
					{

						db.RemoveFav(new Pojo(allArrayjobid));
						Toast.makeText(getApplicationContext(), "Removed From Favorite", Toast.LENGTH_SHORT).show();
						imgfavourite.setImageResource(R.drawable.fav_icon);
					}
				}
			}
		});

		imgmap.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), "Map", Toast.LENGTH_SHORT).show();
				Intent intentmap=new Intent(getApplicationContext(),MapActivity.class);
				intentmap.putExtra("LATITUDE", allArraymaplati);
				intentmap.putExtra("LONGITUDE", allArraymaplongi);
				intentmap.putExtra("COMNAME", allArrayjobcomname);

				startActivity(intentmap);
			}
		});

		imgshare.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), "share", 500).show();
				Intent sendIntent = new Intent();
				sendIntent.setAction(Intent.ACTION_SEND);
				sendIntent.putExtra(Intent.EXTRA_TEXT,"Job Details: \n  "+txtjobname.getText().toString() +"\n  "+txtcomname.getText().toString() +"\n  "+txtaddress.getText().toString() +"\n"+" I Would like to share this with you. Here You Can Download This Application from PlayStore "+"https://play.google.com/store/apps/details?id="+getPackageName() );
				sendIntent.setType("text/plain");
				startActivity(sendIntent);

			}

		});

	}
}
