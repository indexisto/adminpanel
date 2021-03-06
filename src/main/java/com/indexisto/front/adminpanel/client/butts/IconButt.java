package com.indexisto.front.adminpanel.client.butts;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

public class IconButt extends Composite {

    public FocusPanel panel = new FocusPanel();
    public FlowPanel icon = new FlowPanel();
    public FlowPanel text = new FlowPanel();
    public FlowPanel content = new FlowPanel();
    public FlowPanel clearfloat = new FlowPanel();
    public Label hintLabel;
    public void addStyles() {
    	panel.addStyleName("ButtonPanel");
    	
    	icon.addStyleName("ButtonIcon");

    	content.addStyleName("ButtonContent");
    	text.addStyleName("ButtonText");
    	clearfloat.addStyleName("ClearFloat");
    }
    
    
    public IconButt(String textToSet) {
    	this();
    	setText(textToSet);	
    }
    
    
    public IconButt() {
    	//this.albumObj = albumObjj;
    	//addStyles();
    	
    	panel.addStyleName("ButtonPanel");
    	icon.addStyleName("ButtonIcon");
    	content.addStyleName("ButtonContent");
    	text.addStyleName("ButtonText");
    	clearfloat.addStyleName("ClearFloat");
    	
    	panel.add(content);
    	//content.add(backGround);
    	content.add(icon);
    	content.add(text);
    	content.add(clearfloat);
    	

    	
    
    	
    			

		
	
		initWidget(panel);
	}
    
    
    
    public void setText(String textToSet) {
    	text.add(new HTML(textToSet));
    	text.getElement().setInnerText(textToSet);
    } 
    
    public void setEnabled(boolean isEnabled)  {
    	if (isEnabled) {
    		panel.getElement().getStyle().setProperty("opacity","1");
    	} else {
    		panel.getElement().getStyle().setProperty("opacity","0.8");
    	}
    }
    
    
    public void addIconStyle(String iconStyle)  {
    	icon.addStyleName(iconStyle);
    }
    
    
    public void addPanelStyle(String panelStyle)  {
    	panel.addStyleName(panelStyle);
    }
    
    public void removePanelStyle(String panelStyle)  {
    	panel.removeStyleName(panelStyle);
    }
    
    public void addTextStyle(String textStyle)  {
    	text.addStyleName(textStyle);
    }
    
    public void setButtSize(int height, int width) {
    	panel.getElement().getStyle().setProperty("width", width + "px");
    	panel.getElement().getStyle().setProperty("height", height + "px");
    }
    
    
    public FocusPanel getFocusPanel() {
    	return panel;
    }
    
    
    public void setSelectedBack (String style) {
		this.addPanelStyle(style);
	}
	
	public void setUnselectedBack (String style) {
		this.removePanelStyle(style);
	}
	
	
	public void setHintText (final String text) {
		
		
		this.getFocusPanel().addMouseOverHandler(new MouseOverHandler() {

			public void onMouseOver(MouseOverEvent event) {
				// TODO Auto-generated method stub
				System.out.println("over");
				 hintLabel = new Label(text);
				 hintLabel.addStyleName("hintLabel");
				 IconButt.this.content.add(hintLabel);
				 
				 int widthHint = hintLabel.getOffsetWidth();
				 int heightHint = hintLabel.getOffsetHeight();
				 Log.debug("width2 " + String.valueOf(widthHint));
				 Log.debug("height2 " + String.valueOf(heightHint));
	
				 
				 
				 int width = IconButt.this.panel.getOffsetWidth();
				 int height = IconButt.this.panel.getOffsetHeight();
				 
				 
				 Log.debug(String.valueOf(width));
				 Log.debug(String.valueOf(height));
				 
				 int hintLeft = 0;
				 if ((widthHint - width) > 0) {
					 hintLeft = (widthHint - width)/2 * -1;
				 } else {
					 hintLeft = (width - widthHint)/2;
				 }
				 
				 Log.debug("hintLeft " + hintLeft);
				 
				 hintLabel.getElement().getStyle().setProperty("top", (height + 2) + "px" );
				 hintLabel.getElement().getStyle().setProperty("left", (hintLeft) + "px" );
				 
			}
			
		});
		
		
		this.getFocusPanel().addMouseOutHandler(new MouseOutHandler() {


			public void onMouseOut(MouseOutEvent event) {
				// TODO Auto-generated method stub
				System.out.println("out");
				if (hintLabel!=null) {
					hintLabel.removeFromParent();
					hintLabel = null;
					
				}
			}
			
		});
		
		
	}
	
}
