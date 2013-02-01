package com.indexisto.front.adminpanel.client.pages.home;

import com.google.gwt.user.client.ui.IsWidget;

public interface HomeView extends IsWidget {
	
	public void setPresenter(Presenter presenter);

	
	
	 public interface Presenter {
	        void emailChanged(String email);
	       
	 }

	
}
