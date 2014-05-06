package pol.stats.service;

import org.joda.time.DateTime;

import pol.entity.DoctorEntity;
import pol.entity.PatientEntity;
import pol.entity.RoomEntity;
import pol.statsController.StatsValuesCountHolder;

public interface StatService {

	StatsValuesCountHolder getStatsForEntity(DoctorEntity doctor,
			DateTime from, DateTime to);

	StatsValuesCountHolder getStatsForEntity(PatientEntity patient,
			DateTime from, DateTime to);

	StatsValuesCountHolder getStatsForEntity(RoomEntity room, DateTime from,
			DateTime to);
}
