package pol.room.service;

import java.util.Map;

import pol.abstractService.AbstractService;
import pol.entity.RoomEntity;

public interface RoomService extends AbstractService<RoomEntity> {

	public Map<String, String> getRoomComboOptions(boolean showEmptyOption);
}
