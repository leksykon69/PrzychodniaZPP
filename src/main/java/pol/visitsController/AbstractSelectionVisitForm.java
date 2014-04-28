package pol.visitsController;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import pol.entity.DoctorEntity;
import pol.entity.PatientEntity;
import pol.entity.RoomEntity;

public abstract class AbstractSelectionVisitForm {
	protected DoctorEntity doctor;
	protected PatientEntity patient;
	protected RoomEntity room;
	protected DateTime dateFrom;
	protected DateTime dateTo;
	protected LocalTime startTime;
	protected LocalTime endTime;
	protected boolean isMonday = true;
	protected boolean isTuesday = true;
	protected boolean isWednesday = true;
	protected boolean isThursday = true;
	protected boolean isFriday = true;
	protected boolean isSaturday = true;
	protected boolean isSunday = true;

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public RoomEntity getRoom() {
		return room;
	}

	public void setRoom(RoomEntity room) {
		this.room = room;
	}

	public DateTime getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(DateTime dateFrom) {
		this.dateFrom = dateFrom;
	}

	public DateTime getDateTo() {
		return dateTo;
	}

	public void setDateTo(DateTime dateTo) {
		this.dateTo = dateTo;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public boolean isMonday() {
		return isMonday;
	}

	public void setMonday(boolean isMonday) {
		this.isMonday = isMonday;
	}

	public boolean isTuesday() {
		return isTuesday;
	}

	public void setTuesday(boolean isTuesday) {
		this.isTuesday = isTuesday;
	}

	public boolean isWednesday() {
		return isWednesday;
	}

	public void setWednesday(boolean isWednesday) {
		this.isWednesday = isWednesday;
	}

	public boolean isThursday() {
		return isThursday;
	}

	public void setThursday(boolean isThursday) {
		this.isThursday = isThursday;
	}

	public boolean isFriday() {
		return isFriday;
	}

	public void setFriday(boolean isFriday) {
		this.isFriday = isFriday;
	}

	public boolean isSaturday() {
		return isSaturday;
	}

	public void setSaturday(boolean isSaturday) {
		this.isSaturday = isSaturday;
	}

	public boolean isSunday() {
		return isSunday;
	}

	public void setSunday(boolean isSunday) {
		this.isSunday = isSunday;
	}

	public boolean showAllDays() {
		return isMonday && isTuesday && isWednesday && isThursday && isFriday
				&& isSaturday && isSunday;
	}

	public List<Integer> getDaysList() {
		List<Integer> list = new ArrayList<Integer>();
		if (isMonday)
			list.add(2);
		if (isTuesday)
			list.add(3);
		if (isWednesday)
			list.add(4);
		if (isThursday)
			list.add(5);
		if (isFriday)
			list.add(6);
		if (isSaturday)
			list.add(7);
		if (isSunday)
			list.add(1);
		return list;
	}
}
