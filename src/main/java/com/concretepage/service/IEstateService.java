package com.concretepage.service;
import java.util.List;

import com.concretepage.entity.Estate;

public interface IEstateService {
    List<Estate> getAllEstates();

    List<Estate> getAllEstatesPaged(Integer page);

    Estate getEstateById(int estateId);

    boolean addEstate(Estate estate);

    void updateEstate(Estate estate);

    void deleteEstate(int estateId);

    List<Estate> searchEstatePaged(String place, String startDate, String endDate,String type,Float price,Boolean wifi,Boolean heating,Boolean aircondition,Boolean kitchen,Boolean parking,Boolean elevator);

    int getCount();

    List<String> getEstateTypes();
    List<Estate> getAllByUserID(Integer userId);

}