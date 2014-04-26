package pol.spring.bind.editors;

import pol.abstractDao.AbstractDao;
import pol.entity.RoomEntity;
import pol.room.dao.RoomDao;

public class RoomSelectEditor extends AbstractEntityEditor<RoomEntity> {

	@Override
	public AbstractDao<?> getDao() {
		return context.getBean(RoomDao.class);
	}

	@Override
	public Class<?> getClazz() {
		return RoomEntity.class;
	}

}
