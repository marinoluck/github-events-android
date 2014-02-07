package com.premise.eventsapi;

import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.premise.eventsapi.models.EventModel;
import com.premise.eventsapi.services.GitHubEventsService;
import com.premise.eventsapi.services.impl.GitHubEventsServiceImpl;

public class MainActivity extends Activity implements OnClickListener {
	private ProgressDialog pDialog;
	GitHubEventsService gitHubEventsService = new GitHubEventsServiceImpl();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.my_button).setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		Button b = (Button) findViewById(R.id.my_button);
		b.setClickable(false);
		new GetEvents().execute();
	}

	private class GetEvents extends AsyncTask<Void, Void, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Showing progress dialog
			pDialog = new ProgressDialog(MainActivity.this);
			pDialog.setMessage("Please wait...");
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected String doInBackground(Void... params) {
			// Request the Events
			List<EventModel> result = gitHubEventsService.getEvents();
			StringBuilder sb = new StringBuilder();
			sb.append("Events Result");
			sb.append("\n");
			for (EventModel e : result) {
				sb.append(e.toString());
				sb.append("\n");
			}
			return sb.toString();
		}

		// on Post Execute i feel the EditText
		protected void onPostExecute(String results) {
			if (results != null) {
				EditText et = (EditText) findViewById(R.id.my_edit);
				et.setText(results);
			}
			Button b = (Button) findViewById(R.id.my_button);
			b.setClickable(true);

			if (pDialog.isShowing())
				pDialog.dismiss();
		}
	}

}
