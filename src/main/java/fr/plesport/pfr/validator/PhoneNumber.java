package fr.plesport.pfr.validator;

	import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

	@Constraint(validatedBy = PhoneNumberValidator.class)
	@Target(value = ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	public  @interface PhoneNumber {
		String message() default "{validator.phonenumber}";

		Class<?>[] groups() default {};

		Class<? extends Payload>[] payload() default {};
	}