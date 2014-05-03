package pol.spring.bind.editors;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.propertyeditors.PropertiesEditor;

public class LocalTimeEditor extends PropertiesEditor {


	@Override
	public String getAsText() {

		Object value = getValue();
		if (value instanceof LocalTime) {
			LocalTime time = (LocalTime) value;
			return DateTimeFormat.shortTime().print(time);
		} else {
			return "";
		}

	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == "") {
			setValue(null);
			return;
		}
		String[] texts = text.split(":");
		setValue(new LocalTime(Integer.parseInt(texts[0]),
				Integer.parseInt(texts[1])));
	}
}
