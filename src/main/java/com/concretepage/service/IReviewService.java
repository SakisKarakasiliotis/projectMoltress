package com.concretepage.service;
import java.util.List;

import com.concretepage.entity.Review;

public interface IReviewService {
    List<Review> getAllReviews();

    List<Review> getAllByUserID(Integer userId);

    Review getReviewById(int reviewId);

    boolean addReview(Review review);

    void updateReview(Review review);

    void deleteReview(int reviewId);

    Double getAverageRating();

}