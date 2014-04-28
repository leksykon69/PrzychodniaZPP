package pol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import pol.baseEntity.AbstractEntity;

@Entity
@Table(name = "room")
@NamedQueries({ @NamedQuery(name = RoomEntity.FIND_ALL_ORDERED, query = "select e from RoomEntity e order by e.name, e.number") })
public class RoomEntity extends AbstractEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL_ORDERED = "RoomEntity.findAllOrdered";

	@Id
	private Integer id;

	@Column(name = "number")
	private String number;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFullName(){
		return getName() + " " + getNumber();
	}
}
