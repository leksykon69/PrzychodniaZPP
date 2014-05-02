package pol.visitsController;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import pol.entity.VisitEntity;

public class VisitEditForm {

	private VisitEntity visit;
	private DateTime date;
	private LocalTime startHour;
	private LocalTime endHour;

	// public VisitEditForm() {
	// // setVisit(createNewVisitEndTime());
	// }

	public VisitEditForm(VisitEntity visit) {
		if (visit == null) {
			visit = createNewVisitEndTime();
		}
		setVisit(visit);
	}

	private VisitEntity createNewVisitEndTime() {
		VisitEntity visit = new VisitEntity();
		DateTime nextVisitTime = getNextVisitTime();
		visit.setStartTime(nextVisitTime);
		visit.setEndTime(nextVisitTime.plusMinutes(15));
		return visit;
	}
	
	private DateTime getNextVisitTime() {
		DateTime nextVisitTime = new DateTime().plusHours(1);
		int currentMinute = nextVisitTime.getMinuteOfHour();
		if (isBeetween(currentMinute, 0, 15)) {
			return nextVisitTime.withMinuteOfHour(0);
		} else if (isBeetween(currentMinute, 15, 30)) {
			return nextVisitTime.withMinuteOfHour(15);
		} else if (isBeetween(currentMinute, 30, 45)) {
			return nextVisitTime.withMinuteOfHour(30);
		} else if (isBeetween(currentMinute, 45, 60)) {
			return nextVisitTime.withMinuteOfHour(45);
		}
		return nextVisitTime;
	}

	private boolean isBeetween(int value, int from, int to) {
		return value >= from && value < to;
	}

	public VisitEntity getVisit() {
		return visit;
	}

	public void setVisit(VisitEntity visit) {
		this.visit = visit;
		this.date = visit.getStartTime().withTime(0, 0, 0, 0);
		this.startHour = visit.getStartTime().toLocalTime();
		this.endHour = visit.getEndTime().toLocalTime();
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
		this.visit.setStartTime(startHour.toDateTime(date));
		this.visit.setEndTime(endHour.toDateTime(date));
	}

	public LocalTime getStartHour() {
		return startHour;
	}

	public void setStartHour(LocalTime startHour) {
		this.startHour = startHour;
		this.visit.setStartTime(startHour.toDateTime(date));
	}

	public LocalTime getEndHour() {
		return endHour;
	}

	public void setEndHour(LocalTime endHour) {
		this.endHour = endHour;
		this.visit.setEndTime(endHour.toDateTime(date));
	}

}
