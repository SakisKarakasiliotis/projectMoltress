package com.concretepage.service;
import java.util.List;

import com.concretepage.entity.Estate;

public interface IEstateService {
    List<Estate> getAllEstates();

    Estate getEstateById(int estateId);

    boolean addEstate(Estate estate);

    void updateEstate(Estate estate);

    void deleteEstate(int estateId);
}