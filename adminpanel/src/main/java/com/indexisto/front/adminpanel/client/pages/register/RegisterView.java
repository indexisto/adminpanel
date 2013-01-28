package com.indexisto.front.adminpanel.client.pages.register;

import com.google.gwt.user.client.ui.IsWidget;

public interface RegisterView extends IsWidget {
	
	public void setEmailVerificationStatus(String emailVerifStatus);
	public void setPresenter(Presenter presenter);
	
	 public interface Presenter {
	        void emailChanged(String email);
	       
	 }

	
}
