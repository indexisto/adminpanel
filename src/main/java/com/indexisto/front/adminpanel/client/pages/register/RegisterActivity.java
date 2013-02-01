package com.indexisto.front.adminpanel.client.pages.register;



import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.indexisto.front.adminpanel.client.blocks.MenuBlock;
import com.indexisto.front.adminpanel.client.common.ActivityExtended;
import com.indexisto.front.adminpanel.client.common.InstrumentsFactoryImpl;
import com.indexisto.front.adminpanel.client.common.ViewsFactoryImpl;
import com.indexisto.front.adminpanel.client.events.LeftMenuSelectedEvent;
import com.indexisto.front.adminpanel.client.events.NotificationEvent;
import com.indexisto.front.adminpanel.client.events.ShowMenuEvent;
import com.indexisto.front.adminpanel.client.events.UserLoggedEvent;
import com.indexisto.front.adminpanel.client.pages.home.HomePlace;
import com.indexisto.front.adminpanel.client.rpcs.UserRPCService;
import com.indexisto.front.adminpanel.client.rpcs.UserRPCServiceAsync;
import com.indexisto.front.adminpanel.client.wigets.LeftMenuTypes;
import com.indexisto.front.adminpanel.client.windows.Notification;
import com.indexisto.front.adminpanel.shared.FieldVerifier;
import com.indexisto.front.adminpanel.shared.RPCSErrorCodes;
import com.indexisto.front.adminpanel.shared.RPCServiceExeption;
import com.indexisto.front.adminpanel.shared.pojos.UserObj;
import com.indexisto.front.adminpanel.shared.pojos.UserObjRegisterForm;

public class RegisterActivity extends ActivityExtended  implements RegisterView.Presenter{

	private RegisterView registerView;
	private RegisterPlace place;

	public RegisterActivity(RegisterPlace place) {

		this.place = place;

	}


	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		Log.debug("RegisterActivity started");
		registerView = ViewsFactoryImpl.getRegisterView();
		registerView.setPresenter(this);
		panel.setWidget(registerView.asWidget());
	}


	public void sendForm(UserObjRegisterForm userObjRegisterForm) { 
		boolean isValidForm = validateForm(userObjRegisterForm);
		if (isValidForm) {
			this.registerView.showWaitingWindow();
			makeRegisterRPC(userObjRegisterForm);
		}
		else {
			Log.debug("Ivalid data in the form");
		}
	}


	void makeRegisterRPC(UserObjRegisterForm userObjRegisterForm) {

		UserRPCServiceAsync communicatorSvc = GWT.create(UserRPCService.class);

		AsyncCallback <UserObj> callback = new AsyncCallback<UserObj>() {

			public void onFailure(Throwable caught) {
				registerView.hideWaitingWindow();
				if (caught instanceof RPCServiceExeption) {

					RPCServiceExeption caughtRPCExeption = (RPCServiceExeption) caught;
					String exeptionText = "Error code: " + caughtRPCExeption.getErrorReadableText() + " - " + caughtRPCExeption.getErrorCode();
					InstrumentsFactoryImpl.getEventBus().fireEvent(new NotificationEvent(exeptionText) );
					Log.debug("exeption!" + exeptionText);
					if (caughtRPCExeption.getErrorCode() == RPCSErrorCodes.USER_REGISTER_EMAIL_EXIST) {
						Log.debug("USER_REGISTER_EMAIL_EXIST");
					}
					else {
						Log.debug("Unknown error");
					}
				}
			}

			public void onSuccess(UserObj user) {
				registerView.hideWaitingWindow();
				Log.debug("createUserFromRegistration onSuccess");
				InstrumentsFactoryImpl.getUsercontroller().setCurrentUser(user);
			}


		};
		Log.debug("Make the createUserFromRegistration call");
		communicatorSvc.doRegister(userObjRegisterForm, callback);

	}


	public boolean validateForm(UserObjRegisterForm userObjRegisterForm) {
		boolean isFormValid =true;
		Validator validator = InstrumentsFactoryImpl.getValidator();

		Set<ConstraintViolation<UserObjRegisterForm>> constraintViolationsName = validator.validateProperty(userObjRegisterForm, "name");
		if (constraintViolationsName.size()>0) {
			Iterator<ConstraintViolation<UserObjRegisterForm>> iterator = constraintViolationsName.iterator();
			this.registerView.setNameInvalid(iterator.next().getMessage());
			isFormValid = false;
		} else {
			this.registerView.setNameValid("Name OK");
		}
		//System.out.println(constraintViolationsName);

		Set<ConstraintViolation<UserObjRegisterForm>> constraintViolationsEmail = validator.validateProperty(userObjRegisterForm, "email");
		if (constraintViolationsEmail.size()>0) {
			Iterator<ConstraintViolation<UserObjRegisterForm>> iterator = constraintViolationsEmail.iterator();
			this.registerView.setEmailInvalid(iterator.next().getMessage());
			isFormValid = false;
		} else {
			this.registerView.setEmailValid("Email OK");
		}


		Set<ConstraintViolation<UserObjRegisterForm>> constraintViolationsPass1 = validator.validateProperty(userObjRegisterForm, "pass1");
		if (constraintViolationsPass1.size()>0) {
			Iterator<ConstraintViolation<UserObjRegisterForm>> iterator = constraintViolationsPass1.iterator();
			this.registerView.setPass1Invalid(iterator.next().getMessage());
			isFormValid = false;
		} else {
			this.registerView.setPass1Valid("Password OK");
		}

		if (constraintViolationsPass1.size()>0 ) {
			this.registerView.setPass2Invalid("Please enter valid password before repeat it");
			isFormValid = false;
		} 
		else {
			if (userObjRegisterForm.getPass2().equals(userObjRegisterForm.getPass1())) {
				this.registerView.setPass2Valid("Password repeat OK");
			}
			else {
				if (userObjRegisterForm.getPass2().length() > 0) {
					this.registerView.setPass2Invalid("Passwords mismatch");
					isFormValid = false;
				}
			}

		}

		return isFormValid;

	}


}
