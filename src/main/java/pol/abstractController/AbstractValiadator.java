package pol.abstractController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;

public abstract class AbstractValiadator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	protected void rejectIfEmpty(Errors errors, Object object, String path) {
		if (object == null) {
			errors.rejectValue(path, "Pole nie może być puste");
		}
	}

	protected void rejectIfEmpty(Errors errors, String object, String path) {
		if (object == "") {
			errors.rejectValue(path, "", "Pole nie może być puste");
		}
	}

	protected void rejectIfNotBetween(Errors errors, String object,
			Integer from, Integer to, String path) {
		rejectIfNotNumber(errors, object, path);
		try {
			Integer value = Integer.parseInt(object);
			if (value.compareTo(from) <= 0 || value.compareTo(to) >= 0) {
				errors.rejectValue(path, "", "Pole musi zawierać się pomiędzy "
						+ from + " i " + to);
			}
		} catch (Exception e) {
		}
	}

	protected void rejectIfNotNumber(Errors errors, String object, String path) {
		try {
			Integer.parseInt(object);
		} catch (Exception e) {
			errors.rejectValue(path, "", "Pole musi zawierać wartość liczbową");
		}
	}

	protected void rejectIfSizeNotBetween(Errors errors, String object,
			Integer from, Integer to, String path) {
		if (object != "") {
			if (from.equals(to) && !from.equals(object.length())) {
				errors.rejectValue(path, "", "Pole musi zawierać " + from
						+ " znaków");
			} else if (from.compareTo(object.length()) < 0) {
				errors.rejectValue(path, "", "Pole musi zawierać conajmniej "
						+ from + " znaków");
			} else if (to.compareTo(object.length()) > 0) {
				errors.rejectValue(path, "", "Pole musi zawierać conajwyżej "
						+ to + " znaków");
			}
		}
	}

	protected void rejectIfWrongEmailFormat(Errors errors, String object,
			String path) {
		if (object != "") {
			Pattern pattern = Pattern.compile(EMAIL_PATTERN);
			Matcher matcher = pattern.matcher(object);
			if (!matcher.matches()) {
				errors.rejectValue(path, "", "Nie poprawny format e-mail");
			}
		}
	}

}
