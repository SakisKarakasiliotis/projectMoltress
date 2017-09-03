package com.concretepage.dao;

import com.concretepage.entity.Usergroup;

import java.util.List;

public interface IUsergroupDAO {
    List<Usergroup> getAllUsergroups();

    Usergroup getUsergroupById(int usergroupId);

    void addUsergroup(Usergroup usergroup);

    void updateUsergroup(Usergroup usergroup);

    void deleteUsergroup(int usergroupId);

    boolean usergroupExists(int usergroupId);
}
