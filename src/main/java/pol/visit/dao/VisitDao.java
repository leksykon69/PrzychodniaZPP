package pol.visit.dao;

import java.util.List;

import org.joda.time.DateTime;

import pol.abstractDao.AbstractDao;
import pol.entity.DoctorEntity;
import pol.entity.PatientEntity;
import pol.entity.RoomEntity;
import pol.entity.VisitEntity;
import pol.visitsController.AbstractSelectionVisitForm;

public interface VisitDao extends AbstractDao<VisitEntity> {

	List<VisitEntity> getVisitsListByForm(AbstractSelectionVisitForm form);

	List<VisitEntity> findByRoom(RoomEntity room, DateTime dateFrom,
			DateTime dateTo);

	List<VisitEntity> findByPatient(PatientEntity patient, DateTime dateFrom,
			DateTime dateTo);

	List<VisitEntity> findByDoctor(DoctorEntity doctor, DateTime dateFrom,
			DateTime dateTo);

}
