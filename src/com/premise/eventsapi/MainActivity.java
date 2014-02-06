package com.premise.eventsapi;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.premise.eventsapi.services.SimpleHttpService;
import com.premise.eventsapi.services.impl.HttpServiceSimpleImpl;

public class MainActivity extends Activity implements OnClickListener {

	SimpleHttpService httpService = new HttpServiceSimpleImpl();
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.my_button).setOnClickListener(this);
    }

	@Override
	public void onClick(View arg0) {
		Button b = (Button)findViewById(R.id.my_button);
		b.setClickable(false);
		new GetEvents().execute();
	}
	
	private class GetEvents extends AsyncTask <Void, Void, String> {
		
		private static final String API_URL = "https://api.github.com/events";

		@Override
		protected String doInBackground(Void... params) {
			//Request the Events
			return httpService.makeServiceCall(API_URL, SimpleHttpService.GET); 
		}	
		// on Post Execute i feel the EditText
		protected void onPostExecute(String results) {
			if (results!=null) {
				EditText et = (EditText)findViewById(R.id.my_edit);
				et.setText(results);
			}
			Button b = (Button)findViewById(R.id.my_button);
			b.setClickable(true);
		}
    }

}
