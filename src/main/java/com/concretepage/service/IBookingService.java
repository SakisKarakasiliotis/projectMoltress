package com.concretepage.service;
import java.sql.Date;
import java.util.List;

import com.concretepage.entity.Booking;

public interface IBookingService {
    List<Booking> getAllBookings();

    Booking getBookingById(int assetId);

    boolean addBooking(Booking asset);

    void updateBooking(Booking asset);

    void deleteBooking(int bookingId);

    boolean bookingExists(Date start, Date end);
}
