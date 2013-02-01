package com.indexisto.front.adminpanel.client.pages.login;


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
import com.indexisto.front.adminpanel.shared.pojos.UserObjRegisterForm;

public class LoginViewImpl extends CompositePage implements LoginView  {

	private UserObjRegisterForm userObjRegisterForm = new UserObjRegisterForm();
	
	private CommonModalWindow registerWaitingWindow;
	private Presenter presenter;
	private Button sendButt = new Button("Register!");

	
	
	private Label eMailLabel = new Label("Your email:");
	private TextBox eMailBox = new TextBox();

	private Label pass1Label = new Label("Password:");
	private PasswordTextBox pass1Box = new PasswordTextBox();


	private boolean isEmailBoxVirgin= true;
	private boolean isPass1BoxVirgin= true;



	//private Label eMailLabel = new Label("Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon Login Soon  ");
	

	public LoginViewImpl() {
		super();
		this.pageTitle.setText("Please login");

		eMailLabel.addStyleName("label_common");
		pass1Label.addStyleName("label_common");


		eMailBox.addStyleName("input_common");
		pass1Box.addStyleName("input_common");

		eMailBox.addStyleName("greyColor");
		pass1Box.addStyleName("greyColor");

		eMailBox.addStyleName("regFormInput");
		pass1Box.addStyleName("regFormInput");

		eMailLabel.addStyleName("regFormLabel");
		pass1Label.addStyleName("regFormLabel");
		sendButt.addStyleName("regFormButt");


		this.pageContetntContainer.add(eMailLabel);
		this.pageContetntContainer.add(eMailBox);
		this.pageContetntContainer.add(pass1Label);
		this.pageContetntContainer.add(pass1Box);
		this.pageContetntContainer.add(sendButt);


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




		
		sendButt.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				updateUserObj();
				isEmailBoxVirgin= false;
				isPass1BoxVirgin= false;
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
		userObjRegisterForm.setPass1(pass1Box.getText());
	}
	


	public void setPresenter(Presenter presenter) {
		// TODO Auto-generated method stub
		this.presenter = presenter;
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