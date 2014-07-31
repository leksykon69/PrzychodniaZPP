package pol.mainController;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pol.abstractController.AbstractController;

@Controller
@RequestMapping( value="/")
public class MainController extends AbstractController{
	
	@RequestMapping(method={RequestMethod.GET, RequestMethod.GET})
	public String defaultRequest(){
		
		return "Index";
	}
	
	
	
	@ModelAttribute("SampleCombobox")
	public Map<String,String> getSampleComboboxOptions(){
		Map<String, String> result = new LinkedHashMap<String, String>();
		result.put("1", "Opcja 1");
		result.put("2", "Opcja 2");
		result.put("3", "Opcja 3");
		result.put("4", "Opcja 4");
		result.put("5", "Opcja 5");
		return result;	
	}
}
