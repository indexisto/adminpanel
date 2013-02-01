package com.indexisto.front.adminpanel.client.pages.register;

import com.google.gwt.user.client.ui.IsWidget;
import com.indexisto.front.adminpanel.shared.pojos.UserObjRegisterForm;

public interface RegisterView extends IsWidget {
	
	public void setEmailInvalid(String text);
	public void setEmailValid(String text);
	public void setPass1Invalid(String text);
	public void setPass1Valid(String text);
	public void setPass2Invalid(String text);
	public void setPass2Valid(String text);
	public void setNameInvalid(String text);
	public void setNameValid(String text); 

	public void showWaitingWindow();
	public void hideWaitingWindow();  
	
	public void setPresenter(Presenter presenter);
	
	 public interface Presenter {
	      
	        void sendForm(UserObjRegisterForm userObjRegisterForm);
			boolean validateForm(UserObjRegisterForm userObjRegisterForm);      
	       
	 }

	
}
