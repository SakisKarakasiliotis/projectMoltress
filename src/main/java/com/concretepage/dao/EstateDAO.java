package com.concretepage.dao;

import java.util.List;

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
                .setFirstResult((page-1)*pageSize)
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
    public void deleteEstate (int estateId) {
        entityManager.remove(getEstateById(estateId));
    }

    //here was the exists method may it rests in peace...
}