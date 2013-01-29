package com.indexisto.front.adminpanel.client.pages.login;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class LoginPlace extends Place {
    private String token;

    public LoginPlace(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public static class Tokenizer implements PlaceTokenizer<LoginPlace> {
        public String getToken(LoginPlace place) {
            return place.getToken();
        }

        public LoginPlace getPlace(String token) {
            return new LoginPlace(token);
        }
    }
}