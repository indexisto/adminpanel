package com.indexisto.front.adminpanel.client.common;

import javax.validation.Validator;
import javax.validation.groups.Default;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;
import com.indexisto.front.adminpanel.shared.pojos.UserObj;
import com.indexisto.front.adminpanel.shared.pojos.UserObjRegisterForm;

public final class SampleValidatorFactory extends AbstractGwtValidatorFactory {

	  /**
	   * Validator marker for the Validation Sample project. Only the classes listed
	   * in the {@link GwtValidation} annotation can be validated.
	   */
	  @GwtValidation(value = { UserObj.class,UserObjRegisterForm.class})
	  public interface GwtValidator extends Validator {
	  }

	  @Override
	  public AbstractGwtValidator createValidator() {
	    return GWT.create(GwtValidator.class);
	  }
	}