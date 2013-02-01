package com.indexisto.front.adminpanel.client.common;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.indexisto.front.adminpanel.client.pages.demolog.DemologActivity;
import com.indexisto.front.adminpanel.client.pages.demolog.DemologPlace;
import com.indexisto.front.adminpanel.client.pages.home.HomeActivity;
import com.indexisto.front.adminpanel.client.pages.home.HomePlace;
import com.indexisto.front.adminpanel.client.pages.login.LoginActivity;
import com.indexisto.front.adminpanel.client.pages.login.LoginPlace;
import com.indexisto.front.adminpanel.client.pages.register.RegisterActivity;
import com.indexisto.front.adminpanel.client.pages.register.RegisterPlace;

public class AppActivityMapper implements ActivityMapper {


    public AppActivityMapper() {
        super();
        
    }

    public Activity getActivity(Place place) {
        if (place instanceof RegisterPlace)
            return new RegisterActivity((RegisterPlace) place);
       
        else if (place instanceof LoginPlace)
            return new LoginActivity((LoginPlace) place);
        
        else if (place instanceof DemologPlace)
            return new DemologActivity((DemologPlace) place);
        
        else if (place instanceof HomePlace)
            return new HomeActivity((HomePlace) place);
           
        return null;
    }
}