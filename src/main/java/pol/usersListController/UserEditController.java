package pol.usersListController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pol.abstractController.AbstractController;
import pol.entity.RoleEntity;
import pol.entity.UserEntity;
import pol.frontend.WindowWidth;
import pol.role.service.RoleService;
import pol.spring.bind.editors.RoleSelectEditor;
import pol.user.service.UserService;

@Controller
@SessionAttributes(UserEditController.FORM)
@RequestMapping(value="/users/edit")
public class UserEditController  extends AbstractController{
	
	private static String VIEW_NAME="/users/UserEdit";
	private static final String ROLES= "roles";
	public static final String FORM = "userEditForm";
	
	@Autowired
	RoleService roleService;
	@Autowired 
	UserService userService;
	
	@RequestMapping(method = { RequestMethod.GET })
	public String edit(Model model,
			@RequestParam(value = "id", required = false) Integer id) {
		UserEntity user = id == null ? null : userService.find(id);
		model.addAttribute(FORM, new UserEditForm(user));
		return getViewName();
	}
	
	@RequestMapping(method = { RequestMethod.POST}, params="save")
	public String save(Model model,  @ModelAttribute(FORM) UserEditForm form){
			form.setUserEntity(userService.save(form.getUser()));
			model.addAttribute(FORM, form);
			addSuccessMessage(model, "Pomyślnie zapisano użytkownika");
			refreshParent(model);
		return getViewName();
	}
	

	
	@ModelAttribute(ROLES)
	public Map<String,String> getRoles(){
		return roleService.getRoleComboList(true);
	}
	
	@Override
	protected String getPageTitle() {
		return "Edycja danych użytkownika";
	}

	@Override
	protected boolean showMenu() {
		return false;
	}

	@Override
	protected WindowWidth getWindowWidth() {
		return WindowWidth.SHORT;
	}
	
	protected String getViewName() {
		return VIEW_NAME;
	}
	
	@Override
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(RoleEntity.class,
				new RoleSelectEditor());
		super.initBinder(binder);
	}
	
}
