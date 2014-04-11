package pol.visitsController;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pol.abstractController.AbstractController;
import pol.entity.DoctorEntity;
import pol.entity.RoomEntity;
import pol.spring.bind.editors.DoctorSelectEditor;
import pol.spring.bind.editors.RoomSelectEditor;

@Controller
@RequestMapping(value="/visit/generator")
public class VisitsGeneratorController extends AbstractController{

	private static final String VIEW_NAME = "/visit/VisitGenerator";
	private static final String FORM = "generateVisitsForm";
	private static final String DOCTORS = "doctors";
	private static final String ROOMS = "rooms"; 

	@RequestMapping(method=RequestMethod.GET)
	public String proccess(Model model){
		model.addAttribute(FORM, new VisitsGeneratorForm());
		return VIEW_NAME;
	}
	
	@RequestMapping(method = RequestMethod.POST, params = "generate")
	public String doGenerate(Model model, @ModelAttribute(FORM) VisitsGeneratorForm form){
		addSuccessMessage(model, "Udało się wysłać żądanie");
		return VIEW_NAME;
	}
	
	@Override
	protected String getPageTitle() {
		return super.getPageTitle()+": Automatyczny Kreator Terminów Wizyt";
	}
	
	@ModelAttribute(DOCTORS)
	public Map<String, String> getDoctors(){
		Map<String, String> result = new LinkedHashMap<String, String>();
		result.put("1", "Adam Kowalski");
		result.put("2", "Joanna Nowak");
		result.put("3", "Krzysztof Wiśniewski");
		return result;
	}
	
	@ModelAttribute(ROOMS)
	public Map<String, String> getRooms(){
		Map<String, String> result = new LinkedHashMap<String, String>();
		result.put("1", "Pokój 1");
		result.put("2", "Pokój 2");
		result.put("3", "Pokój 3");
		return result;
	}
	
	@Override
	protected boolean showMenu() {
		return false;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(DoctorEntity.class, new DoctorSelectEditor());
		binder.registerCustomEditor(RoomEntity.class, new RoomSelectEditor());
		super.initBinder(binder);
	}
}
