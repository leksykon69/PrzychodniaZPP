package pol.room.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pol.abstractDao.AbstractDao;
import pol.abstractService.AbstractServiceImpl;
import pol.entity.RoomEntity;
import pol.room.dao.RoomDao;
import pol.room.service.RoomService;

@Service
public class RoomServiceImpl extends AbstractServiceImpl<RoomEntity> implements
		RoomService {

	@Autowired
	private RoomDao roomDao;

	@Override
	protected AbstractDao<RoomEntity> getDao() {
		return roomDao;
	}
}
