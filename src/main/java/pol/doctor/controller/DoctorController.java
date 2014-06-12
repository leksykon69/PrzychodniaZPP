package pol.doctor.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pol.abstractController.AbstractController;
import pol.doctor.service.DoctorService;
import pol.doctor.validator.DoctorValidator;
import pol.entity.DoctorEntity;
import pol.frontend.WindowWidth;

@Controller
@RequestMapping(value = "/doctor/edit")
public class DoctorController extends AbstractController {

	private static final String VIEW_NAME = "doctor/DoctorEdit";
	private static final String DOCTOR = "doctor";


	private final DoctorService doctorService;
	private final DoctorValidator validator;

	@Autowired
	public DoctorController(DoctorService doctorService,
			DoctorValidator validator) {
		this.doctorService = checkNotNull(doctorService);
		this.validator = checkNotNull(validator);
	}

	@RequestMapping(method = { RequestMethod.GET })
	public String process(Model model,
			@RequestParam(required = false, value = "id") Integer id) {
		model.addAttribute(DOCTOR, getDoctor(id));
		return VIEW_NAME;
	}

	private DoctorEntity getDoctor(Integer id) {
		if (id == null) {
			return new DoctorEntity();
		}

		return doctorService.find(id);
	}

	@RequestMapping(method = { RequestMethod.POST }, params = "save")
	public String save(Model model,
			@ModelAttribute(DOCTOR) DoctorEntity doctor, BindingResult errors) {
		validator.validate(doctor, errors);
		if (errors.hasErrors()) {
			addWarnMessage(model,
					"Podczas zapisu danych lekarza wystapily bledy walidacji");
		} else {
			try {
				model.addAttribute(DOCTOR, doctorService.save(doctor));
			} catch (Exception e) {
				addErrorMessage(model,
						"Podczas zapisu zmian wystapil blad" + e.getMessage());
				return VIEW_NAME;
			}
			addSuccessMessage(model, "Pomyslnie zapisano zmiany");
			refreshParent(model);
		}
		return VIEW_NAME;
	}

	@Override
	protected boolean showMenu() {
		return false;
	}

	@Override
	protected WindowWidth getWindowWidth() {
		return WindowWidth.LONG;
	}
}
