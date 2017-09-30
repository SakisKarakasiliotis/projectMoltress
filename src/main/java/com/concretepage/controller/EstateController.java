package com.concretepage.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.concretepage.entity.Estate;
import com.concretepage.service.IEstateService;
import com.concretepage.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.concretepage.service.IUserService;

@CrossOrigin(origins = "http://localhost:8090", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class EstateController {
    @Autowired
    private IEstateService estateService;
    @Autowired
    private IBookingService bookingService;

    @GetMapping("estate/{id}")
    public ResponseEntity<Estate> getEstateById(@PathVariable("id") Integer id) {
        Estate estate = estateService.getEstateById(id);
        return new ResponseEntity<Estate>(estate, HttpStatus.OK);
    }

    @GetMapping("estates")
    public ResponseEntity<List<Estate>> getAllEstates() {
        List<Estate> list = estateService.getAllEstates();
        return new ResponseEntity<List<Estate>>(list, HttpStatus.OK);
    }

    @GetMapping("estates/{page}")
    public ResponseEntity<List<Estate>> getAllEstatesPaged(@PathVariable("page") Integer page) {
        List<Estate> list = estateService.getAllEstatesPaged(page);
        return new ResponseEntity<List<Estate>>(list, HttpStatus.OK);
    }

    @PostMapping("estate")
    public ResponseEntity<Void> addEstate(@RequestBody Estate estate, UriComponentsBuilder builder) {
        boolean flag = estateService.addEstate(estate);
        if (!flag) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/estate/{id}").buildAndExpand(estate.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("estate")
    public ResponseEntity<Estate> updateEstate(@RequestBody Estate estate) {
        estateService.updateEstate(estate);
        return new ResponseEntity<Estate>(estate, HttpStatus.OK);
    }

    @DeleteMapping("estate/{id}")
    public ResponseEntity<Void> deleteEstate(@PathVariable("id") Integer id) {
        estateService.deleteEstate(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("estate/search/{page}/{place}/{startdate}/{enddate}/{type}/{price}/{wifi}/{heating}/{aircondition}/{kitchen}/{parking}/{elevator}")
    public ResponseEntity<List<Estate>> searchEstatesPaged(@PathVariable("page") Integer page, @PathVariable("place") String place, @PathVariable("startdate") String startDate, @PathVariable("enddate") String endDate, @PathVariable("type") String type, @PathVariable("price") Double price, @PathVariable("wifi") Byte wifi, @PathVariable("heating") Byte heating, @PathVariable("aircondition") Byte aircondition, @PathVariable("kitchen") Byte kitchen, @PathVariable("parking") Byte parking, @PathVariable("elevator") Byte elevator) {
        SimpleDateFormat start = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = start.parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
        SimpleDateFormat end = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date2 = null;
        try {
            date2 = end.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date sqlEndDate = new java.sql.Date(date2.getTime());
        bookingService.bookingExists(sqlStartDate, sqlEndDate);
        List<Estate> list = estateService.searchEstatePaged(page, place, startDate, endDate, type, price, wifi, heating, aircondition, kitchen, parking, elevator);
        return new ResponseEntity<List<Estate>>(list, HttpStatus.OK);
    }

    @GetMapping("estate/owner/{id}")
    public ResponseEntity<List<Estate>> getAllByOwnerID(@PathVariable("id") Integer id) {
        List<Estate> list = estateService.getAllByUserID(id);
        return new ResponseEntity<List<Estate>>(list, HttpStatus.OK);
    }

    @GetMapping("estate/count")
    public ResponseEntity<Integer> countEstates() {

        return new ResponseEntity<Integer>((estateService.getCount() / 10) + 1, HttpStatus.OK);
    }

    @GetMapping("estate/types")
    public ResponseEntity<List<String>> getEstateTypes() {
        return new ResponseEntity<List<String>>(estateService.getEstateTypes(), HttpStatus.OK);
    }

}
