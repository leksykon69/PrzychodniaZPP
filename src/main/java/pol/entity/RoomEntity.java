package pol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import pol.baseEntity.AbstractEntity;

@Entity
@Table(name = "room")
@NamedQueries({ @NamedQuery(name = RoomEntity.FIND_ALL_ORDERED, query = "select e from RoomEntity e order by e.name, e.number") })
@Getter
@Setter
public class RoomEntity extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL_ORDERED = "RoomEntity.findAllOrdered";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "number")
	private String number;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	public String getFullName(){
		return getName() + " " + getNumber();
	}
}
