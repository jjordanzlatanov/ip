package org.elsys.ip.web;

import org.elsys.ip.error.RoomAlreadyExistException;
import org.elsys.ip.error.RoomNotExistException;
import org.elsys.ip.service.RoomService;
import org.elsys.ip.service.UserService;
import org.elsys.ip.web.model.RoomDto;
import org.elsys.ip.web.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public String allRooms(WebRequest request, Model model) {
        model.addAttribute("newRoom", new RoomDto());
        model.addAttribute("rooms",  roomService.getRooms());
        model.addAttribute("errors", new HashMap<String, String>());

        return "rooms";
    }

    @GetMapping("/room")
    public String singleRoom(WebRequest request, Model model, @RequestParam("id") String roomId) {
        RoomDto room;
        try {
            room = roomService.getRoomById(roomId);
        } catch (RoomNotExistException | IllegalArgumentException e) {
            model.addAttribute("message", "Room with id '" + roomId + "' doesn't exist");
            return "error";
        }

        model.addAttribute("newRoom", room);
        return "room";
    }

    @PostMapping("/room")
    public String createRoom(@ModelAttribute("newRoom") @Valid RoomDto roomDto, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("rooms",  roomService.getRooms());
            return "rooms";
        }

        try {
            roomService.createRoom(roomDto);
        } catch (RoomAlreadyExistException e) {
            model.addAttribute("message", "Room with name " + roomDto.getName() + " already exist");
            return "error";
        }

        return "room";
    }


}
