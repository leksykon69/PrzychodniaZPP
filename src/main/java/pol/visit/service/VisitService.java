package pol.visit.service;

import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import pol.abstractService.AbstractService;
import pol.entity.DoctorEntity;
import pol.entity.PatientEntity;
import pol.entity.RoomEntity;
import pol.entity.VisitEntity;
import pol.visitsController.AbstractSelectionVisitForm;
import pol.visitsController.VisitsGeneratorForm;

public interface VisitService extends AbstractService<VisitEntity> {

	public List<VisitEntity> generateAndSaveVisits(VisitsGeneratorForm form);

	public Map<String, List<VisitEntity>> getVisitToDisplayList(
			AbstractSelectionVisitForm form);

	public List<VisitEntity> getVisitsByForm(AbstractSelectionVisitForm form);

	public List<VisitEntity> findByRoom(RoomEntity room, DateTime dateFrom,
			DateTime dateTo);

	public List<VisitEntity> findByPatient(PatientEntity patient,
			DateTime dateFrom, DateTime dateTo);

	public List<VisitEntity> findByDoctor(DoctorEntity doctor,
			DateTime dateFrom, DateTime dateTo);

}
