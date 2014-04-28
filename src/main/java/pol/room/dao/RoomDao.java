package pol.room.dao;

import java.util.List;

import pol.abstractDao.AbstractDao;
import pol.entity.RoomEntity;

public interface RoomDao extends AbstractDao<RoomEntity> {

	public List<RoomEntity> findAllOrdered();

}
