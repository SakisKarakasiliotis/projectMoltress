package com.concretepage.controller;

import java.util.List;

import com.concretepage.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.concretepage.service.IBookingService;
import com.concretepage.service.IAvailabilityService;

@CrossOrigin(origins = "http://localhost:8090", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class BookingController {
    @Autowired
    private IBookingService bookingService;

    @Autowired
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
    @GetMapping("bookings/{id}")
    public ResponseEntity<List<Booking>> getAllBookingsByUserId(@PathVariable("id") Integer id) {
        List<Booking> list = bookingService.getAllBookingsByUserId(id);
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
    public ResponseEntity<String> bookAnEstate(@RequestBody Booking booking, UriComponentsBuilder builder){
       if(bookingService.bookingExists( booking.getStartDate(),booking.getEndDate(), booking.getEstateId())) {
           return new ResponseEntity<String>("SKATA",HttpStatus.CONFLICT); //TODO: error codes and response protocol
       }
       else if(!availabilityService.availabilityExists(booking.getEstateId(), booking.getStartDate(),booking.getEndDate())){
           return new ResponseEntity<String>("SKATA2",HttpStatus.CONFLICT);
       }
       //create the booking entry and push it to DB and then return..
        bookingService.addBooking(booking);
        return new ResponseEntity<String>("POPA", HttpStatus.OK);
    }
}
