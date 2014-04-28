package pol.doctor.service.impl;

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

@Service
public class DoctorServiceImpl extends AbstractServiceImpl<DoctorEntity>
		implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;

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
}
