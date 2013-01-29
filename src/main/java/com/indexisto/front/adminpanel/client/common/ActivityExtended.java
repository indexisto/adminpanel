package com.indexisto.front.adminpanel.client.common;

import java.util.HashMap;


import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;
import com.indexisto.front.adminpanel.client.common.helpers.HavePlace;
import com.indexisto.front.adminpanel.client.common.helpers.HaveView;

public abstract class ActivityExtended extends AbstractActivity implements HavePlace, HaveView {

	private Composite activityView;
	private Place activityPlace;
	
	
	protected String getParams(String paramsLine, String vartoget) {
		String value = null;
		String delimiter = "&";
		/* given string will be split by the argument delimiter provided. */
		String[] paramsArray;
		
		paramsArray = paramsLine.split(delimiter);
		for (int i=0;i<paramsArray.length; i++) {
			//Log.debug("paramsArray = " + i + " " + paramsArray[i] );
			
			String delimiter2 = "=";
			String[] paramsArray2;
			paramsArray2 = paramsArray[i].split(delimiter2);
			if (paramsArray2[0].trim().equals(vartoget)) {
				//Log.debug("We got it = " + paramsArray2[0] + " " + paramsArray2[1] );
				 value = paramsArray2[1];
				 return value;
			}
		}
		return null;
	}


	public Composite getView() {
		return activityView;
	}

	public void setView(Composite view) {
		this.activityView = view;
	}

	public Place getPlace() {
		return activityPlace;
	}

	public void setPlace(Place place) {
		this.activityPlace = place;
		
	}
	
	/*
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// TODO Auto-generated method stub
		//System.out.println("MyActivity extends AbstractActivity start");
	}

	

	
	@Override
	public Composite getView() {
		// TODO Auto-generated method stub
		return activityView;
	}

	@Override
	public Place getPlace() {
		// TODO Auto-generated method stub
		return activityPlace;
	}


	@Override
	public void setView(Composite view) {
		this.activityView = view;
		
	}


	@Override
	public void setPlace(Place place) {
		// TODO Auto-generated method stub
		this.activityPlace = place;
		
	}
	*/
	

}
