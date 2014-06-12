package pol.doctor.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pol.abstractController.AbstractController;
import pol.doctor.service.DoctorService;
import pol.entity.DoctorEntity;

@Controller
@RequestMapping(value = "/doctors")
public class DoctorListController extends AbstractController {

	private static final String VIEW_NAME = "/doctor/DoctorList";
	private static final String DOCTORS = "doctors";

	private final DoctorService doctorService;

	@Autowired
	public DoctorListController(DoctorService doctorService) {
		this.doctorService = checkNotNull(doctorService);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String process(Model model) {
		return VIEW_NAME;
	}

	@RequestMapping(method = RequestMethod.POST, params = "remove")
	public String remove(Model model,
			@RequestParam(required = true, value = "id") Integer id) {
		doctorService.delete(doctorService.find(id));
		addSuccessMessage(model, "Pomyœlnie usuniêto Lekarza");
		model.addAttribute(DOCTORS, getDoctors());
		return VIEW_NAME;
	}

	@ModelAttribute(DOCTORS)
	public List<DoctorEntity> getDoctors() {
		return doctorService.findAll();
	}
}
