package pol.patient.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pol.abstractDao.AbstractDao;
import pol.abstractService.AbstractServiceImpl;
import pol.entity.PatientEntity;
import pol.patient.dao.PatientDao;
import pol.patient.service.PatientService;

@Service
public class PatientServiceImpl extends AbstractServiceImpl<PatientEntity>
		implements PatientService {

	@Autowired
	private PatientDao patientDao;

	@Override
	protected AbstractDao<PatientEntity> getDao() {
		return patientDao;
	}

	public Map<String, String> getPatientComboOptions(boolean showEmptyOption) {
		Map<String, String> result = new LinkedHashMap<String, String>();
		if (showEmptyOption) {
			result.put("", "");
		}
		List<PatientEntity> patients = patientDao.findAllOrdered();
		for (PatientEntity patient : patients) {
			result.put(patient.getId().toString(), patient.getFullName());
		}
		return result;
	}

	public List<PatientEntity> findAllOrdered() {
		return patientDao.findAllOrdered();
	}
}
