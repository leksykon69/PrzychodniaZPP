package pol.room.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

	public Map<String, String> getRoomComboOptions(boolean showEmptyOption) {
		Map<String, String> result = new LinkedHashMap<String, String>();
		if (showEmptyOption) {
			result.put("", "");
		}
		List<RoomEntity> rooms = roomDao.findAllOrdered();
		for (RoomEntity room : rooms) {
			result.put(room.getId().toString(), room.getFullName());
		}
		return result;
	}

}
