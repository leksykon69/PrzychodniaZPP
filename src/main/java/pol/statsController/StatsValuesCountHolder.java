package pol.statsController;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import pol.baseEntity.AbstractEntity;
import pol.entity.DoctorEntity;
import pol.entity.PatientEntity;
import pol.entity.RoomEntity;
import pol.entity.VisitEntity;

public class StatsValuesCountHolder {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	private AbstractEntity entity;

	private boolean hasDataToShow = true;
	private Integer maxVisitCount = 0;
	private Integer maxDoctorCount = 0;
	private Integer maxPatientCount = 0;
	private Integer maxRoomCount = 0;

	private Map<String, Integer> visitCountByDates = new LinkedHashMap<String, Integer>();
	private Map<String, Integer> doctorCount = new LinkedHashMap<String, Integer>();
	private Map<String, Integer> patientCount = new LinkedHashMap<String, Integer>();
	private Map<String, Integer> roomCount = new LinkedHashMap<String, Integer>();

	public StatsValuesCountHolder(AbstractEntity entity,
			List<VisitEntity> visits) {
		this.entity = entity;
		if (entity instanceof DoctorEntity) {
			doctorCount = null;
		}
		if (entity instanceof PatientEntity) {
			patientCount = null;
		}
		if (entity instanceof RoomEntity) {
			roomCount = null;
		}
		if (visits.size() == 0) {
			hasDataToShow = false;
		} else {
			setUpVisitCountMap(visits);

			for (VisitEntity visit : visits) {
				incrementVisitByDateCount(visit);
				incrementDoctorCount(visit);
				incrementPatientCount(visit);
				incrementRoomCount(visit);
			}
		}
	}

	private void setUpVisitCountMap(List<VisitEntity> visits) {
		DateTime startDate = visits.get(0).getStartTime();
		DateTime endDate = visits.get(visits.size() - 1).getStartTime();
		while (startDate.compareTo(endDate) <= 0) {
			visitCountByDates.put(dateFormat.format(startDate.toDate()), 0);
			startDate = startDate.plusDays(1);
		}
	}

	private void incrementDoctorCount(VisitEntity visit) {
		if (visit.getDoctor() != null) {
			if (!(entity instanceof DoctorEntity)) {
				if (doctorCount.containsKey(visit.getDoctor().getFullName())) {
					int count = doctorCount
							.get(visit.getDoctor().getFullName());
					count++;
					doctorCount.put(visit.getDoctor().getFullName(), count);
					if (count > maxDoctorCount) {
						maxDoctorCount = count;
					}
				} else {
					doctorCount.put(visit.getDoctor().getFullName(), 1);
					if (maxDoctorCount == 0)
						maxDoctorCount = 1;
				}
			}
		}
	}

	private void incrementPatientCount(VisitEntity visit) {
		if (!(entity instanceof PatientEntity)) {
			if (visit.getPatient() != null) {
				if (patientCount.containsKey(visit.getPatient().getFullName())) {
					int count = patientCount.get(visit.getPatient()
							.getFullName());
					count++;
					patientCount.put(visit.getPatient().getFullName(), count);
					if (count > maxPatientCount) {
						maxPatientCount = count;
					}
				} else {
					patientCount.put(visit.getPatient().getFullName(), 1);
					if (maxPatientCount == 0)
						maxPatientCount = 1;
				}
			}
		}
	}

	private void incrementRoomCount(VisitEntity visit) {
		if (!(entity instanceof RoomEntity)) {
			if (visit.getRoom() != null) {
				if (roomCount.containsKey(visit.getRoom().getFullName())) {
					int count = roomCount.get(visit.getRoom().getFullName());
					count++;
					roomCount.put(visit.getRoom().getFullName(), count);
					if (count > maxRoomCount) {
						maxRoomCount = count;
					}
				} else {
					roomCount.put(visit.getRoom().getFullName(), 1);
					if (maxRoomCount == 0)
						maxRoomCount = 1;
				}
			}
		}
	}

	private void incrementVisitByDateCount(VisitEntity visit) {
		String key = dateFormat.format(visit.getStartTime().toDate());
		int count = visitCountByDates.get(key);
		count++;
		visitCountByDates.put(key, count);
		if (count > maxVisitCount) {
			maxVisitCount = count;
		}
	}

	public String getEntityName() {
		if (entity instanceof DoctorEntity) {
			return "Lekarz: " + ((DoctorEntity) entity).getFullName();
		}
		if (entity instanceof PatientEntity) {
			return "Pacjent: " + ((PatientEntity) entity).getFullName();
		}
		if (entity instanceof RoomEntity) {
			return "Pokój: " + ((RoomEntity) entity).getFullName();
		}
		return "";
	}

	public boolean isHasDataToShow() {
		return hasDataToShow;
	}

	public Integer getMaxVisitCount() {
		return maxVisitCount;
	}

	public Integer getMaxDoctorCount() {
		return maxDoctorCount;
	}

	public Integer getMaxPatientCount() {
		return maxPatientCount;
	}

	public Integer getMaxRoomCount() {
		return maxRoomCount;
	}

	public Map<String, Integer> getVisitCountByDates() {
		return visitCountByDates;
	}

	public Map<String, Integer> getDoctorCount() {
		return doctorCount;
	}

	public Map<String, Integer> getPatientCount() {
		return patientCount;
	}

	public Map<String, Integer> getRoomCount() {
		return roomCount;
	}

}
