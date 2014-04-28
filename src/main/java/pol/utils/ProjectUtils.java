package pol.utils;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

public class ProjectUtils {

	public static List<String> getMonthNames() {
		List<String> result = new ArrayList<String>();
		String[] monthNames = DateFormatSymbols.getInstance(
				Locale.forLanguageTag("PL")).getMonths();
		for (int i = 0; i < 12; i++) {
			result.add(monthNames[i]);
		}
		return result;
	}

	public static List<String> getMonthNamesWithFirstLetterUppercase() {
		List<String> result = new ArrayList<String>();
		List<String> monthNames = getMonthNames();
		for (String month : monthNames) {
			result.add(firstLetterToUppercase(month));
		}
		return result;
	}

	public static String firstLetterToUppercase(String t) {
		return Character.toUpperCase(t.charAt(0)) + t.substring(1);
	}

	public static DateTime addLocalTimeToDateTime(LocalTime time, DateTime date) {
		return date.plusHours(time.getHourOfDay()).plusMinutes(
				time.getMinuteOfHour());
	}

}
