package pol.abstractController;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

import pol.entity.MenuEntity;
import pol.entity.RoleEntity;
import pol.frontend.Message;
import pol.frontend.MessageType;
import pol.frontend.WindowWidth;
import pol.menu.dao.MenuDao;
import pol.spring.bind.editors.DateTimeEditor;
import pol.spring.bind.editors.LocalTimeEditor;

public abstract class AbstractController {

	private static final String LOGIN_USER_NAME = "loginUserName";
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
	
	@ModelAttribute(LOGIN_USER_NAME)
	protected String getUserName() {
		return SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal().toString();
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
	protected List<MenuEntity> getMenu() {
		final String userRolename = Iterables.get(
				SecurityContextHolder.getContext().getAuthentication()
						.getAuthorities(), 0).getAuthority();
		List<MenuEntity> menu = menuDao.findAll();
		ImmutableList<MenuEntity> filteredMenu = FluentIterable.from(menu).filter(new Predicate<MenuEntity>() {
					public boolean apply(MenuEntity argMenu) {
						 return isRolesContainUseRoleName(userRolename, argMenu);
					}

					private boolean isRolesContainUseRoleName(
							final String userRolename, MenuEntity argMenu) {
						return Iterables.find(argMenu.getRoles(), new Predicate<RoleEntity>() {
							public boolean apply(RoleEntity argRole) {
								return Objects.equal(argRole.getName(), userRolename);
							}
						}, null)!=null;
					}
		}).toList();
				return filteredMenu; 
	}

	protected void refreshParent(Model model) {
		model.addAttribute(REFRESH_PARENT, true);
	}
	
}
