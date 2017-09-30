package com.concretepage.dao;

import java.util.List;

import com.concretepage.entity.Review;

public interface IReviewDAO {

    List<Review> getAllReviews();

    Review getReviewById(int userId);

    void addReview(Review user);

    void updateReview(Review user);

    void deleteReview(int reviewId);

    boolean reviewExists(String email);

    List<Review> getAllByUserID(Integer userId);

    Double getAverageRating();

}
