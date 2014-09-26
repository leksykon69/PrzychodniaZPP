package pol.visitsController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import pol.abstractController.AbstractController;
import pol.doctor.service.DoctorService;
import pol.entity.DoctorEntity;
import pol.entity.RoomEntity;
import pol.entity.VisitEntity;
import pol.frontend.WindowWidth;
import pol.room.service.RoomService;
import pol.spring.bind.editors.DoctorSelectEditor;
import pol.spring.bind.editors.RoomSelectEditor;
import pol.visit.service.VisitService;

@Controller
@SessionAttributes(VisitsGeneratorController.FORM)
@RequestMapping(value="/visit/generator")
public class VisitsGeneratorController extends AbstractController{

	private static final String VIEW_NAME = "/visit/VisitGenerator";
	public static final String FORM = "generateVisitsForm";
	private static final String DOCTORS = "doctors";
	private static final String ROOMS = "rooms"; 

	@Autowired
	private VisitService visitService;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private RoomService roomService;

	@RequestMapping(method=RequestMethod.GET)
	public String proccess(Model model){
		model.addAttribute(FORM, new VisitsGeneratorForm());
		return VIEW_NAME;
	}
	
	@RequestMapping(method = RequestMethod.POST, params = "generate")
	public String doGenerate(Model model, @ModelAttribute(FORM) VisitsGeneratorForm form){
		List<VisitEntity> result = visitService.generateAndSaveVisits(form);
		addSuccessMessage(model, "Wygenerowano " + result.size() + " wizyt");
		return VIEW_NAME;
	}
	
	@Override
	protected String getPageTitle() {
		return super.getPageTitle()+": Automatyczny Kreator Terminów Wizyt";
	}
	
	@ModelAttribute(DOCTORS)
	public Map<String, String> getDoctors(){
		return doctorService.getDoctorComboOptions(false);
	}
	
	@ModelAttribute(ROOMS)
	public Map<String, String> getRooms(){
		return roomService.getRoomComboOptions(false);
	}
	
	@Override
	protected boolean showMenu() {
		return false;
	}
	
	@Override
	protected WindowWidth getWindowWidth() {
		return WindowWidth.MEDIUM;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(DoctorEntity.class, new DoctorSelectEditor());
		binder.registerCustomEditor(RoomEntity.class, new RoomSelectEditor());
		super.initBinder(binder);
	}
}
