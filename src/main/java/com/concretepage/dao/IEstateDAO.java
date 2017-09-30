package com.concretepage.dao;

import java.util.List;

import com.concretepage.entity.Estate;


public interface IEstateDAO {

    List<Estate> getAllEstates();

    List<Estate> getAllEstatesPaged(Integer page);

    Estate getEstateById(int estateId);

    void addEstate(Estate estate);

    void updateEstate(Estate estate);

    void deleteEstate(int estateId);

    List<Estate> searchEstatePaged(String place, String startDate, String endDate);

    int getCount();

    List<String> getEstateTypes();

}