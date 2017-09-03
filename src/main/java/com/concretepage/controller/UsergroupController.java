package com.concretepage.controller;

import java.util.List;

import com.concretepage.entity.Usergroup;
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
import com.concretepage.service.IUsergroupService;

@Controller
@RequestMapping("/")
public class UsergroupController {
    @Autowired
    private IUsergroupService usergroupService;

    @GetMapping("usergroup/{id}")
    public ResponseEntity<Usergroup> getUsergroupById(@PathVariable("id") Integer id) {
        Usergroup usergroup = usergroupService.getUsergroupById(id);
        return new ResponseEntity<Usergroup>(usergroup, HttpStatus.OK);
    }

    @GetMapping("usergroups")
    public ResponseEntity<List<Usergroup>> getAllUsergroups() {
        List<Usergroup> list = usergroupService.getAllUsergroups();
        return new ResponseEntity<List<Usergroup>>(list, HttpStatus.OK);
    }

    @PostMapping("usergroup")
    public ResponseEntity<Void> addUsergroup(@RequestBody Usergroup usergroup, UriComponentsBuilder builder) {
        boolean flag = usergroupService.addUsergroup(usergroup);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/usergroup/{id}").buildAndExpand(usergroup.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("usergroup")
    public ResponseEntity<Usergroup> updateUsergroup(@RequestBody Usergroup usergroup) {
        usergroupService.updateUsergroup(usergroup);
        return new ResponseEntity<Usergroup>(usergroup, HttpStatus.OK);
    }

    @DeleteMapping("usergroup/{id}")
    public ResponseEntity<Void> deleteUsergroup(@PathVariable("id") Integer id) {
        usergroupService.deleteUsergroup(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
