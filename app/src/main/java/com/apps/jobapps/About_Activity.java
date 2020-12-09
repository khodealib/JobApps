package com.apps.jobapps;

import java.io.IOException;
import java.io.InputStream;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.webkit.WebView;
import com.apps.jobapps.R;

public class About_Activity  extends AppCompatActivity {

	String summary = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_activity);
		WebView webview = new WebView(this);
		setContentView(webview);
		try {
			InputStream fin = getAssets().open("index.html");
			byte[] buffer = new byte[fin.available()];
			fin.read(buffer);
			fin.close();
			webview.loadData(new String(buffer), "text/html", "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
