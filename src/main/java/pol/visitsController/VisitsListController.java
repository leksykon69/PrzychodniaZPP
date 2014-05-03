package pol.visitsController;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pol.abstractController.AbstractController;
import pol.doctor.service.DoctorService;
import pol.entity.DoctorEntity;
import pol.entity.PatientEntity;
import pol.entity.RoomEntity;
import pol.patient.service.PatientService;
import pol.room.service.RoomService;
import pol.spring.bind.editors.DoctorSelectEditor;
import pol.spring.bind.editors.PatientSelectEditor;
import pol.spring.bind.editors.RoomSelectEditor;
import pol.visit.service.VisitService;

@Controller
@SessionAttributes(VisitsListController.FORM)
@RequestMapping(value = "/visit")
public class VisitsListController extends AbstractController {

	public static final String VIEW_NAME = "/visit/VisitList";
	public static final String FORM = "visitListForm";
	public static final String DOCTORS = "doctors";
	public static final String PATIENTS = "patients";
	public static final String ROOMS = "rooms";
	public static final String VISITS = "visits";

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private PatientService patientService;

	@Autowired
	private RoomService roomService;

	@Autowired
	private VisitService visitService;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String proccess(HttpSession session, Model model) {
		VisitsListForm form = (VisitsListForm) session.getAttribute(FORM);
		prepareForm(form, model);
		return VIEW_NAME;
	}


	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, params = "show")
	public String show(Model model, @ModelAttribute(FORM) VisitsListForm form) {
		prepareForm(form, model);
		model.addAttribute(VISITS, visitService.getVisitToDisplayList(form));
		return VIEW_NAME;
	}

	@RequestMapping(method = { RequestMethod.POST }, params = "remove")
	public String remove(Model model,
			@ModelAttribute(FORM) VisitsListForm form,
			@RequestParam("id") Integer id) {
		visitService.delete(visitService.find(id));
		addSuccessMessage(model, "Pomyślnie usunięto wizytę");
		return show(model, form);
	}

	private void prepareForm(VisitsListForm form, Model model) {

		if (form == null) {
			form = new VisitsListForm();
		}
		model.addAttribute(FORM, form);
	}

	@ModelAttribute(DOCTORS)
	public Map<String, String> getDoctors() {
		return doctorService.getDoctorComboOptions(true);
	}

	@ModelAttribute(PATIENTS)
	public Map<String, String> getPatients() {
		return patientService.getPatientComboOptions(true);
	}

	@ModelAttribute(ROOMS)
	public Map<String, String> getRooms() {
		return roomService.getRoomComboOptions(true);
	}

	@Override
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(DoctorEntity.class,
				new DoctorSelectEditor());
		binder.registerCustomEditor(PatientEntity.class,
				new PatientSelectEditor());
		binder.registerCustomEditor(RoomEntity.class, new RoomSelectEditor());
		super.initBinder(binder);
	}

}
