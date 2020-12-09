package com.apps.jobapps;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MapActivity extends FragmentActivity {
 
	private GoogleMap googleMap;
	int position;
	String alllatitude,alllongitude,allcomname,alladdress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_activity);
		
 		Intent i=getIntent();
 		position=i.getIntExtra("POSITION", 0);
 		alllatitude=i.getStringExtra("LATITUDE");
		alllongitude=i.getStringExtra("LONGITUDE");
		allcomname=i.getStringExtra("COMNAME");
		 
		
		LatLng TutorialsPoint = new LatLng(Double.parseDouble(alllatitude), Double.parseDouble(alllongitude));
		try {
			if (googleMap == null) {
				googleMap = ((MapFragment) getFragmentManager()
						.findFragmentById(R.id.map)).getMap();
			}
			googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(TutorialsPoint, 15.0f));
			googleMap.addMarker(new MarkerOptions().position(TutorialsPoint)
					.title(allcomname));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
