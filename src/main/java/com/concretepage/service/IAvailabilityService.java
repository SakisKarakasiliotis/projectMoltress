package com.concretepage.service;
import java.sql.Date;
import java.util.List;

import com.concretepage.entity.Availability;

public interface IAvailabilityService {
    List<Availability> getAllAvailabilities();

    Availability getAvailabilityById(int assetId);

    boolean addAvailability(Availability asset);

    void updateAvailability(Availability asset);

    void deleteAvailability(int availabilityId);

    boolean availabilityExists(Integer estateId ,java.sql.Date start, java.sql.Date end);
}
