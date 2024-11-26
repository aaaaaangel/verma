package com.hotel.controller;

import com.hotel.pojo.Room;
import com.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(Room room) { roomService.addRoom(room); }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @RequestMapping("/delete")
    public void deleteRoom(int id) {
        roomService.deleteRoom(id);
    }

    @RequestMapping("/update")
    public void updateRoom(Room room) {
        roomService.updateRoom(room);
    }

    @RequestMapping(value = "/location/{location}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Room> getRoomByLocation(@PathVariable String location) {
        return roomService.getRoomByLocation(location);
    }

    @RequestMapping(value = "/travelers/{travelers}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Room> getRoomByTravelers(@PathVariable int travelers) {
        return roomService.getRoomsByTravelers(travelers);
    }

    @RequestMapping(value = "/book")
    public void Book(int id) {  }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Room getRoomById(@PathVariable int id) { return roomService.getRoomById(id); }
}