package com.concretepage.dao;

import java.util.List;

import com.concretepage.entity.Estate;


public interface IEstateDAO {

    List<Estate> getAllEstates();

    Estate getEstateById(int estateId);

    void addEstate(Estate estate);

    void updateEstate(Estate estate);

    void deleteEstate(int estateId);

}