package com.concretepage.controller;

import java.util.List;

import com.concretepage.entity.Availability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.concretepage.service.IAvailabilityService;

@CrossOrigin(origins = "http://localhost:8090", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class AvailabilityController {
    @Autowired
    private IAvailabilityService availabilityService;

    @GetMapping("availability/{id}")
    public ResponseEntity<Availability> getAvailabilityById(@PathVariable("id") Integer id) {
        Availability availability = availabilityService.getAvailabilityById(id);
        return new ResponseEntity<Availability>(availability, HttpStatus.OK);
    }

    @GetMapping("availabilities")
    public ResponseEntity<List<Availability>> getAllAvailabilities() {
        List<Availability> list = availabilityService.getAllAvailabilities();
        return new ResponseEntity<List<Availability>>(list, HttpStatus.OK);
    }

    @PostMapping("availability")
    public ResponseEntity<Void> addAvailability(@RequestBody Availability availability, UriComponentsBuilder builder) {
        boolean flag = availabilityService.addAvailability(availability);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/availability/{id}").buildAndExpand(availability.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("availability")
    public ResponseEntity<Availability> updateAvailability(@RequestBody Availability availability) {
        availabilityService.updateAvailability(availability);
        return new ResponseEntity<Availability>(availability, HttpStatus.OK);
    }

    @DeleteMapping("availability/{id}")
    public ResponseEntity<Void> deleteAvailability(@PathVariable("id") Integer id) {
        availabilityService.deleteAvailability(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
