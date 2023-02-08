package com.gary.springboot.learningspring.web;

import com.gary.springboot.learningspring.business.ReservationService;
import com.gary.springboot.learningspring.business.RoomReservation;
import com.gary.springboot.learningspring.data.Guest;
import com.gary.springboot.learningspring.utils.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {
    private final ReservationService reservationService;

    public GuestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getQuests(Model model) {
        List<Guest> guests = this.reservationService.getAllGuests();
        model.addAttribute("guests", guests);
        return "guests";
    }
}
