package com.indexisto.front.adminpanel.client.pages.demolog;

import com.google.gwt.user.client.ui.IsWidget;

public interface DemologView extends IsWidget {
	
	public void setEmailVerificationStatus(String emailVerifStatus);
	public void setPresenter(Presenter presenter);
	
	 public interface Presenter {
	        void emailChanged(String email);
	       
	 }

	
}
