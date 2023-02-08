package com.gary.springboot.learningspring.utils;

import com.gary.springboot.learningspring.business.ReservationService;
import com.gary.springboot.learningspring.business.RoomReservation;
import com.gary.springboot.learningspring.data.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataUnit;

import java.util.Date;
import java.util.List;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
//    private final RoomRepository roomRepository;
//    private final GuestRepository guestRepositry;
//    private final ReservationRepository reservationRepository;
    private final ReservationService reservationService;
    private final DateUtils dataUtils;

    public AppStartupEvent(
//            RoomRepository roomRepository,
//                           GuestRepository guestRepositry,
//                           ReservationRepository reservationRepository,
                           ReservationService reservationService,
                           DateUtils dateUtils) {
//        this.roomRepository = roomRepository;
//        this.guestRepositry = guestRepositry;
//        this.reservationRepository = reservationRepository;
        this.reservationService = reservationService;
        this.dataUtils = dateUtils;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
//        Iterable<Room> rooms = this.roomRepository.findAll();
//        rooms.forEach(System.out::println);
//
//        Iterable<Guest> guests = this.guestRepositry.findAll();
//        guests.forEach(System.out::println);
//
//        Iterable<Reservation> reservations = this.reservationRepository.findAll();
//        reservations.forEach(System.out::println);

        Date date = this.dataUtils.createDateFromDateString("2020-12-01");
        List<RoomReservation> reservationsForDate = this.reservationService.getRoomReservationsForDate(date);
        reservationsForDate.forEach(System.out::println);
    }
}
