package com.indexisto.front.adminpanel.client.pages.register;

import com.google.gwt.user.client.ui.IsWidget;

public interface RegisterView extends IsWidget {
	
	public void setEmailInvalid();
	public void setEmailValid();
	public void setPass1Invalid();
	public void setPass1Valid();
	public void setPass2Invalid();
	public void setPass2Valid();
	public void showWaitingWindow();
	public void setNameInvalid();
	public void setNameValid(); 
	public void setNameInvalidCharacters();
	public void hideWaitingWindow();  
	
	public void setPresenter(Presenter presenter);
	
	 public interface Presenter {
	        void emailChanged(String email);


	        void sendForm(String name, String email,String pass1,String pass2);

	        
	        
	        boolean emailBoxValidator(String email);
	        boolean pass1BoxValidator(String pass1);
			boolean pass2BoxValidator(String pass1, String pass2);


			boolean nameBoxValidator(String name);    
	       
	 }

	

	
 


	
}
