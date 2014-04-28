package pol.doctor.service;

import java.util.Map;

import pol.abstractService.AbstractService;
import pol.entity.DoctorEntity;

public interface DoctorService extends AbstractService<DoctorEntity> {

	public Map<String, String> getDoctorComboOptions(boolean showEmptyOption);

}
