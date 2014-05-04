package pol.patientController;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pol.abstractController.AbstractValiadator;
import pol.entity.PatientEntity;

public class PatientEditValidator extends AbstractValiadator implements
		Validator {

	public boolean supports(Class<?> clazz) {
		if (clazz.equals(PatientEntity.class)) {
			return true;
		}
		return false;
	}

	public void validate(Object target, Errors errors) {
		PatientEntity patient = (PatientEntity) target;
		rejectIfEmpty(errors, patient.getName(), "name");
		rejectIfEmpty(errors, patient.getSurname(), "surname");
		rejectIfSizeNotBetween(errors, patient.getPesel(), 11, 11, "pesel");
		rejectIfWrongEmailFormat(errors, patient.getEmail(), "email");
	}

}
