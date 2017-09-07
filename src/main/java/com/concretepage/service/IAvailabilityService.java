package com.concretepage.service;
import java.util.List;

import com.concretepage.entity.Availability;

public interface IAvailabilityService {
    List<Availability> getAllAvailabilities();

    Availability getAvailabilityById(int assetId);

    boolean addAvailability(Availability asset);

    void updateAvailability(Availability asset);

    void deleteAvailability(int availabilityId);
}
