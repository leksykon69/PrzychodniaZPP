package pol.statsController;

import org.joda.time.DateTime;

import pol.entity.DoctorEntity;
import pol.entity.PatientEntity;
import pol.entity.RoomEntity;

public class StatsForm {

	private DateTime dateFrom;
	private DateTime dateTo;

	private DoctorEntity doctor;
	private PatientEntity patient;
	private RoomEntity room;

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
}
