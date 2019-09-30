package fr.plesport.pfr.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
	public void initialize(PostalCode constraintAnnotation) {
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		return StringUtils.isEmpty(value) || value.length() == 10;
	}
}