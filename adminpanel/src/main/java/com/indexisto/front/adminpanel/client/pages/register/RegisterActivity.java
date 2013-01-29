package com.indexisto.front.adminpanel.client.pages.register;



import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.indexisto.front.adminpanel.client.blocks.MenuBlock;
import com.indexisto.front.adminpanel.client.common.ActivityExtended;
import com.indexisto.front.adminpanel.client.common.InstrumentsFactoryImpl;
import com.indexisto.front.adminpanel.client.common.ViewsFactoryImpl;
import com.indexisto.front.adminpanel.client.events.LeftMenuSelectedEvent;
import com.indexisto.front.adminpanel.client.events.NotificationEvent;
import com.indexisto.front.adminpanel.client.rpcs.UserRPCService;
import com.indexisto.front.adminpanel.client.rpcs.UserRPCServiceAsync;
import com.indexisto.front.adminpanel.client.windows.Notification;
import com.indexisto.front.adminpanel.shared.FieldVerifier;
import com.indexisto.front.adminpanel.shared.RPCSErrorCodes;
import com.indexisto.front.adminpanel.shared.RPCServiceExeption;
import com.indexisto.front.adminpanel.shared.pojos.UserObj;

public class RegisterActivity extends ActivityExtended  implements RegisterView.Presenter{

	/*
	private boolean isValidEmail;
	private boolean isValidPass1;
	private boolean isValidPass2;
	private boolean isValidPassMutch;
	*/
	private RegisterView registerView;
	private RegisterPlace place;
	
	 public RegisterActivity(RegisterPlace place) {
	        //this.clientFactory = clientFactory;
		
		 this.place = place;
	    }

	
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		
		
		registerView = ViewsFactoryImpl.getRegisterView();
		//registerView.setName(place.g);
		registerView.setPresenter(this);
		panel.setWidget(registerView.asWidget());



	}

	public void emailChanged(String email) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean nameBoxValidator(String name) {
		boolean isValidName = FieldVerifier.isLenghtOK(name,1,100);
		if (isValidName) {
			
			this.registerView.setNameValid();
		} else { 
			this.registerView.setNameInvalid();

		}
		return isValidName;
	}


	public boolean emailBoxValidator(String emailText) {
		boolean isValidEmail = FieldVerifier.isValidEmailAddress(emailText);
		if (isValidEmail) {
			
			this.registerView.setEmailValid();
		} else {
			this.registerView.setEmailInvalid();

		}
		return isValidEmail;
	}



	public boolean pass1BoxValidator(String pass1) {
		boolean isValidPass1 = FieldVerifier.isLenghtOK(pass1,1,50);
		if (isValidPass1) {
			this.registerView.setPass1Valid();

		} else {
			this.registerView.setPass1Invalid();
		}

		return isValidPass1;
	}

	public boolean pass2BoxValidator(String pass1, String pass2) {
		boolean isValidPassMutch = pass2.equals(pass1);
		boolean isValidPass2;
		if (isValidPassMutch &&  pass2.length()!=0) {
			this.registerView.setPass2Valid();
			isValidPass2= true;
		} else {
			this.registerView.setPass2Invalid();
			isValidPass2= false;
		}
		
		return isValidPass2;

	}


	public void sendForm(String name, String email, String pass1, String pass2) {
		// TODO Auto-generated method stub
		InstrumentsFactoryImpl.getEventBus().fireEvent(new NotificationEvent("Privetiki Privetiki Privetiki ") );

		if ( nameBoxValidator(name) && emailBoxValidator(email) && pass1BoxValidator( pass1) && pass2BoxValidator( pass1, pass2)) {
			//Log.debug("Form valid");
			//sendToServer(eMailBox.getText(),pass1Box.getText(), pass2Box.getText());
			System.out.println("Otsilaem");
			//this.registerView.showWaitingWindow();
			
			makeRegisterRPC(name,email,pass1);
		}
		else {
			System.out.println("Nee Otsilaem");
		}
	}


	
	
	
	void makeRegisterRPC(String nick, String email, String pass1) {

		UserRPCServiceAsync communicatorSvc = GWT.create(UserRPCService.class);

		// Set up the callback object.
		AsyncCallback <UserObj> callback = new AsyncCallback<UserObj>() {

			public void onFailure(Throwable caught) {

				if (caught instanceof RPCServiceExeption) {
					Log.debug("exeption!!");
					RPCServiceExeption caughtRPCExeption = (RPCServiceExeption) caught;
					if (caughtRPCExeption.getErrorCode() == RPCSErrorCodes.USER_REGISTER_EMAIL_EXIST) {
						Log.debug("USER_REGISTER_EMAIL_EXIST");
					}
					else {
						Log.debug("Unknown error");
					}
					
					//Notifications notif = new Notifications(((RPCServiceExeption)caught).getErrorCode(), true, true);
				}

			}

			public void onSuccess(UserObj result) {
				
				Log.debug("onSuccess");
				//status.setText("well done");
				//UserHasLoggedEvent event = new UserHasLoggedEvent((User)result);
				//ClientFactory.getEventBus().fireEvent(event);
				//Log.debug("UserHasLoggedEvent fired");
				//Notifications notif = new Notifications("You have registered", true, true);
				//ClientFactory.getEventBus().
				//RegisterPopup.this.hide();
			}

		
		};

		//	Make the call
		Log.debug("Make the call");
		communicatorSvc.doRegister(nick, email, pass1, callback);

	}


}
