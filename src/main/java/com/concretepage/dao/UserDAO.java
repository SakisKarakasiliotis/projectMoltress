package com.concretepage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.User;

@Transactional
@Repository
public class UserDAO implements IUserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserById(int userId) {
        return entityManager.find(User.class, userId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() {
        String hql = "FROM User as usr ORDER BY usr.id";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        User usr = getUserById(user.getId());
        if (user.getEmail() != null) {
            usr.setEmail(user.getEmail());
        }
        if (user.getFullName() != null) {

            usr.setFullName(user.getFullName());
        }
        if (user.getPhoneNo() != null) {
            usr.setPhoneNo(user.getPhoneNo());
        }
        if (user.getUserGroupId() != null) {
            usr.setUserGroupId(user.getUserGroupId());
        }
        if (user.getPassword() != null) {
            usr.setPassword(user.getPassword());
        }

        entityManager.flush();
    }

    @Override
    public void deleteUser(int userId) {
        entityManager.remove(getUserById(userId));
    }

    @Override
    public boolean userExists(String email) {
        String hql = "FROM User as usr WHERE usr.email = ?";
        int count = entityManager.createQuery(hql).setParameter(1, email).getResultList().size();
        return count > 0 ? true : false;
    }

    @Override
    public User getUserByEmail(String email) {
        User usr = new User();
        String hql = "FROM User as usr WHERE usr.email = ?";
        List<User> userList = entityManager.createQuery(hql).setParameter(1, email).getResultList();
        if (userList.size() > 0) {
            usr = userList.get(0);
        }
        return usr;
    }

}
