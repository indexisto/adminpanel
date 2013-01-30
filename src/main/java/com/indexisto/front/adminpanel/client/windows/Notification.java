package com.indexisto.front.adminpanel.client.windows;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.indexisto.front.adminpanel.client.butts.CloseSmallButt;
import com.indexisto.front.adminpanel.client.butts.IconButt;


public class Notification extends Composite {
	private FlowPanel panel = new FlowPanel();
	//private IconButt butt = new IconButt("butt");
	private CloseSmallButt closeButt = new CloseSmallButt();
	public Notification(String text) {
		// this();
		// super(false, false);
		panel.addStyleName("notification");
		panel.addStyleName("greyColorNotifBack");
		panel.addStyleName("greyColor");
		closeButt.addStyleName("closeSmallButtPosition"); 
		closeButt.addStyleName("notifCloseButtBack"); 
		

		closeButt.getFocusPanel().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Notification.this.removeFromParent();
				//panel.addStyleName("notificationShowed");
			}

		});

		//panel.addHandler(handler, type)

		//panel.getElement().getStyle().setProperty("opacity", "0");
		//panel.getElement().getStyle().setProperty("height", "0");
		//panel.addStyleName("text_14_black_bold");
		
		panel.add(closeButt);
		panel.add(new Label(text));
		//panel.add(butt);

		// int left=Window.getClientWidth()-260;
		//setPopupPosition(left, 50); 
		show(5000);
		initWidget(panel);

		//panel.onBrowserEvent(event)
		//panel.getElement().getStyle().setProperty("opacity", "1");
		//panel.getElement().getStyle().setProperty("height", "auto");



	}


	public Notification() {

	}

	void show(int delayMilliseconds) {

		/////transtimer


		Timer t1 = new Timer() {
			@Override
			public void run() {
				panel.addStyleName("notificationShowed");
				//Notification.this.setVisible(false);
				//Notification.this.removeFromParent();
				
			}
		};

		// Schedule the timer to close the popup in 3 seconds.
		t1.schedule(399);



		////////////////



		Timer t = new Timer() {
			@Override
			public void run() {

				Notification.this.setVisible(false);
				Notification.this.removeFromParent();
			}
		};

		// Schedule the timer to close the popup in 3 seconds.
		t.schedule(delayMilliseconds);

	}


	@Override
	protected void onLoad() {
		super.onLoad();
		//panel.addStyleName("notificationShowed");
		//
		//usernameTextBox.setFocus(true);
	}

	@Override
	protected void onAttach() {
		super.onAttach();
		//panel.addStyleName("notificationShowed");
	}
}