package pol.doctor.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import pol.abstractService.AbstractService;
import pol.entity.DoctorEntity;

public interface DoctorService extends AbstractService<DoctorEntity> {

	public Map<String, String> getDoctorComboOptions(boolean showEmptyOption);
	public List<DoctorEntity> generateSampleDoctors() throws IOException;
}
