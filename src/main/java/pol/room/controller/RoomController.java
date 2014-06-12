package pol.room.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pol.abstractController.AbstractController;
import pol.entity.RoomEntity;
import pol.room.service.RoomService;

@Controller
@RequestMapping(value = "/room/edit")
public class RoomController extends AbstractController {

	private static final String VIEW_NAME = "/room/RoomEdit";
	private static final String ROOM = "room";

	private final RoomService roomService;

	@Autowired
	public RoomController(RoomService roomService) {
		this.roomService = checkNotNull(roomService);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String process(Model model,
			@RequestParam(required = false, value = "id") Integer id) {
		model.addAttribute(ROOM, getRoom(id));
		return VIEW_NAME;
	}

	public RoomEntity getRoom(Integer id) {
		if (id == null) {
			return new RoomEntity();
		}
		return roomService.find(id);
	}

	@RequestMapping(method = RequestMethod.POST, params = "save")
	public String save(Model model, @ModelAttribute(ROOM) RoomEntity room) {
		roomService.save(room);
		model.addAttribute(ROOM, room);
		addSuccessMessage(model, "Pomyślnie zapisano Pokój");
		refreshParent(model);
		return VIEW_NAME;
	}
}
