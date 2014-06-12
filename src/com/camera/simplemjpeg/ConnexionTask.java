package com.camera.simplemjpeg;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.os.AsyncTask;

public class ConnexionTask extends AsyncTask<Void, Void, Void> {
	private String url;
	
	
	public ConnexionTask(String url) {
		this.url = url;
	}
	
	protected Void doInBackground(Void... arg0) {
		try {
			query(url);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void query(String url) throws ClientProtocolException, IOException{
		HttpParams httpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(httpParams, 5000);
		HttpConnectionParams.setSoTimeout(httpParams, 8000);
		
		HttpClient client = new DefaultHttpClient(httpParams);
		
		HttpGet httpGet = new HttpGet(url);
		
		client.execute(httpGet);
	}
}
