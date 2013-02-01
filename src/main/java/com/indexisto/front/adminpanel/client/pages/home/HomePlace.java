package com.indexisto.front.adminpanel.client.pages.home;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class HomePlace extends Place {
    private String token;

    public HomePlace(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public static class Tokenizer implements PlaceTokenizer<HomePlace> {
        public String getToken(HomePlace place) {
            return place.getToken();
        }

        public HomePlace getPlace(String token) {
            return new HomePlace(token);
        }
    }
}