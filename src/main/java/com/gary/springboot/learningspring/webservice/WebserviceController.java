package com.gary.springboot.learningspring.webservice;

import com.gary.springboot.learningspring.business.ReservationService;
import com.gary.springboot.learningspring.business.RoomReservation;
import com.gary.springboot.learningspring.data.Guest;
import com.gary.springboot.learningspring.data.Room;
import com.gary.springboot.learningspring.utils.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebserviceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public WebserviceController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(path="/reservations", method= RequestMethod.GET)
    public List<RoomReservation> getResearvation(@RequestParam(value="date", required = false) String dateString) {
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @GetMapping("/guests")
    public List<Guest> getGuests() {
        return this.reservationService.getAllGuests();
    }

    @PostMapping("/guest")
    @ResponseStatus(HttpStatus.CREATED)
    public Guest addGuest(@RequestBody Guest guest) {
        return this.reservationService.addGuest(guest);
    }

    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return this.reservationService.getAllRooms();
    }
}
