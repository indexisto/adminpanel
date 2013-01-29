package com.indexisto.front.adminpanel.client.windows;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;


public class Notification extends Composite {
	private FlowPanel panel = new FlowPanel();

    public Notification(String text) {
    // this();
    	// super(false, false);
        panel.addStyleName("notifications");
        panel.addStyleName("text_14_black_bold");
        panel.add(new Label(text));
        
       // int left=Window.getClientWidth()-260;
        //setPopupPosition(left, 50); 
        show(3000);
        initWidget(panel);
    }
    
    
    public Notification() {
    	
    }

    void show(int delayMilliseconds) {
       
        Timer t = new Timer() {
            @Override
            public void run() {
            	
            	//Notification.this.setVisible(false);
            	//Notification.this.removeFromParent();
            }
        };

        // Schedule the timer to close the popup in 3 seconds.
        t.schedule(delayMilliseconds);
        //Log.debug("Timer started");
    }
}