package pol.statsController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
import pol.stats.service.StatService;
import pol.user.service.UserService;
import pol.visit.service.VisitService;

@Controller
@RequestMapping(value = "/stats/")
public class StatsController extends AbstractController {

	public static final String VIEW_NAME = "/stats/Stats";
	private static final String USER_COUNT = "userCount";
	private static final String PATIENT_COUNT = "patientCount";
	private static final String DOCTOR_COUNT = "doctorCount";
	private static final String VISIT_COUNT = "visitCount";
	private static final String ROOM_COUNT = "roomCount";

	private static final String STAT_DATA = "statData";
	private static final String FORM = "statForm";
	private static final String ACTIVE_TAB = "activeTab";
	
	private static final String PATIENTS = "patients";
	private static final String DOCTORS = "doctors";
	private static final String ROOMS = "rooms";

	@Autowired
	UserService userService;

	@Autowired
	PatientService patientService;

	@Autowired
	DoctorService doctorService;

	@Autowired
	RoomService roomService;

	@Autowired
	VisitService visitService;

	@Autowired
	StatService statService;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String process(Model model) {
		model.addAttribute(FORM, new StatsForm());
		model.addAttribute(ACTIVE_TAB, "main");
		return VIEW_NAME;
	}
	
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, params = "showDoctor")
	public String showDoctor(Model model, @ModelAttribute(FORM) StatsForm form) {
		model.addAttribute(FORM, form);
		model.addAttribute(ACTIVE_TAB, "doctor");
		model.addAttribute(
				STAT_DATA,
				statService.getStatsForEntity(form.getDoctor(),
						form.getDateFrom(), form.getDateTo()));
		return VIEW_NAME;
	}
	
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, params = "showPatient")
	public String showPatient(Model model, @ModelAttribute(FORM) StatsForm form) {
		model.addAttribute(FORM, form);
		model.addAttribute(ACTIVE_TAB, "patient");
		model.addAttribute(
				STAT_DATA,
				statService.getStatsForEntity(form.getPatient(),
						form.getDateFrom(), form.getDateTo()));
		return VIEW_NAME;
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, params = "showRoom")
	public String showRooms(Model model, @ModelAttribute(FORM) StatsForm form) {
		model.addAttribute(FORM, form);
		model.addAttribute(ACTIVE_TAB, "room");
		model.addAttribute(
				STAT_DATA,
				statService.getStatsForEntity(form.getRoom(),
						form.getDateFrom(), form.getDateTo()));
		return VIEW_NAME;
	}

	@ModelAttribute(USER_COUNT)
	public Long getUserCount() {
		return userService.getCount();
	}

	@ModelAttribute(PATIENT_COUNT)
	public Long getPatientCount() {
		return patientService.getCount();
	}

	@ModelAttribute(DOCTOR_COUNT)
	public Long getDoctorCount() {
		return doctorService.getCount();
	}

	@ModelAttribute(ROOM_COUNT)
	public Long getRoomCount() {
		return roomService.getCount();
	}

	@ModelAttribute(VISIT_COUNT)
	public Long getVisitCount() {
		return visitService.getCount();
	}

	@ModelAttribute(PATIENTS)
	public Map<String, String> getPatients() {
		return patientService.getPatientComboOptions(true);
	}

	@ModelAttribute(DOCTORS)
	public Map<String, String> getDoctors() {
		return doctorService.getDoctorComboOptions(true);
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
