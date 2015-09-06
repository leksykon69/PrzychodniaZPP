package pol.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;
import pol.baseEntity.AbstractEntity;

@Entity
@Table(name = "role")
@Getter
@Setter
public class RoleEntity extends AbstractEntity implements GrantedAuthority{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private List<PermissionEntity> permissions = new ArrayList<PermissionEntity>();

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private List<MenuEntity> menus = new ArrayList<MenuEntity>();

	public String getAuthority() {
		return name;
	}
}
