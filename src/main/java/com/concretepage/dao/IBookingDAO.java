package com.concretepage.dao;

import java.util.List;
import java.sql.Date;

import com.concretepage.entity.Booking;

public interface IBookingDAO {
    List<Booking> getAllBookings();

    Booking getBookingById(int bookingId);

    void addBooking(Booking booking);

    void updateBooking(Booking booking);

    void deleteBooking(int bookingId);

    boolean bookingExists(Date start, Date end);


}