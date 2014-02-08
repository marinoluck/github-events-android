package com.premise.eventsapi;

import java.util.List;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListAdapter;

import com.premise.eventsapi.models.EventModel;
import com.premise.eventsapi.services.GitHubEventsService;
import com.premise.eventsapi.services.impl.GitHubEventsServiceImpl;
import com.premise.eventsapi.view.EventsAdapter;

public class MainActivity extends ListActivity implements OnClickListener {
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
		List<EventModel> events;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Showing progress dialog
			pDialog = new ProgressDialog(MainActivity.this);
			pDialog.setMessage(getString(R.string.please_wait));
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected String doInBackground(Void... params) {
			// Request the Events
			events = gitHubEventsService.getEvents();
			return events.toString();
		}

		// on Post Execute i populate the list
		protected void onPostExecute(String results) {
			// populate the list
			ListAdapter adapter = new EventsAdapter(MainActivity.this,
					events.toArray(new EventModel[0]));

			setListAdapter(adapter);

			// hide Loading
			if (pDialog.isShowing())
				pDialog.dismiss();
		}
	}

}
