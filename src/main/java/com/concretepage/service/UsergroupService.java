package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.IUsergroupDAO;
import com.concretepage.entity.Usergroup;

@Service
public class UsergroupService implements IUsergroupService {
    @Autowired
    private IUsergroupDAO usergroupDAO;

    @Override
    public Usergroup getUsergroupById(int usergroupId) {
        Usergroup obj = usergroupDAO.getUsergroupById(usergroupId);
        return obj;
    }

    @Override
    public List<Usergroup> getAllUsergroups() {
        return usergroupDAO.getAllUsergroups();
    }

    @Override
    public synchronized boolean addUsergroup(Usergroup usergroup) {
        if (usergroupDAO.usergroupExists(usergroup.getId())) {
            return false;
        } else {
            usergroupDAO.addUsergroup(usergroup);
            return true;
        }
    }

    @Override
    public void updateUsergroup(Usergroup usergroup) {
        usergroupDAO.updateUsergroup(usergroup);
    }

    @Override
    public void deleteUsergroup(int usergroupId) {
        usergroupDAO.deleteUsergroup(usergroupId);
    }
}
