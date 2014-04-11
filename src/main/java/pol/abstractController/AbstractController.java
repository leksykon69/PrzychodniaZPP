package pol.abstractController;

import java.util.LinkedList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import pol.entity.MenuEntity;
import pol.frontend.Message;
import pol.frontend.MessageType;
import pol.spring.bind.editors.DateTimeEditor;
import pol.spring.bind.editors.LocalTimeEditor;

@SessionAttributes(AbstractController.MENU)
public abstract class AbstractController {

	public static final String PAGE_TITLE = "pageTitle";
	public static final String SHOW_MENU = "showMenu"; 
	public static final String MENU = "menu";
	public static final String MESSAGE = "message";
	
	protected static String pageTitle= "Przychodnia";
	
	@ModelAttribute(PAGE_TITLE)
	protected String getPageTitle(){
		return pageTitle;
	}
	
	@ModelAttribute(SHOW_MENU)
	protected boolean showMenu(){
		return true;
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
	
	
	
	//FIXME Zmienić na dynamicznie wyciągane z bazy danych
	@ModelAttribute(MENU)
	protected List<MenuEntity> getMenu(){
		List<MenuEntity> result = new LinkedList<MenuEntity>();
		MenuEntity menuElement = new MenuEntity();
		menuElement.setId(1);
		menuElement.setTitle("Wizyty");
		menuElement.setUrl("http://www.dupa.pl");
		result.add(menuElement);
		menuElement = new MenuEntity();
		menuElement.setId(2);
		menuElement.setTitle("Lekarze");
		menuElement.setUrl("http://www.dupa.pl");
		result.add(menuElement);
		menuElement = new MenuEntity();
		menuElement.setId(3);
		menuElement.setTitle("Pomieszczenia");
		menuElement.setUrl("http://www.dupa.pl");
		result.add(menuElement);
		return result;
	}	
	
}
