package com.concretepage.controller;

import java.util.List;

import com.concretepage.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;
import com.concretepage.service.IBookingService;

@Controller
@RequestMapping("/")
public class BookingController {
    @Autowired
    private IBookingService availabilityService;

    @GetMapping("availability/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") Integer id) {
        Booking availability = availabilityService.getBookingById(id);
        return new ResponseEntity<Booking>(availability, HttpStatus.OK);
    }

    @GetMapping("bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> list = availabilityService.getAllBookings();
        return new ResponseEntity<List<Booking>>(list, HttpStatus.OK);
    }

    @PostMapping("availability")
    public ResponseEntity<Void> addBooking(@RequestBody Booking availability, UriComponentsBuilder builder) {
        boolean flag = availabilityService.addBooking(availability);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/availability/{id}").buildAndExpand(availability.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("availability")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking availability) {
        availabilityService.updateBooking(availability);
        return new ResponseEntity<Booking>(availability, HttpStatus.OK);
    }

    @DeleteMapping("availability/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable("id") Integer id) {
        availabilityService.deleteBooking(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
