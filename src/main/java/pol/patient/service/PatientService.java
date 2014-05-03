package pol.patient.service;

import java.util.List;
import java.util.Map;

import pol.abstractService.AbstractService;
import pol.entity.PatientEntity;

public interface PatientService extends AbstractService<PatientEntity> {

	public Map<String, String> getPatientComboOptions(boolean showEmptyOption);

	public List<PatientEntity> findAllOrdered();
}
