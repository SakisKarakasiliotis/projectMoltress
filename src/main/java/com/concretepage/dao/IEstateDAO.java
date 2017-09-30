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

    List<Estate> searchEstatePaged(Integer page, String place, String startDate, String endDate,String type,Double price,Byte wifi,Byte heating,Byte aircondition,Byte kitchen,Byte parking,Byte elevator);

    int getCount();

    List<String> getEstateTypes();

    List<Estate> getAllByUserID(Integer userId);

}