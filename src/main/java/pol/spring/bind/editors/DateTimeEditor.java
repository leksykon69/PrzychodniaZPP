package pol.spring.bind.editors;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.propertyeditors.PropertiesEditor;

public class DateTimeEditor extends PropertiesEditor{

	private Map<String, Integer> monthNameToNumber;
	private Map<Integer, String> numberToMonthName;

	public DateTimeEditor() {
		monthNameToNumber = new HashMap<String, Integer>();
		numberToMonthName = new HashMap<Integer, String>();
		monthNameToNumber.put("Styczeń", 1);
		monthNameToNumber.put("Luty", 2);
		monthNameToNumber.put("Marzec", 3);
		monthNameToNumber.put("Kwiecień", 4);
		monthNameToNumber.put("Maj", 5);
		monthNameToNumber.put("Czerwiec", 6);
		monthNameToNumber.put("Lipiec", 7);
		monthNameToNumber.put("Sierpień", 8);
		monthNameToNumber.put("Wrzesień", 9);
		monthNameToNumber.put("Październik", 10);
		monthNameToNumber.put("Listopad", 11);
		monthNameToNumber.put("Grudzień", 12);

		numberToMonthName.put(1, "Styczeń");
		numberToMonthName.put(2, "Luty");
		numberToMonthName.put(3, "Marzec");
		numberToMonthName.put(4, "Kwiecień");
		numberToMonthName.put(5, "Maj");
		numberToMonthName.put(6, "Czerwiec");
		numberToMonthName.put(7, "Lipiec");
		numberToMonthName.put(8, "Sierpień");
		numberToMonthName.put(9, "Wrzesień");
		numberToMonthName.put(10, "Październik");
		numberToMonthName.put(11, "Listopad");
		numberToMonthName.put(12, "Grudzień");
	}

	@Override
	public String getAsText() {
		Object value = getValue();
		if (value instanceof DateTime) {
			DateTime date = (DateTime)value;
			return date.getDayOfMonth() + " "
					+ numberToMonthName.get(date.getMonthOfYear()) + " "
					+ date.getYear();
		}
		return "";
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text != "") {
			String[] dates = text.split(" ");
			int day = Integer.parseInt(dates[0]);
			int month = monthNameToNumber.get(dates[1]);
			int year = Integer.parseInt(dates[2]);
			DateTime date = new DateTime(year, month, day, 0, 0);
			setValue(date);
		} else {
			setValue(null);
		}

	}
}
