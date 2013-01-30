package com.indexisto.front.adminpanel.client.pages.register;


import com.google.gwt.activity.shared.Activity;
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
import com.indexisto.front.adminpanel.client.windows.CommonModalWindow;

import com.indexisto.front.adminpanel.shared.FieldVerifier;

public class RegisterViewImpl extends CompositePage implements RegisterView  {

	private CommonModalWindow registerWaitingWindow;
	private Presenter presenter;
	private Button sendButt = new Button("Register!");

	
	private Label nameLabel = new Label("Your name:");
	private TextBox nameBox = new TextBox();
	
	private Label eMailLabel = new Label("Your email (will be used to login:");
	private TextBox eMailBox = new TextBox();

	private Label pass1Label = new Label("Password:");
	private PasswordTextBox pass1Box = new PasswordTextBox();

	private Label pass2Label = new Label("Password again:");
	private PasswordTextBox pass2Box = new PasswordTextBox();

	private Label status = new Label("");

	private boolean isValidEmail;
	private boolean isValidPass1;
	private boolean isValidPass2;
	private boolean isValidPassMutch;

	public RegisterViewImpl() {
		super();
		this.pageTitle.setText("Please register");

		//ClientFactory.getEventBus().

		this.addStyleName("registerPopup");
		this.addStyleName("popusCommon");
		//this.addStyleName("olo");
		//Log.debug("RegisterView created ");
		//this.add(panel);

		nameLabel.addStyleName("label_common");
		eMailLabel.addStyleName("label_common");
		pass1Label.addStyleName("label_common");
		pass2Label.addStyleName("label_common");

		nameBox.addStyleName("input_common");
		eMailBox.addStyleName("input_common");
		pass1Box.addStyleName("input_common");
		pass2Box.addStyleName("input_common");


		nameBox.addStyleName("greyColor");
		eMailBox.addStyleName("greyColor");
		pass1Box.addStyleName("greyColor");
		pass2Box.addStyleName("greyColor");

		nameBox.addStyleName("regFormInput");
		eMailBox.addStyleName("regFormInput");
		pass1Box.addStyleName("regFormInput");
		pass2Box.addStyleName("regFormInput");
		//pass1Label.addStyleName("text12_black_bold");
		//pass2Label.addStyleName("text12_black_bold");
		//status.addStyleName("text12_black_bold");


		nameLabel.addStyleName("regFormLabel");
		eMailLabel.addStyleName("regFormLabel");
		pass1Label.addStyleName("regFormLabel");
		pass2Label.addStyleName("regFormLabel");
		status.addStyleName("regFormLabel");

		sendButt.addStyleName("regFormButt");


		this.pageContetntContainer.add(nameLabel);
		this.pageContetntContainer.add(nameBox);
		this.pageContetntContainer.add(eMailLabel);
		this.pageContetntContainer.add(eMailBox);
		this.pageContetntContainer.add(pass1Label);
		this.pageContetntContainer.add(pass1Box);
		this.pageContetntContainer.add(pass2Label);
		this.pageContetntContainer.add(pass2Box);
		this.pageContetntContainer.add(sendButt);
		this.pageContetntContainer.add(status);

		
		nameBox.addBlurHandler(new BlurHandler() {
			public void onBlur(BlurEvent event) {
				presenter.nameBoxValidator(nameBox.getText());
				// TODO Auto-generated method stub
			}
		}); 

		eMailBox.addBlurHandler(new BlurHandler() {
			public void onBlur(BlurEvent event) {
				presenter.emailBoxValidator(eMailBox.getText());
				// TODO Auto-generated method stub
			}
		});




		pass1Box.addBlurHandler(new BlurHandler() {
			public void onBlur(BlurEvent event) {
				presenter.pass1BoxValidator(pass1Box.getText());
				// TODO Auto-generated method stub
			}
		});

		pass2Box.addKeyUpHandler(new KeyUpHandler() {

			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				presenter.pass2BoxValidator(pass1Box.getText(), pass2Box.getText());
			}			
		});

