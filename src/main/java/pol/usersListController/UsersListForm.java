package pol.usersListController;

import pol.entity.RoleEntity;

public class UsersListForm {

	private RoleEntity role;
	
	public UsersListForm(){
		
		this.role= null;
	}
	
	public UsersListForm(RoleEntity role){
		this.role=role ;
	}
	
	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	
}
