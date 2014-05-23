package pol.userGenerator;

import java.io.IOException;

import pol.abstractService.AbstractService;
import pol.entity.UserEntity;

public interface UserGenerator extends AbstractService<UserEntity>{
	public GeneratedUserData getGeneratedUserData() throws IOException;

}
