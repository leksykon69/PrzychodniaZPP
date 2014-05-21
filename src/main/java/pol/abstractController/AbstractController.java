package pol.abstractController;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import pol.entity.MenuEntity;
import pol.frontend.Message;
import pol.frontend.MessageType;
import pol.frontend.WindowWidth;
import pol.menu.dao.MenuDao;
import pol.spring.bind.editors.DateTimeEditor;
import pol.spring.bind.editors.LocalTimeEditor;

@SessionAttributes(AbstractController.MENU)
public abstract class AbstractController {

	public static final String PAGE_TITLE = "pageTitle";
	public static final String SHOW_MENU = "showMenu"; 
	public static final String MENU = "menu";
	public static final String MESSAGE = "message";
	public static final String WINDOW_WIDTH = "windowWidth";
	public static final String REFRESH_PARENT = "refreshParent";
	
	protected static String pageTitle= "Przychodnia";

	@Autowired
	MenuDao menuDao;
	
	@ModelAttribute(PAGE_TITLE)
	protected String getPageTitle(){
		return pageTitle;
	}
	
	@ModelAttribute(SHOW_MENU)
	protected boolean showMenu(){
		return true;
	}
	
	@ModelAttribute(WINDOW_WIDTH)
	protected WindowWidth getWindowWidth() {
		return WindowWidth.LONG;
	}

	protected void addSuccessMessage(Model model, String message){
		model.addAttribute(MESSAGE, new Message(message, MessageType.SUCCESS));
	}
	
	protected void addInfoMessage(Model model, String message){
		model.addAttribute(MESSAGE, new Message(message, MessageType.INFO));
	}
	
	protected void addWarnMessage(Model model, String message){
		model.addAttribute(MESSAGE, new Message(message, MessageType.WARN));
	}
	
	protected void addErrorMessage(Model model, String message){
		model.addAttribute(MESSAGE, new Message(message, MessageType.ERROR));
	}
	
	protected void addErrorMessage(Model model, String message, Exception e){
		model.addAttribute(MESSAGE, new Message(message, MessageType.ERROR, e));
	}	   

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(DateTime.class, new DateTimeEditor());
		binder.registerCustomEditor(LocalTime.class, new LocalTimeEditor());
	}
	
	
	@ModelAttribute(MENU)
	protected List<MenuEntity> getMenu(){
		return menuDao.findAll();
	}

	protected void refreshParent(Model model) {
		model.addAttribute(REFRESH_PARENT, true);
	}
	
}
