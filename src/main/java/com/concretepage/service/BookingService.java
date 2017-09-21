package com.concretepage.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.IBookingDAO;
import com.concretepage.entity.Booking;

@Service
public class BookingService implements IBookingService {
    @Autowired
    private IBookingDAO bookingDAO;

    @Override
    public Booking getBookingById(int bookingId) {
        Booking obj = bookingDAO.getBookingById(bookingId);
        return obj;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }

    @Override
    public synchronized boolean addBooking(Booking booking) {
        if (bookingDAO.bookingExists(booking.getStartDate(), booking.getEndDate())) {
            return false;
        } else {
            bookingDAO.addBooking(booking);
            return true;
        }
    }

    @Override
    public void updateBooking(Booking booking) {
        bookingDAO.updateBooking(booking);
    }

    @Override
    public void deleteBooking(int bookingId) {
        bookingDAO.deleteBooking(bookingId);
    }


    public boolean bookingExists(Date start, Date end){
        if(bookingDAO.bookingExists(start,end)){
            return true;
        }
        return false;
   }
}
