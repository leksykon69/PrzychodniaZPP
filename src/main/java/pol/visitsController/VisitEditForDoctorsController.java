package pol.visitsController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pol.frontend.WindowWidth;

@Controller
@SessionAttributes(VisitEditController.FORM)
@RequestMapping(value = "/visit/editfd")
public class VisitEditForDoctorsController extends VisitEditController {

	private static final String VIEW_NAME = "/visit/VisitEditForDoctors";

	@Override
	protected String getViewName() {
		return VIEW_NAME;
	}

	@Override
	protected WindowWidth getWindowWidth() {
		return WindowWidth.MEDIUM;
	}
}
