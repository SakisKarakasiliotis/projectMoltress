package com.concretepage.controller;

import java.util.List;
import java.sql.Date;

import com.concretepage.entity.Booking;
import com.concretepage.entity.Availability;
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
import com.concretepage.service.IAvailabilityService;

@Controller
@RequestMapping("/")
public class BookingController {
    @Autowired
    private IBookingService bookingService;
    private IAvailabilityService availabilityService;

    @GetMapping("booking/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") Integer id) {
        Booking booking = bookingService.getBookingById(id);
        return new ResponseEntity<Booking>(booking, HttpStatus.OK);
    }

    @GetMapping("bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> list = bookingService.getAllBookings();
        return new ResponseEntity<List<Booking>>(list, HttpStatus.OK);
    }

    @PostMapping("booking")
    public ResponseEntity<Void> addBooking(@RequestBody Booking booking, UriComponentsBuilder builder) {
        boolean flag = bookingService.addBooking(booking );
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/booking/{id}").buildAndExpand(booking.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("booking")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking) {
        bookingService.updateBooking(booking);
        return new ResponseEntity<Booking>(booking, HttpStatus.OK);
    }

    @DeleteMapping("booking/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable("id") Integer id) {
        bookingService.deleteBooking(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("booking/book")
    public ResponseEntity<Void> bookAnEstate(@RequestBody Booking booking, UriComponentsBuilder builder){
       if(bookingService.bookingExists( booking.getStartDate(),booking.getEndDate())) {
           return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); //TODO: error codes and response protocol
       }
       else if(!availabilityService.availabilityExists(booking.getEstateId(), booking.getStartDate(),booking.getEndDate())){
           return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
       }
       //create the booking entry and push it to DB and then return..
        bookingService.addBooking(booking);
        return new ResponseEntity<Void>( HttpStatus.OK);
    }
}
