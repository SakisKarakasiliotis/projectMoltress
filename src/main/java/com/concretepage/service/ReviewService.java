package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.IReviewDAO;
import com.concretepage.entity.Review;

@Service
public class ReviewService implements IReviewService {

    @Autowired
    private IReviewDAO reviewDAO;

    @Override
    public List<Review> getAllReviews() {
        return reviewDAO.getAllReviews();
    }

    @Override
    public List<Review> getAllByUserID(Integer userId) {
        return reviewDAO.getAllByUserID(userId);
    }

    @Override
    public Review getReviewById(int reviewId) {
        return reviewDAO.getReviewById(reviewId);
    }

    @Override
    public boolean addReview(Review review) {
        reviewDAO.addReview(review);
        return true;
    }

    @Override
    public void updateReview(Review review) {
        reviewDAO.updateReview(review);
    }

    @Override
    public void deleteReview(int reviewId) {
        reviewDAO.deleteReview(reviewId);
    }

    @Override
    public Double getAverageRating() {
        System.out.println(reviewDAO.getAverageRating());
        return 0.0;
    }

}
