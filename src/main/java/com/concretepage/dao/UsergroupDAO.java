package com.concretepage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Usergroup;

@Transactional
@Repository
public class UsergroupDAO implements IUsergroupDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Usergroup getUsergroupById(int usergroupId) {
        return entityManager.find(Usergroup.class, usergroupId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Usergroup> getAllUsergroups() {
        String hql = "FROM Usergroup as usrgrp ORDER BY usrgrp.id";
        return (List<Usergroup>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addUsergroup(Usergroup usergroup) {
        entityManager.persist(usergroup);
    }

    @Override
    public void updateUsergroup(Usergroup usergroup) {
        Usergroup usr = getUsergroupById(usergroup.getId());
        usr.setName(usergroup.getName());
        usr.setDescription(usergroup.getDescription());

        entityManager.flush();
    }

    @Override
    public void deleteUsergroup(int usergroupId) {
        entityManager.remove(getUsergroupById(usergroupId));
    }

    @Override
    public boolean usergroupExists(int usergroupId) {
        String hql = "FROM Usergroup as usrgrp WHERE usrgrp.id = ?";
        int count = entityManager.createQuery(hql).setParameter(1, usergroupId).getResultList().size();
        return count > 0 ? true : false;
    }
}
