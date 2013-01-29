package com.indexisto.front.adminpanel.client.pages.login;

import com.google.gwt.user.client.ui.IsWidget;

public interface LoginView extends IsWidget {
	
	public void setPresenter(Presenter presenter);

	
	
	 public interface Presenter {
	        void emailChanged(String email);
	       
	 }

	
}
