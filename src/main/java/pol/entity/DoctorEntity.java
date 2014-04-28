package pol.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pol.baseEntity.AbstractEntity;

@Entity
@Table(name = "doctor")
@NamedQueries({ @NamedQuery(name = DoctorEntity.FIND_ALL_ORDERED, query = "select e from DoctorEntity e order by e.user.surname, e.user.name") })
public class DoctorEntity extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL_ORDERED = "DoctorEntity.findAllOrdered";

	@Id
	private Integer id;

	@OneToOne
	private UserEntity user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Integer getUserId() {
		return user.getId();
	}

	public void setUserId(Integer id) {
		user.setId(id);
	}

	public String getName() {
		return user.getName();
	}

	public void setName(String name) {
		user.setName(name);
	}

	public String getSurname() {
		return user.getSurname();
	}

	public void setSurname(String surname) {
		user.setSurname(surname);
	}

	public String getLogin() {
		return user.getLogin();
	}

	public void setLogin(String login) {
		user.setLogin(login);
	}

	public String getPassword() {
		return user.getPassword();
	}

	public void setPassword(String password) {
		user.setPassword(password);
	}

	public String getEmail() {
		return user.getEmail();
	}

	public void setEmail(String email) {
		user.setEmail(email);
	}

	public RoleEntity getRole() {
		return user.getRole();
	}

	public void setRole(RoleEntity role) {
		user.setRole(role);
	}

	public String getFullName() {
		return getSurname() + " " + getName();
	}
}
