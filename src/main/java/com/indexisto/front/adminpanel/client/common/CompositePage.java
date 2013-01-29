package com.indexisto.front.adminpanel.client.common;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.indexisto.front.adminpanel.client.common.helpers.HavePresenter;
import com.indexisto.front.adminpanel.client.pages.register.RegisterView.Presenter;

public abstract class CompositePage extends Composite {

	public FlowPanel panel = new FlowPanel();

	public FlowPanel pageTitleContainer = new FlowPanel();
	public FlowPanel pageContetntContainer = new FlowPanel();
	public Label pageTitle = new Label("Page name");
	
	public CompositePage() {
		pageTitle.addStyleName("pageTitle");
		pageTitleContainer.addStyleName("pageTitleContainer");
		pageContetntContainer.addStyleName("pageContetntContainer");
		pageTitleContainer.add(pageTitle);
		
		panel.add(pageTitleContainer);
		panel.add(pageContetntContainer);
		initWidget(panel);
	}
	public FlowPanel getPanel() {
		return panel;
	}
	public void setPanel(FlowPanel panel) {
		panel.addStyleName("panelCompositePage");
		this.panel = panel;
		
	}
	

}
