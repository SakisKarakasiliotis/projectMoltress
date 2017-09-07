package com.concretepage.dao;

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

        entityManager.flush();
    }

    @Override
    public void deleteBooking(int bookingId) {
        entityManager.remove(getBookingById(bookingId));
    }

    //TODO: needs datespan intersection
    @Override
    public boolean bookingExists(Date start, Date end) {
        String hql =
                "FROM Booking as bkng WHERE " +
                        "(bkng.startDate <= ? AND bkng.endDate >= ?) OR " +
                        "(bkng.startDate <= ? AND bkng.endDate >= ?) OR " +
                        "(bkng.startDate >= ? AND bkng.endDate <= ?)";
        int count = entityManager.createQuery(hql)
                .setParameter(1, start).setParameter(2, start)
                .setParameter(3, end).setParameter(4, end)
                .setParameter(5, start).setParameter(6, end)
                .getResultList().size();
        return count > 0 ? true : false;
    }
}
