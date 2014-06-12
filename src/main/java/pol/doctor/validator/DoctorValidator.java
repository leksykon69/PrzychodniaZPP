package pol.doctor.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pol.abstractController.AbstractValiadator;
import pol.entity.DoctorEntity;

@Component
public class DoctorValidator extends AbstractValiadator implements Validator {

	public boolean supports(Class<?> clazz) {
		return clazz.equals(DoctorEntity.class);
	}

	public void validate(Object target, Errors errors) {
		DoctorEntity doctor = (DoctorEntity) target;
		rejectIfEmpty(errors, doctor.getName(), "name");
		rejectIfEmpty(errors, doctor.getSurname(), "surname");
		rejectIfEmpty(errors, doctor.getLogin(), "login");
		rejectIfEmpty(errors, doctor.getPassword(), "password");
		rejectIfWrongEmailFormat(errors, doctor.getEmail(), "email");
	}

}
