package pol.room.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pol.abstractDao.AbstractDaoImpl;
import pol.entity.RoomEntity;
import pol.room.dao.RoomDao;

@Repository
public class RoomDaoImpl extends AbstractDaoImpl<RoomEntity> implements RoomDao {

	public RoomDaoImpl() {
		super(RoomEntity.class);
	}

	@Transactional
	public List<RoomEntity> findAllOrdered() {
		return getEntityManager().createNamedQuery(RoomEntity.FIND_ALL_ORDERED,
				RoomEntity.class).getResultList();
	}

}
