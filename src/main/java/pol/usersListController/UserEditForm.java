package pol.usersListController;

import pol.entity.RoleEntity;
import pol.entity.UserEntity;

public class UserEditForm {

	private UserEntity user;
	/*public UserEditForm(){
		userEntity=new UserEntity();
	}*/
		
	public UserEditForm(UserEntity user){
		if(user==null){
			user=createNewUser();
		}
		setUserEntity(user);
	}

	private UserEntity createNewUser() {
		UserEntity user = new UserEntity();
		return user;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUserEntity(UserEntity user) {
		this.user = user;
	}

}
