package pol.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import pol.baseEntity.AbstractEntity;

@Entity
@Table(name = "visit")
@Getter
@Setter
public class VisitEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
