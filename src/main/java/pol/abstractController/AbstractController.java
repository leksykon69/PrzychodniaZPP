package pol.abstractController;

import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class AbstractController {

	public static final String PAGE_TITLE = "pageTitle";
	public static final String SHOW_MENU = "showMenu"; 
	
	protected static String pageTitle= "Przychodnia";
	
	@ModelAttribute(PAGE_TITLE)
	protected String getPageTitle(){
		return pageTitle;
	}
	
	@ModelAttribute(SHOW_MENU)
	protected boolean showMenu(){
		return true;
	}
	
}
