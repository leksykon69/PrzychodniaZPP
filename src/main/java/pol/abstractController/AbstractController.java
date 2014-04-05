package pol.abstractController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import pol.entity.MenuEntity;

@SessionAttributes(AbstractController.MENU)
public abstract class AbstractController {

	public static final String PAGE_TITLE = "pageTitle";
	public static final String SHOW_MENU = "showMenu"; 
	public static final String MENU = "menu";
	
	protected static String pageTitle= "Przychodnia";
	
	@ModelAttribute(PAGE_TITLE)
	protected String getPageTitle(){
		return pageTitle;
	}
	
	@ModelAttribute(SHOW_MENU)
	protected boolean showMenu(){
		return true;
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
