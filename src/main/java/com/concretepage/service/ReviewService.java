package com.concretepage.service;

import java.util.List;

import com.concretepage.dao.IReviewDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.entity.Review;

public class ReviewService implements IReviewService {

    @Autowired
    private IReviewDAO reviewDAO;

    public List<Review> getAllReviews() {
        return reviewDAO.getAllReviews();
    }

    public List<Review> getAllByUserID(Integer userId) {
        return reviewDAO.getAllByUserID(userId);
    }


    public Review getReviewById(int reviewId) {
        return reviewDAO.getReviewById(reviewId);
    }

    public boolean addReview(Review review) {
        reviewDAO.addReview(review);
        return true;
    }

    public void updateReview(Review review) {
        reviewDAO.updateReview(review);
    }

    public void deleteReview(int reviewId) {
        reviewDAO.deleteReview(reviewId);
    }

    public Double getAverageRating() {
        System.out.println(reviewDAO.getAverageRating());
        return 0.0;
    }

}
