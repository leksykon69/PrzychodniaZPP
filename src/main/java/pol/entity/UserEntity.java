package pol.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import pol.baseEntity.AbstractEntity;

@Entity
@Table(name = "user")
@Getter
@Setter
@NamedQueries({ @NamedQuery(name = UserEntity.FIND_BY_LOGIN, query = "select e from UserEntity e where e.login=:login") })
public class UserEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	public static final String FIND_BY_LOGIN = "findByLogin";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@OneToOne
	private RoleEntity role;

	public List<RoleEntity> getRoles() {
		return Arrays.asList(this.role);
	}
}
