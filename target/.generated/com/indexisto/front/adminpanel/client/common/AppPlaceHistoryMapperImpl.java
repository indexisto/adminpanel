package com.indexisto.front.adminpanel.client.common;

import com.google.gwt.place.impl.AbstractPlaceHistoryMapper;
import com.indexisto.front.adminpanel.client.common.AppPlaceHistoryMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.impl.AbstractPlaceHistoryMapper.PrefixAndToken;
import com.google.gwt.core.client.GWT;

public class AppPlaceHistoryMapperImpl extends AbstractPlaceHistoryMapper<Void> implements AppPlaceHistoryMapper {
  
  protected PrefixAndToken getPrefixAndToken(Place newPlace) {
    if (newPlace instanceof com.indexisto.front.adminpanel.client.pages.login.LoginPlace) {
      com.indexisto.front.adminpanel.client.pages.login.LoginPlace place = (com.indexisto.front.adminpanel.client.pages.login.LoginPlace) newPlace;
      PlaceTokenizer<com.indexisto.front.adminpanel.client.pages.login.LoginPlace> t = GWT.create(com.indexisto.front.adminpanel.client.pages.login.LoginPlace.Tokenizer.class);
      return new PrefixAndToken("LoginPlace", t.getToken((com.indexisto.front.adminpanel.client.pages.login.LoginPlace) place));
    }
    if (newPlace instanceof com.indexisto.front.adminpanel.client.pages.register.RegisterPlace) {
      com.indexisto.front.adminpanel.client.pages.register.RegisterPlace place = (com.indexisto.front.adminpanel.client.pages.register.RegisterPlace) newPlace;
      PlaceTokenizer<com.indexisto.front.adminpanel.client.pages.register.RegisterPlace> t = GWT.create(com.indexisto.front.adminpanel.client.pages.register.RegisterPlace.Tokenizer.class);
      return new PrefixAndToken("RegisterPlace", t.getToken((com.indexisto.front.adminpanel.client.pages.register.RegisterPlace) place));
    }
    return null;
  }
  
  protected PlaceTokenizer<?> getTokenizer(String prefix) {
    if ("RegisterPlace".equals(prefix)) {
      return GWT.create(com.indexisto.front.adminpanel.client.pages.register.RegisterPlace.Tokenizer.class);
    }
    if ("LoginPlace".equals(prefix)) {
      return GWT.create(com.indexisto.front.adminpanel.client.pages.login.LoginPlace.Tokenizer.class);
    }
    return null;
  }

}
