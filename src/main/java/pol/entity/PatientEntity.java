package pol.entity;

import javax.persistence.CascadeType;
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
import lombok.experimental.Delegate;
import pol.baseEntity.AbstractEntity;

@Entity
@Table(name = "patient")
@NamedQueries({ @NamedQuery(name = PatientEntity.FIND_ALL_ORDERED, query = "select e from PatientEntity e order by e.user.surname, e.user.name") })
@Getter
@Setter
public class PatientEntity extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL_ORDERED = "PatientEntity.findAllOrdered";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(cascade=CascadeType.ALL)
	@Delegate(excludes = UserExcluder.class)
	private UserEntity user = new UserEntity();

	@Column(name = "pesel")
	private String pesel;

	public String getFullName() {
		return getSurname() + " " + getName();
	}
}
