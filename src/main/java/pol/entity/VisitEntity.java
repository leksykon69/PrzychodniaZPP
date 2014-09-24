package pol.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import pol.baseEntity.AbstractEntity;

@Entity
@Table(name = "visit")
public class VisitEntity extends AbstractEntity {


	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "VisitAutoincrement", strategy = "increment")
	@GeneratedValue(generator = "VisitAutoincrement")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "doctorId")
	private DoctorEntity doctor;

	@ManyToOne
	@JoinColumn(name = "roomId")
	private RoomEntity room;

	@ManyToOne
	@JoinColumn(name = "patientId")
	private PatientEntity patient;

	private Date startTime;
	private Date endTime;
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public DateTime getStartTime() {
		return new DateTime(startTime);
	}

	public void setStartTime(DateTime startTime) {
		this.startTime = startTime.toDate();
	}

	public DateTime getEndTime() {
		return new DateTime(endTime);
	}

	public void setEndTime(DateTime endTime) {
		this.endTime = endTime.toDate();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartHour() {
		DateTime time = getStartTime();
		return DateTimeFormat.forPattern("HH:mm").print(time);
	}

	public String getEndHour() {
		DateTime time = getEndTime();
		return DateTimeFormat.forPattern("HH:mm").print(time);
	}

	public boolean isArchive() {
		return new Date().after(endTime);
	}

	public boolean isActual() {
		Date now = new Date();
		return now.before(endTime) && now.after(startTime);
	}

	public String getName() {
		return null;
	}
}
