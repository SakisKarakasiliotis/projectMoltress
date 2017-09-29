package com.concretepage.controller;

import java.util.List;

import com.concretepage.entity.User;
import com.concretepage.entity.Estate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.mindrot.jbcrypt.*;
import com.concretepage.service.IUserService;
import com.concretepage.service.IEstateService;
import com.concretepage.service.IReviewService;

@CrossOrigin(origins = "http://localhost:8090", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    private IUserService userService;
    private IEstateService estateService;
    private IReviewService reviewService;

    @GetMapping("user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAllUsers();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }

    @PostMapping("user")
    public ResponseEntity<User> addUser(@RequestBody User user, UriComponentsBuilder builder) {
        user.setUserGroupId(3);

        boolean flag = userService.addUser(user);
        if (flag == false) {
            return new ResponseEntity<User>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @PutMapping("user")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("user/{email}/{password}")
    public ResponseEntity<User> loginUser( @PathVariable("email") String email, @PathVariable("password") String password){
        User usr = userService.getUserByEmail(email);

        if (usr.getPassword()!= null && BCrypt.checkpw(password, usr.getPassword())) {
            return new ResponseEntity<>(usr, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>( HttpStatus.FORBIDDEN);
        }

    }

    @GetMapping("user/recomend/{id}")
    public ResponseEntity<Estate> recomendEstate(@PathVariable("id") Integer id){
        List<User> users = userService.getAllUsers();
        Integer totalEstates = estateService.getCount(); //needs to be implemented

        Integer[][] ratingsVectors = new Integer[users.size()][totalEstates];
        Integer avg = 0;//should have a value but i need to know if value was 0 or not

        for (User usr : users) {
            List<Review> reviews = reviewService.getAllByUserID(id); //needs to be implemented
            for (int i=0;i<totalEstates;i++){
                for (Review r: reviews ) {
                    if(r.getEstateID()== i){
                        ratingsVectors[usr.id][i]=r.getRating();
                    }
                }
                if(ratingVector[i]== null){//todo: MORE FIXES
                    ratingVector[i]==avg;
                }
            }
        }

        //we have to cosine similarity the shit out of this

        for(int i=0 ; i< users.size();i++){
            if(i == id){
                continue;
            }
            double similarity;
            double dotProduct = 0.0;
            double normA = 0.0;
            double normB = 0.0;
            for (int j = 0; j < totalEstates; j++) {
                dotProduct += ratingsVectors[id][j] * ratingsVectors[i][j];
                normA += Math.pow(ratingsVectors[id][j], 2);
                normB += Math.pow(ratingsVectors[i][j], 2);
            }
            similarity = dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
            if(similarity > 0.7 ){
                for(int k ; k<totalEstates;k++){
                    if(ratingsVectors[i][k]>6 && ratingsVectors[id][k]== 0){
                        return  new ResponseEntity<Estate>(estateService.getEstateById(k),HttpStatus.OK);
                    }
                }
            }
        }


        return new ResponseEntity<Estate>(estateService.getEstateById(totalEstates-1),HttpStatus.OK);
    }
}
