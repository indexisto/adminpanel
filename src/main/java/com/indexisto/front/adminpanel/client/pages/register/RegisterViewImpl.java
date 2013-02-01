package com.indexisto.front.adminpanel.client.pages.register;


import com.google.gwt.activity.shared.Activity;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
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
import com.indexisto.front.adminpanel.shared.pojos.UserObjRegisterForm;

public class RegisterViewImpl extends CompositePage implements RegisterView  {

	private UserObjRegisterForm userObjRegisterForm = new UserObjRegisterForm();

	private CommonModalWindow registerWaitingWindow;
	private Presenter presenter;
	private Button sendButt = new Button("Register!");


	private Label nameLabel = new Label("Your name:");
	private TextBox nameBox = new TextBox();

	private Label eMailLabel = new Label("Your email (will be used as login):");
	private TextBox eMailBox = new TextBox();

	private Label pass1Label = new Label("Password:");
	private PasswordTextBox pass1Box = new PasswordTextBox();

	private Label pass2Label = new Label("Password again:");
	private PasswordTextBox pass2Box = new PasswordTextBox();

	private Label status = new Label("");

	private boolean isNameBoxVirgin = true;
	private boolean isEmailBoxVirgin= true;
	private boolean isPass1BoxVirgin= true;
	private boolean isPass2BoxVirgin= true;


	public RegisterViewImpl() {
		super();
		this.pageTitle.setText("Please register");

		this.addStyleName("registerPopup");
		this.addStyleName("popusCommon");


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

				if (event.getSource().equals(nameBox)) {
					isNameBoxVirgin = false;
					validate();
				}
			}
		});

		nameBox.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent event) {
				validate();
			}			
		});


		eMailBox.addBlurHandler(new BlurHandler() {
			public void onBlur(BlurEvent event) {
				if (event.getSource().equals(eMailBox)) {
					isEmailBoxVirgin = false;
					validate();
				}
			}
		});

		eMailBox.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent event) {
				validate();
			}			
		});


		pass1Box.addBlurHandler(new BlurHandler() {
			public void onBlur(BlurEvent event) {
				if (event.getSource().equals(pass1Box)) {
					isPass1BoxVirgin = false;
					validate();
				}
			}
		});
		
		pass1Box.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent event) {
				validate();
			}			
		});

		pass2Box.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent event) {
				isPass2BoxVirgin = false;
				validate();
			}			
		});



		pass2Box.addBlurHandler(new BlurHandler() {
			public void onBlur(BlurEvent event) {
				if (event.getSource().equals(pass2Box)) {
					isPass2BoxVirgin = false;
					validate();
				}
			}
		});




		sendButt.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				updateUserObj();
				isNameBoxVirgin = false;
				isEmailBoxVirgin= false;
				isPass1BoxVirgin= false;
				isPass2BoxVirgin= false;
				presenter.sendForm(userObjRegisterForm);
			}
		});
	}


	void validate() {
		updateUserObj();
		presenter.validateForm(userObjRegisterForm);
	}

	void updateUserObj() {
		userObjRegisterForm.setEmail(eMailBox.getText());
		userObjRegisterForm.setName(nameBox.getText());
		userObjRegisterForm.setPass1(pass1Box.getText());
		userObjRegisterForm.setPass2(pass2Box.getText());
	}



	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}


	public void setNameInvalid(String text) {

		if (!isNameBoxVirgin) {
			nameLabel.setText(text);
			nameLabel.setStyleName("label_invalid");
			nameLabel.addStyleName("regFormLabel");
		}
	}



	public void setNameValid(String text) {
		nameLabel.setText(text);
		nameLabel.setStyleName("label_valid");
		nameLabel.addStyleName("regFormLabel");
	}


	public void setEmailInvalid(String text) {
		if (!isEmailBoxVirgin) {
			eMailLabel.setText(text);
			eMailLabel.setStyleName("label_invalid");
			eMailLabel.addStyleName("regFormLabel");
		}
	}


	public void setEmailValid(String text) {
		eMailLabel.setText(text);
		eMailLabel.setStyleName("label_valid");
		eMailLabel.addStyleName("regFormLabel");
	}


	public void setPass1Invalid(String text) {
		if (!isPass1BoxVirgin) {
			pass1Label.setText(text);
			pass1Label.setStyleName("label_invalid");
			pass1Label.addStyleName("regFormLabel");
		}
	}


	public void setPass1Valid(String text) {
		pass1Label.setText(text);
		pass1Label.setStyleName("label_valid");
		pass1Label.addStyleName("regFormLabel");
	}


	public void setPass2Invalid(String text) {
		if (!isPass2BoxVirgin) {
			pass2Label.setText(text);
			pass2Label.setStyleName("label_invalid");
			pass2Label.addStyleName("regFormLabel");
		}
	}


	public void setPass2Valid(String text) {
		pass2Label.setText(text);
		pass2Label.setStyleName("label_valid");
		pass2Label.addStyleName("regFormLabel");
	}


	public void showWaitingWindow() {
		registerWaitingWindow = new CommonModalWindow("Registering. Please wait.", true);
		registerWaitingWindow.show();
	}


	public void hideWaitingWindow() {
		registerWaitingWindow.removeFromParent();
	}






}