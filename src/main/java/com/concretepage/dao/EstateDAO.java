package com.concretepage.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Estate;

@Transactional
@Repository
public class EstateDAO implements IEstateDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Estate getEstateById(int estateId) {
        return entityManager.find(Estate.class, estateId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Estate> getAllEstates() {
        String hql = "FROM Estate as estt ORDER BY estt.id";
        return (List<Estate>) entityManager.createQuery(hql).getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Estate> getAllEstatesPaged(Integer page) {
        String hql = "FROM Estate as estt ORDER BY estt.id";
        Integer pageSize = 3;
        return (List<Estate>) entityManager.createQuery(hql)
                .setMaxResults(pageSize)
                .setFirstResult((page - 1) * pageSize)
                .getResultList();
    }

    @Override
    public void addEstate(Estate estate) {
        entityManager.persist(estate);
    }

    @Override
    public void updateEstate(Estate estate) {
        Estate estt = getEstateById(estate.getId());
        if (estate.getOwnerId() != null) {
            estt.setOwnerId(estate.getOwnerId());
        }
        if (estate.getSize() != null) {
            estt.setSize(estate.getSize());
        }
        if (estate.getSize() != null) {
            estt.setSize(estate.getSize());
        }
        if (estate.getLatitude() != null) {
            estt.setLatitude(estate.getLatitude());
        }
        if (estate.getLongitude() != null) {
            estt.setLongitude(estate.getLongitude());
        }
        if (estate.getCountry() != null) {
            estt.setCountry(estate.getCountry());
        }
        if (estate.getCity() != null) {
            estt.setCity(estate.getCity());
        }
        entityManager.flush();
    }

    @Override
    public void deleteEstate(int estateId) {
        entityManager.remove(getEstateById(estateId));
    }

    //here was the exists method may it rests in peace...
    @Override
    public List<Estate> searchEstatePaged(String place, String startDate, String endDate) {
        java.sql.Date sqlStartDate;
        java.sql.Date sqlEndDate;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        long DAY_IN_MS = 1000 * 60 * 60 * 24;

        String hql = "FROM Estate AS estt " +
                ",Availability AS avl " +
                "WHERE " +
                "estt.id = avl.estateId ";
        if (!place.equals("") && place != null) {
            hql += "AND (estt.country LIKE ? OR estt.city LIKE ?)";
        }
        hql += "AND (avl.startDate <= ?)";

        if (startDate != null && !startDate.equals("")  ) {
            java.util.Date utilDate = new java.util.Date();
            try {
                utilDate = formatter.parse(startDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            sqlStartDate = new java.sql.Date(utilDate.getTime());
        } else {
            java.util.Date utilDate = new java.util.Date();
            sqlStartDate = new java.sql.Date(utilDate.getTime());
        }
        hql += "AND (avl.endDate >= ?)";

        if (endDate != null && !endDate.equals("") ) {
            java.util.Date utilDate = new java.util.Date();
            try {
                utilDate = formatter.parse(endDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            sqlEndDate = new java.sql.Date(utilDate.getTime());
        } else {
            java.util.Date utilDate = new java.util.Date();
            sqlEndDate = new java.sql.Date(utilDate.getTime() + (1 * DAY_IN_MS));
        }

        return (List<Estate>) entityManager.createQuery(hql)
                .setParameter(1, place)
                .setParameter(2, place)
                .setParameter(3, sqlStartDate)
                .setParameter(4, sqlEndDate)
                .getResultList();
    }
}