package pol.visit.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pol.abstractDao.AbstractDao;
import pol.abstractService.AbstractServiceImpl;
import pol.entity.DoctorEntity;
import pol.entity.RoomEntity;
import pol.entity.VisitEntity;
import pol.utils.ProjectUtils;
import pol.visit.dao.VisitDao;
import pol.visit.service.VisitService;
import pol.visitsController.AbstractSelectionVisitForm;
import pol.visitsController.VisitsGeneratorForm;

@Service
public class VisitServiceImpl extends AbstractServiceImpl<VisitEntity>
		implements VisitService {

	@Autowired
	private VisitDao visitDao;

	@Override
	protected AbstractDao<VisitEntity> getDao() {
		return visitDao;
	}

	public List<VisitEntity> generateAndSaveVisits(VisitsGeneratorForm form) {
		List<VisitEntity> visits = new VisitGenerator(form).generate();
		saveAll(visits);
		return visits;
	}

	private class VisitGenerator {
		private Map<Integer, Boolean> daysEnabled = new HashMap<Integer, Boolean>();
		private DateTime dateFrom;
		private DateTime dateTo;
		private LocalTime start;
		private LocalTime end;
		private Integer duration;
		private DoctorEntity doctor;
		private RoomEntity room;

		public VisitGenerator(VisitsGeneratorForm form) {
			dateFrom = form.getDateFrom();
			dateTo = form.getDateTo();
			start = form.getStartTime();
			end = form.getEndTime();
			daysEnabled.put(1, form.isMonday());
			daysEnabled.put(2, form.isTuesday());
			daysEnabled.put(3, form.isWednesday());
			daysEnabled.put(4, form.isThursday());
			daysEnabled.put(5, form.isFriday());
			daysEnabled.put(6, form.isSaturday());
			daysEnabled.put(7, form.isSunday());
			duration = form.getDuration();
			doctor = form.getDoctor();
			room = form.getRoom();
		}

		public List<VisitEntity> generate() {
			List<VisitEntity> result = new ArrayList<VisitEntity>();
			LocalTime currentTime;
			while (!dateFrom.isAfter(dateTo)) {
				currentTime = start;
				if (isCurrentDayEnabled()) {
					result.addAll(createVisitsForOneDay(currentTime));
				}
				incrementDateFrom();
			}
			return result;
		}

		private List<VisitEntity> createVisitsForOneDay(LocalTime currentTime) {
			List<VisitEntity> result = new ArrayList<VisitEntity>();
			while (currentTime.isBefore(end)) {
				result.add(createNewVisit(currentTime));
				currentTime = currentTime.plusMinutes(duration);
			}
			return result;
		}

		private Boolean isCurrentDayEnabled() {
			return daysEnabled.get(dateFrom.getDayOfWeek());
		}

		private void incrementDateFrom() {
			dateFrom = dateFrom.plusDays(1);
		}

		private VisitEntity createNewVisit(LocalTime currentTime) {
			VisitEntity visit = new VisitEntity();
			visit.setDoctor(doctor);
			visit.setRoom(room);
			visit.setStartTime(ProjectUtils.addLocalTimeToDateTime(currentTime,
					dateFrom));
			currentTime = currentTime.plusMinutes(duration);
			visit.setEndTime(ProjectUtils.addLocalTimeToDateTime(currentTime,
					dateFrom));
			return visit;
		}
	}

	public Map<String, List<VisitEntity>> getVisitToDisplayList(
			AbstractSelectionVisitForm form) {
		Map<String, List<VisitEntity>> result = new LinkedHashMap<String, List<VisitEntity>>();
		List<VisitEntity> visits = getVisitsByForm(form);
		if (visits.size() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd MMMM yyyy",
					Locale.forLanguageTag("pl"));
			VisitEntity visit = visits.get(0);
			DateTime currentDate;
			DateTime previousDate = visit.getStartTime();
			String key = sdf.format(previousDate.toDate());
			List<VisitEntity> visitList = new LinkedList<VisitEntity>();
			result.put(key, visitList);
			visitList.add(visit);
			for (int i = 1; i < visits.size(); i++) {
				visit = visits.get(i);
				currentDate = visit.getStartTime();
				if (currentDate.getYear() != previousDate.getYear()
						|| currentDate.getMonthOfYear() != previousDate
								.getMonthOfYear()
						|| currentDate.getDayOfMonth() != previousDate
								.getDayOfMonth()) {
					previousDate = currentDate;
					key = sdf.format(previousDate.toDate());
					visitList = new LinkedList<VisitEntity>();
					result.put(key, visitList);
				}
				visitList.add(visit);
			}
		}
		return result;
	}

	public List<VisitEntity> getVisitsByForm(AbstractSelectionVisitForm form) {
		return ((VisitDao) getDao()).getVisitsListByForm(form);
	}
}
