package pol.stats.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pol.entity.DoctorEntity;
import pol.entity.PatientEntity;
import pol.entity.RoomEntity;
import pol.stats.service.StatService;
import pol.statsController.StatsValuesCountHolder;
import pol.visit.service.VisitService;

@Service
public class StatServiceImpl implements StatService{

	@Autowired
	VisitService visitService;

	public StatsValuesCountHolder getStatsForEntity(DoctorEntity doctor,
			DateTime from, DateTime to) {
		return new StatsValuesCountHolder(doctor, visitService.findByDoctor(
				doctor, from, to));
	}

	public StatsValuesCountHolder getStatsForEntity(PatientEntity patient,
			DateTime from, DateTime to) {
		return new StatsValuesCountHolder(patient, visitService.findByPatient(
				patient, from, to));
	}

	public StatsValuesCountHolder getStatsForEntity(RoomEntity room,
			DateTime from, DateTime to) {
		return new StatsValuesCountHolder(room, visitService.findByRoom(room,
				from, to));
	}

}
