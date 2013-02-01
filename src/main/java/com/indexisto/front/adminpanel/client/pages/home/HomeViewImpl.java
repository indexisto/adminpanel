package com.indexisto.front.adminpanel.client.pages.home;


import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.indexisto.front.adminpanel.client.butts.IconButt;
import com.indexisto.front.adminpanel.client.common.CompositePage;
import com.indexisto.front.adminpanel.client.pages.register.RegisterView.Presenter;
import com.indexisto.front.adminpanel.shared.FieldVerifier;

public class HomeViewImpl extends CompositePage implements HomeView  {





	private Label eMailLabel = new Label("This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen This is your home screen ");
	

	public HomeViewImpl() {
		super();
		this.pageTitle.setText("Home dashboard");

		


		this.pageContetntContainer.add(eMailLabel);

	}


	public void setEmailVerificationStatus(String emailVerifStatus) {
		// TODO Auto-generated method stub
		
	}


	public void setPresenter(Presenter presenter) {
		// TODO Auto-generated method stub
		
	}

	
	
}