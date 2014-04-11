package pol.visitsController;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import pol.entity.DoctorEntity;
import pol.entity.RoomEntity;

public class VisitsGeneratorForm {
	private DoctorEntity doctor;
	private RoomEntity room;
	private DateTime dateFrom = new DateTime();
	private DateTime dateTo = new DateTime();
	private LocalTime startTime = new LocalTime(8, 0);
	private LocalTime endTime = new LocalTime(16, 0);
	private Integer duration = 15;
	private boolean isMonday;
	private boolean isTuesday;
	private boolean isWednesday;
	private boolean isThursday;
	private boolean isFriday;
	private boolean isSaturday;
	private boolean isSunday;
	public DoctorEntity getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
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
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
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
}
