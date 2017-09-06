package com.concretepage.dao;

import java.util.List;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Availability;

@Transactional
@Repository
public class AvailabilityDAO implements IAvailabilityDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Availability getAvailabilityById(int availabilityId) {
        return entityManager.find(Availability.class, availabilityId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Availability> getAllAvailabilities() {
        String hql = "FROM Availability as avlb ORDER BY avlb.id";
        return (List<Availability>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addAvailability(Availability availability) {
        entityManager.persist(availability);
    }

    @Override
    public void updateAvailability(Availability availability) {
        Availability avlb = getAvailabilityById(availability.getId());
        if (availability.getStartDate() != null) {
            avlb.setStartDate(availability.getStartDate());
        }
        if (availability.getEndDate() != null) {

            avlb.setEndDate(availability.getEndDate());
        }
        if (availability.getPrice() != null) {
            avlb.setPrice(availability.getPrice());
        }
        if (availability.getEstateId() != null) {
            avlb.setEstateId(availability.getEstateId());
        }
        if (availability.getAvailable() != null) {
            avlb.setAvailable(availability.getAvailable());
        }

        entityManager.flush();
    }

    @Override
    public void deleteAvailability(int availabilityId) {
        entityManager.remove(getAvailabilityById(availabilityId));
    }

    //TODO: needs datespan intersection
    @Override
    public boolean availabilityExists(Date start, Date end) {
        String hql =
                "FROM Availability as avlb WHERE " +
                        "(avlb.startDate <= ? AND avlb.endDate >= ?) OR " +
                        "(avlb.startDate <= ? AND avlb.endDate >= ?) OR " +
                        "(avlb.startDate >= ? AND avlb.endDate <= ?)";
        int count = entityManager.createQuery(hql)
                .setParameter(1, start).setParameter(2, start)
                .setParameter(3, end).setParameter(4, end)
                .setParameter(5, start).setParameter(6, end)
                .getResultList().size();
        return count > 0 ? true : false;
    }
}
