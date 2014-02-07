package com.premise.eventsapi.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.premise.eventsapi.R;
import com.premise.eventsapi.models.EventModel;

/**
 * EventsAdaper 
 * Maps the Event from model to an list_item of the view (row by row)
 * @author luck
 *
 */
public class EventsAdapter extends ArrayAdapter<EventModel> {
	  private final Context context;
	  private final EventModel[] values;

	  public EventsAdapter(Context context, EventModel[] values) {
	    super(context, R.layout.list_item, values);
	    this.context = context;
	    this.values = values;
	  }

	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.list_item, parent, false);
	    
	    TextView actorTextView = (TextView) rowView.findViewById(R.id.actor_name);
	    TextView idTextView = (TextView) rowView.findViewById(R.id.id_event);
	    TextView repoTextView = (TextView) rowView.findViewById(R.id.repo_url_event);
	    TextView typeTextView = (TextView) rowView.findViewById(R.id.type_event);
	    
	    actorTextView.setText(values[position].getActorLogin());
	    idTextView.setText(values[position].getId());
	    repoTextView.setText(values[position].getRepoUrl());
	    typeTextView.setText(values[position].getType());
	    
	    return rowView;
	  }
	} 

