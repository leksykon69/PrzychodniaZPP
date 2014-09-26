package pol.patient.service.impl;

import java.io.IOException;
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
import pol.role.service.RoleService;
import pol.userGenerator.GeneratedUserData;
import pol.userGenerator.UserGenerator;

import com.google.common.collect.Lists;

@Service
public class PatientServiceImpl extends AbstractServiceImpl<PatientEntity>
		implements PatientService {

	@Autowired
	private PatientDao patientDao;

	@Autowired
	UserGenerator userGenerator;

	@Autowired
	RoleService roleService;
	
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

	public List<PatientEntity> generateSamplePatient() throws IOException {
		List<PatientEntity> patients = Lists.newArrayList();
		for (int i = 0; i < 50; i++) {
			PatientEntity patient = new PatientEntity();
			patient = getAndPrepareAndSavePatient(patient);
			patients.add(patient);
		}
		return patients;
	}

	@Override
	public PatientEntity save(PatientEntity obj) {
		obj.setRole(roleService.find(4));
		return super.save(obj);
	}
	
	private PatientEntity getAndPrepareAndSavePatient(PatientEntity patient)
			throws IOException {
		try {
			GeneratedUserData data = userGenerator.getGeneratedUserData();
			patient.setUser(data.getUser());
			patient.setPesel(data.getPesel());
			patientDao.saveOrUpdate(patient);
		} catch (Exception e) {
			// "swiadomie zjadam wyjatek"
			e.printStackTrace();
		}
		return patient;
	}

}
