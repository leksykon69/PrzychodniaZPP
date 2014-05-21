package pol.room.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

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
@RequestMapping(value = "/room")
public class RoomListController extends AbstractController {

	private static final String VIEW_NAME = "/room/RoomList";
	private static final String ROOMS = "rooms";

	private final RoomService roomService;

	@Autowired
	public RoomListController(RoomService roomService) {
		this.roomService = checkNotNull(roomService);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String process(Model model) {
		return VIEW_NAME;
	}
	
	@RequestMapping(method = RequestMethod.POST, params = "remove")
	public String remove(Model model,
			@RequestParam(required = true, value = "id") Integer id) {
		roomService.delete(roomService.find(id));
		addSuccessMessage(model, "Pomyślnie usunięto Pokój");
		model.addAttribute(ROOMS, getRooms());
		return VIEW_NAME;
	}

	@ModelAttribute(ROOMS)
	public List<RoomEntity> getRooms() {
		return roomService.findAll();
	}
}
