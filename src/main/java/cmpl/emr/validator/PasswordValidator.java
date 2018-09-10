/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpl.emr.validator;

import cmpl.emr.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author swdev10
 */
public class PasswordValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
			"valid.password");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConf",
				"valid.passwordConf");
		
		User cust = (User)target;
		
		if(!(cust.getPassword().equals(cust.getPasswordConf()))){
			errors.rejectValue("password", "valid.passwordConfDiff");
		}
		
	}
	
}
      
