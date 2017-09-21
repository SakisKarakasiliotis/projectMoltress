package com.concretepage.dao;

import java.util.List;
import java.sql.Date;

import com.concretepage.entity.Availability;

public interface IAvailabilityDAO {
    List<Availability> getAllAvailabilities();

    Availability getAvailabilityById(int availabilityId);

    void addAvailability(Availability availability);

    void updateAvailability(Availability availability);

    void deleteAvailability(int availabilityId);

    boolean availabilityExists(Integer estateId, Date start, Date end);
}