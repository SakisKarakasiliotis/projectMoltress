package com.concretepage.service;
import java.util.List;

import com.concretepage.entity.Usergroup;

public interface IUsergroupService {
    List<Usergroup> getAllUsergroups();

    Usergroup getUsergroupById(int usergroupId);

    boolean addUsergroup(Usergroup usergroup);

    void updateUsergroup(Usergroup usergroup);

    void deleteUsergroup(int usergroupId);
}
