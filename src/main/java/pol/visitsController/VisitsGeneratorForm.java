package pol.visitsController;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

public class VisitsGeneratorForm extends AbstractSelectionVisitForm {

	private Integer duration = 15;

	public VisitsGeneratorForm() {
		isSaturday = false;
		isSunday = false;
		dateFrom = new DateTime();
		dateTo = new DateTime();
		startTime = new LocalTime(8, 0);
		endTime = new LocalTime(16, 0);
	}

	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
}
