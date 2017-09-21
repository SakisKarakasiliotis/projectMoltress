package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.IAvailabilityDAO;
import com.concretepage.entity.Availability;

@Service
public class AvailabilityService implements IAvailabilityService {
    @Autowired
    private IAvailabilityDAO availabilityDAO;

    @Override
    public Availability getAvailabilityById(int availabilityId) {
        Availability obj = availabilityDAO.getAvailabilityById(availabilityId);
        return obj;
    }

    @Override
    public List<Availability> getAllAvailabilities() {
        return availabilityDAO.getAllAvailabilities();
    }

    @Override
    public synchronized boolean addAvailability(Availability availability) {
        if (availabilityDAO.availabilityExists(availability.getEstateId(), availability.getStartDate(), availability.getEndDate())) {
            return false;
        } else {
            availabilityDAO.addAvailability(availability);
            return true;
        }
    }

    @Override
    public void updateAvailability(Availability availability) {
        availabilityDAO.updateAvailability(availability);
    }

    @Override
    public void deleteAvailability(int availabilityId) {
        availabilityDAO.deleteAvailability(availabilityId);
    }
}
