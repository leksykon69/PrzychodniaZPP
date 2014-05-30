package pol.loginController;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pol.abstractController.AbstractController;


@Controller
@RequestMapping( value="/login")
public class LoginController extends AbstractController {
	
	private static final String VIEW_NAME = "Login";

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String generate() throws IOException{
		return VIEW_NAME;
	}

}
