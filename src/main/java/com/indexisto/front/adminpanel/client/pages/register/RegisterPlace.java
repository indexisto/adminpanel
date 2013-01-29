package com.indexisto.front.adminpanel.client.pages.register;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class RegisterPlace extends Place {
    private String token;

    public RegisterPlace(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public static class Tokenizer implements PlaceTokenizer<RegisterPlace> {
        public String getToken(RegisterPlace place) {
            return place.getToken();
        }

        public RegisterPlace getPlace(String token) {
            return new RegisterPlace(token);
        }
    }
}