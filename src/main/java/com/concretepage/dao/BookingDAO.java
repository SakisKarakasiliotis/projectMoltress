package com.concretepage.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Booking;

@Transactional
@Repository
public class BookingDAO implements IBookingDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Booking getBookingById(int bookingId) {
        return entityManager.find(Booking.class, bookingId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Booking> getAllBookings() {
        String hql = "FROM Booking as bkng ORDER BY bkng.id";
        return (List<Booking>) entityManager.createQuery(hql).getResultList();
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Booking> getAllBookingsByUserId(Integer id){
        String hql = "FROM Booking as bkng WHERE bkng.visitorId = ? ";
        return (List<Booking>) entityManager.createQuery(hql).setParameter(1, id).getResultList();
    }

    @Override
    public void addBooking(Booking booking) {
        entityManager.persist(booking);
    }

    @Override
    public void updateBooking(Booking booking) {
        Booking bkng = getBookingById(booking.getId());
        if (booking.getStartDate() != null) {
            bkng.setStartDate(booking.getStartDate());
        }
        if (booking.getEndDate() != null) {

            bkng.setEndDate(booking.getEndDate());
        }
        if (booking.getTotalPrice() != null) {
            bkng.setTotalPrice(booking.getTotalPrice());
        }
        if (booking.getEstateId() != null) {
            bkng.setEstateId(booking.getEstateId());
        }
        if (booking.getVisitorId() != null) {
            bkng.setVisitorId(booking.getVisitorId());
        }

        entityManager.flush();
    }

    @Override
    public void deleteBooking(int bookingId) {
        entityManager.remove(getBookingById(bookingId));
    }

    //TODO: needs datespan intersection
    @Override
    public boolean bookingExists(Date start, Date end, Integer estateId) {
        String hql ="FROM Booking as bkng WHERE " +
                "(bkng.startDate <= ? AND bkng.endDate >= ?) AND bkng.estateId = ?";
        int count = entityManager.createQuery(hql)
                .setParameter(1, end)
                .setParameter(2, start)
                .setParameter(3, estateId)
                .getResultList().size();
        return count > 0;


    }
}