		pass2Box.addBlurHandler(new BlurHandler() {

			public void onBlur(BlurEvent event) {
				boolean isPass2Valid = presenter.pass2BoxValidator(pass1Box.getText(), pass2Box.getText());
				// TODO Auto-generated method stub
			}
		});



		
		sendButt.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {

				presenter.sendForm(nameBox.getText(), eMailBox.getText(), pass1Box.getText(), pass2Box.getText());

			}
		});
			 
				//this.show();
				//this.initWidget(panel);
			}


			public boolean emailBoxValidator(String emailText) {
				//this.isValidEmail
				//isValidEmail = FieldVerifier.isValidEmailAddress(eMailBox.getText());
				isValidEmail = FieldVerifier.isValidEmailAddress(emailText);
				if (isValidEmail) {
					//Log.debug("Good email");
					eMailLabel.setText("Email OK");
					eMailLabel.setStyleName("label_valid");
					eMailLabel.addStyleName("regFormLabel");
				} else {
					eMailLabel.setText("Enter valid email");
					eMailLabel.setStyleName("label_invalid");
					eMailLabel.addStyleName("regFormLabel");
					//Log.debug("Bad email");
				}
				return isValidEmail;
			}



			public boolean pass1BoxValidator(String pass1) {
				//isValidPass1 = FieldVerifier.isLenghtOK(pass1Box.getText(),1,50);
				isValidPass1 = FieldVerifier.isLenghtOK(pass1,1,50);
				if (isValidPass1) {
					//Log.debug("Good Password1");
					pass1Label.setText("Password OK");
					pass1Label.setStyleName("label_valid");
					pass1Label.addStyleName("regFormLabel");
					//nickNameLabel.setText("Nick ene");
				} else {
					pass1Label.setText("Password must be 1 character at least");
					//Log.debug("Bad Password1");
					pass1Label.setStyleName("label_invalid");
					pass1Label.addStyleName("regFormLabel");
				}

				return isValidPass1;
			}

			public boolean pass2BoxValidator(String pass1, String pass2) {


				//isValidPassMutch = pass2Box.getText().equals(pass1Box.getText());
				isValidPassMutch = pass2.equals(pass1);
				if (isValidPassMutch &&  pass2.length()!=0) {
					pass2Label.setText("Password OK");
					pass2Label.setStyleName("label_valid");
					pass2Label.addStyleName("regFormLabel");
					//Log.debug("Good Password2");
					//nickNameLabel.setText("Nick ene");
				} else {
					pass2Label.setText("Passwords don't match");
					//Log.debug("Bad Password - no match");
					pass2Label.setStyleName("label_invalid");
					pass2Label.addStyleName("regFormLabel");
				}
				isValidPass2= true;
				return isValidPass2;
				/*
		isValidPass2 = FieldVerifier.isLenghtOK(pass2Box.getText(),1,50);
		if (isValidPass2) {
			Log.debug("Good Password2");
			pass2Label.setText("Password OK");
			pass2Label.setStyleName("text12_green_bold");
			//nickNameLabel.setText("Nick ene");
		} else {
			pass2Label.setText("Password must be 1 character at least");
			pass2Label.setStyleName("text12_red_bold");
			Log.debug("Bad Password2");
		}*/
			}


			void sendToServer(String email, String pass1, String pass2) {
				status.setText("working");

				//Log.debug("Make the call");
				//communicatorSvc.doRegister(nick, email, pass1, pass2, callback);

			}


			public void setEmailVerificationStatus(String emailVerifStatus) {
				// TODO Auto-generated method stub

			}


			/*
			public Activity getPresenter() {
				// TODO Auto-generated method stub
				return null;
			}*/


			public void setPresenter(Presenter presenter) {
				// TODO Auto-generated method stub
				this.presenter = presenter;
			}

			
			
			public void setNameInvalid() {
				nameLabel.setText("Name must be 1 character at least");
				nameLabel.setStyleName("label_invalid");
				nameLabel.addStyleName("regFormLabel");
				
			}
			
			
			public void setNameInvalidCharacters() {
				nameLabel.setText("Please provide only latin charcters and digits");
				nameLabel.setStyleName("label_invalid");
				nameLabel.addStyleName("regFormLabel");
				
			}


			public void setNameValid() {
				// TODO Auto-generated method stub
				nameLabel.setText("Name OK");
				nameLabel.setStyleName("label_valid");
				nameLabel.addStyleName("regFormLabel");
			}
			

			public void setEmailInvalid() {
				// TODO Auto-generated method stub
				eMailLabel.setText("Enter valid email");
				eMailLabel.setStyleName("label_invalid");
				eMailLabel.addStyleName("regFormLabel");
			}


			public void setEmailValid() {
				// TODO Auto-generated method stub
				eMailLabel.setText("Email OK");
				eMailLabel.setStyleName("label_valid");
				eMailLabel.addStyleName("regFormLabel");
			}

			
			public void setPass1Invalid() {
				// TODO Auto-generated method stub
				pass1Label.setText("Password must be 1 character at least");
				//Log.debug("Bad Password1");
				pass1Label.setStyleName("label_invalid");
				pass1Label.addStyleName("regFormLabel");
			}


			public void setPass1Valid() {
				// TODO Auto-generated method stub
				pass1Label.setText("Password repeat OK");
				pass1Label.setStyleName("label_valid");
				pass1Label.addStyleName("regFormLabel");
			}


			public void setPass2Invalid() {
				// TODO Auto-generated method stub
				pass2Label.setText("Passwords don't match");
				//Log.debug("Bad Password - no match");
				pass2Label.setStyleName("label_invalid");
				pass2Label.addStyleName("regFormLabel");
			}


			public void setPass2Valid() {
				// TODO Auto-generated method stub
				pass2Label.setText("Password OK");
				pass2Label.setStyleName("label_valid");
				pass2Label.addStyleName("regFormLabel");
			}


			public void showWaitingWindow() {
				// TODO Auto-generated method stub
				registerWaitingWindow = new CommonModalWindow("Registering. Please wait.", true);
				registerWaitingWindow.show();
			}


			public void hideWaitingWindow() {
				// TODO Auto-generated method stub
				registerWaitingWindow.removeFromParent();
				
			}


	


		
		}