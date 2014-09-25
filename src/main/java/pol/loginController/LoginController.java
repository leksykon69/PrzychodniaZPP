package pol.loginController;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pol.abstractController.AbstractController;


@Controller
public class LoginController extends AbstractController {
	
	private static final String VIEW_NAME = "Login";

	@RequestMapping(value="/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String generate() throws IOException{
		return VIEW_NAME;
	}
	
	@RequestMapping(value="/loginError", method = { RequestMethod.GET, RequestMethod.POST })
	public String generateErrorPage(Model model) throws IOException{
		addErrorMessage(model, "Nieprawidłowy login lub haslo.");
		return VIEW_NAME;
	}

}
