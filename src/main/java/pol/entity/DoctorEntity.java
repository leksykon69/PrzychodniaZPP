package pol.entity;

import javax.persistence.CascadeType;
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
import lombok.experimental.Delegate;
import pol.baseEntity.AbstractEntity;

@Entity
@Table(name = "doctor")
@NamedQueries({
		@NamedQuery(name = DoctorEntity.FIND_ALL_ORDERED, query = "select e from DoctorEntity e order by e.user.surname, e.user.name") })
@Getter
@Setter
public class DoctorEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL_ORDERED = "DoctorEntity.findAllOrdered";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	@Delegate(excludes = UserExcluder.class)
	private UserEntity user = new UserEntity();

	public String getFullName() {
		return getSurname() + " " + getName();
	}
}
