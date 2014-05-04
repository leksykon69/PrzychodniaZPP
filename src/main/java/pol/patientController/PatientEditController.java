package pol.patientController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pol.abstractController.AbstractController;
import pol.entity.PatientEntity;
import pol.frontend.WindowWidth;
import pol.patient.service.PatientService;

@Controller
@SessionAttributes(PatientEditController.PATIENT)
@RequestMapping(value = "/patients/edit")
public class PatientEditController extends AbstractController {
	
	private static final String VIEW_NAME = "patients/PatientEdit";
	protected static final String PATIENT = "patient";

	private PatientEditValidator validator = new PatientEditValidator();

	@Autowired
	PatientService patientService;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String process(Model model, @RequestParam("id") Integer id) {
		model.addAttribute(PATIENT, patientService.find(id));
		return VIEW_NAME;
	}

	@RequestMapping(method = { RequestMethod.POST }, params = "save")
	public String save(Model model,
			@ModelAttribute(PATIENT) PatientEntity patient, BindingResult errors) {
		validator.validate(patient, errors);
		if (errors.hasErrors()) {
			addWarnMessage(model,
					"Podczas edycji danych pacjenta wystąpiły błędy waliadacji");
		} else {
			try {
				model.addAttribute(PATIENT, patientService.save(patient));
			} catch (Exception e) {
				addErrorMessage(model, "Podczas zapisu zmian wystąpił błąd");
			}
			addSuccessMessage(model, "Pomyślnie zapisano zmiany");
		}
		return VIEW_NAME;
	}

	@Override
	protected boolean showMenu() {
		return false;
	}

	@Override
	protected WindowWidth getWindowWidth() {
		return WindowWidth.MEDIUM;
	}
	
}
