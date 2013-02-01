package com.indexisto.front.adminpanel.client.pages.login;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.indexisto.front.adminpanel.client.common.ActivityExtended;
import com.indexisto.front.adminpanel.client.common.InstrumentsFactoryImpl;
import com.indexisto.front.adminpanel.client.common.ViewsFactoryImpl;
import com.indexisto.front.adminpanel.client.events.NotificationEvent;
import com.indexisto.front.adminpanel.client.rpcs.UserRPCService;
import com.indexisto.front.adminpanel.client.rpcs.UserRPCServiceAsync;
import com.indexisto.front.adminpanel.shared.FieldVerifier;
import com.indexisto.front.adminpanel.shared.RPCSErrorCodes;
import com.indexisto.front.adminpanel.shared.RPCServiceExeption;
import com.indexisto.front.adminpanel.shared.pojos.UserObj;
import com.indexisto.front.adminpanel.shared.pojos.UserObjRegisterForm;

public class LoginActivity extends ActivityExtended  implements LoginView.Presenter{

	
	private LoginView loginView;
	private LoginPlace place;

	
	 public LoginActivity(LoginPlace place) {	
		 this.place = place;
	    }

	
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		Log.debug("LoginActivity started");
		loginView = ViewsFactoryImpl.getLoginView();
		loginView.setPresenter(this);
		panel.setWidget(loginView.asWidget());
	}



	


	public void sendForm(UserObjRegisterForm userObjRegisterForm) { 
		boolean isValidForm = validateForm(userObjRegisterForm);
		if (isValidForm) {
			this.loginView.showWaitingWindow();
			makeRegisterRPC(userObjRegisterForm);
		}
		else {
			Log.debug("Ivalid data in the form");
		}
	}

	
	
	public boolean validateForm(UserObjRegisterForm userObjRegisterForm) {
		boolean isFormValid =true;
		Validator validator = InstrumentsFactoryImpl.getValidator();

		Set<ConstraintViolation<UserObjRegisterForm>> constraintViolationsEmail = validator.validateProperty(userObjRegisterForm, "email");
		if (constraintViolationsEmail.size()>0) {
			Iterator<ConstraintViolation<UserObjRegisterForm>> iterator = constraintViolationsEmail.iterator();
			this.loginView.setEmailInvalid(iterator.next().getMessage());
			isFormValid = false;
		} else {
			this.loginView.setEmailValid("Email OK");
		}


		Set<ConstraintViolation<UserObjRegisterForm>> constraintViolationsPass1 = validator.validateProperty(userObjRegisterForm, "pass1");
		if (constraintViolationsPass1.size()>0) {
			Iterator<ConstraintViolation<UserObjRegisterForm>> iterator = constraintViolationsPass1.iterator();
			this.loginView.setPass1Invalid(iterator.next().getMessage());
			isFormValid = false;
		} else {
			this.loginView.setPass1Valid("Password OK");
		}

		

		return isFormValid;

	}
	
	





	void makeRegisterRPC(UserObjRegisterForm userObjRegisterForm) {

		UserRPCServiceAsync communicatorSvc = GWT.create(UserRPCService.class);

		AsyncCallback <UserObj> callback = new AsyncCallback<UserObj>() {

			public void onFailure(Throwable caught) {
				loginView.hideWaitingWindow();
				if (caught instanceof RPCServiceExeption) {
					
					RPCServiceExeption caughtRPCExeption = (RPCServiceExeption) caught;
					String exeptionText = "Error code: " + caughtRPCExeption.getErrorReadableText() + " - " + caughtRPCExeption.getErrorCode();
					InstrumentsFactoryImpl.getEventBus().fireEvent(new NotificationEvent(exeptionText) );
					Log.debug("exeption!" + exeptionText);
				}

			}

			public void onSuccess(UserObj user) {
				loginView.hideWaitingWindow();
				Log.debug("createUserFromRegistration onSuccess");
				InstrumentsFactoryImpl.getUsercontroller().setCurrentUser(user);
				
				
				
			}


		};


		Log.debug("Make the createUserFromRegistration call");
		communicatorSvc.doLogin(userObjRegisterForm, callback); 
	}

}
