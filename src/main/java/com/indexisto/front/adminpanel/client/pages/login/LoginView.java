package com.indexisto.front.adminpanel.client.pages.login;

import com.google.gwt.user.client.ui.IsWidget;
import com.indexisto.front.adminpanel.client.pages.register.RegisterView.Presenter;
import com.indexisto.front.adminpanel.shared.pojos.UserObjRegisterForm;

public interface LoginView extends IsWidget {
	
	public void setPresenter(Presenter presenter);
	

	public void setEmailInvalid(String text);
	public void setEmailValid(String text);
	public void setPass1Invalid(String text);
	public void setPass1Valid(String text);

	public void showWaitingWindow();
	public void hideWaitingWindow();  
	
	
	 public interface Presenter {
	      
	        void sendForm(UserObjRegisterForm userObjRegisterForm);
			boolean validateForm(UserObjRegisterForm userObjRegisterForm);      
	       
	 }

	
}
