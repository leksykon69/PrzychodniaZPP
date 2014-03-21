package pol.mainController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pol.abstractController.AbstractController;

@Controller
@RequestMapping( value="/")
public class MainController extends AbstractController{
	
	@RequestMapping(method=RequestMethod.GET)
	public String defaultRequest(){
		
		return "Index";
	}
}
