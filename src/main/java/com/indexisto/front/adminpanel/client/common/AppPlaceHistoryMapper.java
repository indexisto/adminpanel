package com.indexisto.front.adminpanel.client.common;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.indexisto.front.adminpanel.client.pages.demolog.DemologPlace;
import com.indexisto.front.adminpanel.client.pages.home.HomePlace;
import com.indexisto.front.adminpanel.client.pages.login.LoginPlace;
import com.indexisto.front.adminpanel.client.pages.register.RegisterPlace;

@WithTokenizers({
	RegisterPlace.Tokenizer.class,LoginPlace.Tokenizer.class,DemologPlace.Tokenizer.class,
	HomePlace.Tokenizer.class	
})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper
{
}
