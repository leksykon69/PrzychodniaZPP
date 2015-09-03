package pol.usersListController;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import pol.role.service.RoleService;
import pol.spring.bind.editors.RoleSelectEditor;
import pol.user.service.UserService;


@Controller
@SessionAttributes(UsersListController.FORM)
@RequestMapping(value = "/users")
public class UsersListController extends AbstractController {

	private static String VIEW_NAME = "users/UsersList";
	public static final String FORM = "usersListForm";
	private static final String USERS_LIST="userList";
	private static final String ROLES= "roles";

	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String proccess(HttpSession session, Model model) {
		UsersListForm form= (UsersListForm)session.getAttribute(FORM);
		prepareForm(model, form);
		return VIEW_NAME;
	}
	
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, params = "show")
	public String show(Model model, @ModelAttribute(FORM) UsersListForm form) {
		prepareForm(model, form);
		model.addAttribute(USERS_LIST,userService.getUsersToDisplayList(form.getRole()));
		return VIEW_NAME;
	}

	
	@RequestMapping(method={ RequestMethod.POST }, params="remove")
	public String remove(Model model,@RequestParam("id") Integer userId,@ModelAttribute(FORM) UsersListForm form){
		try{
			userService.delete(userService.find(userId));
			addSuccessMessage(model, "Pomyślnie usunięto użytkownika");
		}catch(Exception e){
			addErrorMessage(model, e.getMessage());
		}
		
		return show(model, form);
	}
	
	@ModelAttribute(ROLES)
	public Map<String,String> getRoles(){
		
		return roleService.getRoleComboList(true);
				//getEntityComboOptions(true, roleService.findAll(), "getName");
		
		
	}
	
	@Override
	protected String getPageTitle() {
		return super.getPageTitle() + " - Lista użytkowników";
	}
	
	@ModelAttribute(USERS_LIST)
	public List<UserEntity> getUsersList(Model model){
		List<UserEntity> usersList = new LinkedList<UserEntity>();
		
		usersList=userService.findAll();
		
		return usersList;
	}
	
	private void prepareForm(Model model, UsersListForm form) {

		if (form == null) {
			form = new UsersListForm();
		}
		model.addAttribute(FORM, form);
	}
	
	@Override
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(RoleEntity.class,
				new RoleSelectEditor());
		super.initBinder(binder);
	}
	
}
