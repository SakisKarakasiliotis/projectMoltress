package com.concretepage.controller;

import com.concretepage.entity.Review;
import com.concretepage.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8090", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class ReviewController{
    @Autowired
    private IReviewService reviewService;

    @GetMapping("review/{id}")
    public ResponseEntity<Review> getEstateById(@PathVariable("id") Integer id) {
        Review review = reviewService.getReviewById(id);
        return new ResponseEntity<Review>(review, HttpStatus.OK);
    }

    @GetMapping("reviews")
    public ResponseEntity<List<Review>> getAllEstates() {
        List<Review> list = reviewService.getAllReviews();
        return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
    }

//    @GetMapping("review/{page}")
//    public ResponseEntity<List<Review>> getAllReviewPaged(@PathVariable("page") Integer page) {
//        List<Review> list = reviewService.getAllReviewsPaged(page);
//        return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
//    }

    @PostMapping("review")
    public ResponseEntity<Void> addReview(@RequestBody Review review, UriComponentsBuilder builder) {
        boolean flag = reviewService.addReview(review);
        if (!flag) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/review/{id}").buildAndExpand(review.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("review")
    public ResponseEntity<Review> updateEstate(@RequestBody Review review) {
        reviewService.updateReview(review);
        return new ResponseEntity<Review>(review, HttpStatus.OK);
    }

    @DeleteMapping("review/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable("id") Integer id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("review/owner/{id}")
    public ResponseEntity<List<Review>> getAllByOwnerID(@PathVariable("id") Integer id) {
        List<Review> list = reviewService.getAllByUserID(id);
        return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
    }
}
