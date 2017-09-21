package com.concretepage.controller;

import java.util.List;

import com.concretepage.entity.Estate;
import com.concretepage.service.IEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;
import com.concretepage.service.IUserService;

@Controller
@RequestMapping("/")
public class EstateController {
    @Autowired
    private IEstateService estateService;

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
        if (flag == false) {
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

    @PostMapping("estate/search")
    public ResponseEntity<List<Estate>> searchEstatesPaged(String place, String startDate, String endDate){
        List<Estate> list = estateService.searchEstatePaged(place, startDate, endDate);
        return new ResponseEntity<List<Estate>>(list, HttpStatus.OK);
    }

}
