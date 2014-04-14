package pol.room.dao.impl;

import org.springframework.stereotype.Repository;

import pol.abstractDao.AbstractDaoImpl;
import pol.entity.RoomEntity;
import pol.room.dao.RoomDao;

@Repository
public class RoomDaoImpl extends AbstractDaoImpl<RoomEntity> implements RoomDao {

	public RoomDaoImpl() {
		super(RoomEntity.class);
	}

}
