package pol.visit.dao.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.Query;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.springframework.stereotype.Repository;

import pol.abstractDao.AbstractDaoImpl;
import pol.entity.DoctorEntity;
import pol.entity.PatientEntity;
import pol.entity.RoomEntity;
import pol.entity.VisitEntity;
import pol.visit.dao.VisitDao;
import pol.visitsController.AbstractSelectionVisitForm;

@Repository
public class VisitDaoImpl extends AbstractDaoImpl<VisitEntity> implements
		VisitDao {

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public VisitDaoImpl() {
		super(VisitEntity.class);
	}

	@SuppressWarnings("unchecked")
	public List<VisitEntity> getVisitsListByForm(AbstractSelectionVisitForm form) {
		StringBuilder queryText = new StringBuilder(
				"from VisitEntity where 1=1");
		if (form.getDateFrom() != null) {
			queryText.append(" and startTime >= '"
					+ dateFormat.format(form.getDateFrom().toDate()) + "'");
			queryText.append(" and endTime >= '"
					+ dateFormat.format(form.getDateFrom().toDate()) + "'");
		}
		if (form.getDateTo() != null) {
			queryText.append(" and startTime <= '"
					+ dateFormat.format(form.getDateTo().plusDays(1).toDate())
					+ "'");
			queryText.append(" and endTime <= '"
					+ dateFormat.format(form.getDateTo().plusDays(1).toDate())
					+ "'");
		}
		if (form.getDoctor() != null) {
			queryText.append(" and doctor.id = '" + form.getDoctor().getId()
					+ "'");
		}
		if (form.getPatient() != null) {
			queryText.append(" and patient.id = '" + form.getPatient().getId()
					+ "'");
		}
		if (form.getRoom() != null) {
			queryText.append(" and room.id = '" + form.getRoom().getId() + "'");
		}
		if (!form.showAllDays()) {
			queryText.append(" and dayofweek(startTime) in(:days)");
		}
		if (form.getStartTime() != null
				&& !form.getStartTime().equals(LocalTime.MIDNIGHT)) {
			queryText.append(" and hour(startTime)*60 + minute(startTime) >= ");
			queryText.append(form.getStartTime().getHourOfDay() * 60
					+ form.getStartTime().getMinuteOfHour());
		}
		if (form.getEndTime() != null
				&& !form.getEndTime().equals(LocalTime.MIDNIGHT)) {
			queryText.append(" and hour(endTime)*60 + minute(endTime) <= ");
			queryText.append(form.getEndTime().getHourOfDay() * 60
					+ form.getEndTime().getMinuteOfHour());
		}
		queryText.append(" order by startTime");
		Query query = getEntityManager().createQuery(queryText.toString());
		if (!form.showAllDays()) {
			query.setParameter("days", form.getDaysList());
		}
		return query.getResultList();
	}


	@SuppressWarnings("unchecked")
	public List<VisitEntity> findByDoctor(DoctorEntity doctor,
			DateTime dateFrom, DateTime dateTo) {
		StringBuilder queryText = new StringBuilder(
				"from VisitEntity e where e.doctor.id = ");
		queryText.append(doctor.getId());
		appendDateCondition(dateFrom, dateTo, queryText);
		return getEntityManager().createQuery(queryText.toString())
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<VisitEntity> findByPatient(PatientEntity patient,
			DateTime dateFrom, DateTime dateTo) {
		StringBuilder queryText = new StringBuilder(
				"from VisitEntity e where e.patient.id = ");
		queryText.append(patient.getId());
		appendDateCondition(dateFrom, dateTo, queryText);
		return getEntityManager().createQuery(queryText.toString())
				.getResultList();
	
	}
	
	@SuppressWarnings("unchecked")
	public List<VisitEntity> findByRoom(RoomEntity room, DateTime dateFrom,
			DateTime dateTo) {
		StringBuilder queryText = new StringBuilder(
				"from VisitEntity e where e.doctor.id = ");
		queryText.append(room.getId());
		appendDateCondition(dateFrom, dateTo, queryText);
		return getEntityManager().createQuery(queryText.toString())
				.getResultList();

	}
	
	private void appendDateCondition(DateTime dateFrom, DateTime dateTo,
			StringBuilder queryText) {
		if (dateFrom != null) {
			queryText.append(" and startTime >= '"
					+ dateFormat.format(dateFrom.toDate()) + "'");
		}
		if (dateTo != null) {
			queryText.append(" and startTime <= '"
					+ dateFormat.format(dateTo.plusDays(1).toDate()) + "'");
		}
		queryText.append("order by e.startTime");
	}
}
