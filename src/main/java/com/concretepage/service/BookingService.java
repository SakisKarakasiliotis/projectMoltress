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
    public List<Booking> getAllBookingsByUserId(Integer id) {
        return bookingDAO.getAllBookingsByUserId(id);
    }

    @Override
    public synchronized boolean addBooking(Booking booking) {
        if (bookingDAO.bookingExists(booking.getStartDate(), booking.getEndDate(), booking.getEstateId())) {
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

    @Override
    public boolean bookingExists(Date start, Date end, Integer esId){
        boolean x = bookingDAO.bookingExists(start,end, esId);
        System.out.println(x);
        return x;
   }
}
