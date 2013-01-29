package com.indexisto.front.adminpanel.client;

/**
 * Interface to represent the messages contained in resource bundle:
 * 	/home/cher80/indexisto/adminpanel_git/adminpanel/adminpanel/target/adminpanel-1.0/WEB-INF/classes/com/indexisto/front/adminpanel/client/Messages.properties'.
 */
public interface Messages extends com.google.gwt.i18n.client.Messages {
  
  /**
   * Translated "Enter your name".
   * 
   * @return translated "Enter your name"
   */
  @DefaultMessage("Enter your name")
  @Key("nameField")
  String nameField();

  /**
   * Translated "Send".
   * 
   * @return translated "Send"
   */
  @DefaultMessage("Send")
  @Key("sendButton")
  String sendButton();
}
