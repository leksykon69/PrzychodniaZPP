package pol.patientController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pol.abstractController.AbstractController;
import pol.patient.service.PatientService;

@Controller
@RequestMapping(value = "/patients")
public class PatientsListController extends AbstractController {

	public static final String VIEW_NAME = "/patients/PatientsList";
	public static final String PATIENTS = "patients";
	
	@Autowired
	PatientService patientService;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String process(Model model){
		model.addAttribute(PATIENTS, patientService.findAllOrdered());
		return VIEW_NAME;
	}
	
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, params = "remove")
	public String remove(Model model, @RequestParam("id") Integer id) {
		try {
			patientService.delete(patientService.find(id));
			addSuccessMessage(model, "Pomyślnie usunięto pacjenta");
		} catch (Exception e) {
			addErrorMessage(model,
					"Nie udało się usunąć pacjenta. Do pacjenta są przypisane wizyty.");
		}
		return process(model);
	}

	@Override
	protected String getPageTitle() {
		return super.getPageTitle() + " - Lista Pacjentów";
	}
}
