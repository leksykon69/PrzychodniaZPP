package pol.visit.dao.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.Query;

import org.joda.time.LocalTime;
import org.springframework.stereotype.Repository;

import pol.abstractDao.AbstractDaoImpl;
import pol.entity.VisitEntity;
import pol.visit.dao.VisitDao;
import pol.visitsController.AbstractSelectionVisitForm;

@Repository
public class VisitDaoImpl extends AbstractDaoImpl<VisitEntity> implements
		VisitDao {

	public VisitDaoImpl() {
		super(VisitEntity.class);
	}

	@SuppressWarnings("unchecked")
	public List<VisitEntity> getVisitsListByForm(AbstractSelectionVisitForm form) {
		StringBuilder queryText = new StringBuilder(
				"from VisitEntity where 1=1");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (form.getDateFrom() != null) {
			queryText.append(" and startTime >= '"
					+ sdf.format(form.getDateFrom().toDate()) + "'");
			queryText.append(" and endTime >= '"
					+ sdf.format(form.getDateFrom().toDate()) + "'");
		}
		if (form.getDateTo() != null) {
			queryText.append(" and startTime <= '"
					+ sdf.format(form.getDateTo().plusDays(1).toDate()) + "'");
			queryText.append(" and endTime <= '"
					+ sdf.format(form.getDateTo().plusDays(1).toDate()) + "'");
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

}
