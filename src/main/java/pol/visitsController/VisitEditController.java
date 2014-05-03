package pol.visitsController;

import java.util.Map;

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
import pol.entity.VisitEntity;
import pol.frontend.WindowWidth;
import pol.patient.service.PatientService;
import pol.room.service.RoomService;
import pol.spring.bind.editors.DoctorSelectEditor;
import pol.spring.bind.editors.PatientSelectEditor;
import pol.spring.bind.editors.RoomSelectEditor;
import pol.visit.service.VisitService;

@Controller
@SessionAttributes(VisitEditController.FORM)
@RequestMapping(value = "/visit/edit")
public class VisitEditController extends AbstractController {

	private static final String VIEW_NAME = "/visit/VisitEdit";
	public static final String FORM = "visitEditForm";
	public static final String DOCTORS = "doctors";
	public static final String PATIENTS = "patients";
	public static final String ROOMS = "rooms";

	@Autowired
	private VisitService visitService;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private RoomService roomService;

	@Autowired
	private PatientService patientService;

	@RequestMapping(method = { RequestMethod.GET })
	public String edit(Model model,
			@RequestParam(value = "id", required = false) Integer id) {
		VisitEntity visit = id == null ? null : visitService.find(id);
		model.addAttribute(FORM, new VisitEditForm(visit));
		return getViewName();
	}

	@RequestMapping(method = { RequestMethod.POST }, params = "save")
	public String save(Model model, @ModelAttribute(FORM) VisitEditForm form) {
		form.setVisit(visitService.save(form.getVisit()));
		model.addAttribute(FORM, form);
		addSuccessMessage(model, "Pomyślnie zapisano Wizytę");
		return getViewName();
	}

	@Override
	protected String getPageTitle() {
		return "Edycja Wizyty";
	}

	@Override
	protected boolean showMenu() {
		return false;
	}

	@Override
	protected WindowWidth getWindowWidth() {
		return WindowWidth.SHORT;
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

	protected String getViewName() {
		return VIEW_NAME;
	}
}
