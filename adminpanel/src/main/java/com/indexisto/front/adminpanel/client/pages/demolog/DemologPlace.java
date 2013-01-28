package com.indexisto.front.adminpanel.client.pages.demolog;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class DemologPlace extends Place {
    private String token;

    public DemologPlace(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public static class Tokenizer implements PlaceTokenizer<DemologPlace> {
        public String getToken(DemologPlace place) {
            return place.getToken();
        }

        public DemologPlace getPlace(String token) {
            return new DemologPlace(token);
        }
    }
}