package pol.doctor.service.impl;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pol.abstractDao.AbstractDao;
import pol.abstractService.AbstractServiceImpl;
import pol.doctor.dao.DoctorDao;
import pol.doctor.service.DoctorService;
import pol.entity.DoctorEntity;
import pol.userGenerator.GeneratedUserData;
import pol.userGenerator.UserGenerator;

import com.google.common.collect.Lists;

@Service
public class DoctorServiceImpl extends AbstractServiceImpl<DoctorEntity>
		implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	UserGenerator userGenerator;
	@Override
	protected AbstractDao<DoctorEntity> getDao() {
		return doctorDao;
	}

	public Map<String, String> getDoctorComboOptions(boolean showEmptyOption) {
		Map<String, String> result = new LinkedHashMap<String, String>();
		if (showEmptyOption) {
			result.put("", "");
		}
		List<DoctorEntity> doctors = doctorDao.findAllOrdered();
		for (DoctorEntity doctor : doctors) {
			result.put(doctor.getId().toString(), doctor.getFullName());
		}
		return result;
	}
	
	public List<DoctorEntity> generateSampleDoctors() throws IOException {
		List<DoctorEntity> patients = Lists.newArrayList();
		for (int i = 0; i < 20; i++) {
			DoctorEntity doctor = new DoctorEntity();
			doctor = getAndPrepareAndSaveDoctor(doctor);
			patients.add(doctor);
		}
		return patients;
	}

	private DoctorEntity getAndPrepareAndSaveDoctor(DoctorEntity doctor)
			throws IOException {
		try {
			GeneratedUserData data = userGenerator.getGeneratedUserData();
			doctor.setUser(data.getUser());
			doctorDao.saveOrUpdate(doctor);
		} catch (Exception e) {
			// "swiadomie zjadam wyjatek"
			e.printStackTrace();
		}
		return doctor;
	}
}
