package com.concretepage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Review;

public class ReviewDAO implements IReviewDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Review getReviewById(int reviewId) {
        return entityManager.find(Review.class, reviewId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Review> getAllReviews() {
        String hql = "FROM Review as usr ORDER BY usr.id";
        return (List<Review>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Review> getAllByUserID(Integer userId) {
        String hql = "FROM Review as rvw WHERE rvw.userId = ?";
        return entityManager.createQuery(hql).setParameter(1, userId).getResultList();
    }


    @Override
    public void addReview(Review review) {

        entityManager.persist(review);
    }

    @Override
    public void updateReview(Review review) {
        Review usr = getReviewById(review.getId());


        entityManager.flush();
    }

    @Override
    public void deleteReview(int reviewId) {
        entityManager.remove(getReviewById(reviewId));
    }

    @Override
    public boolean reviewExists(String email) {
        String hql = "FROM Review as usr WHERE usr.email = ?";
        int count = entityManager.createQuery(hql).setParameter(1, email).getResultList().size();
        return count > 0 ? true : false;
    }

    public Double getAverageRating() {
        String hql = "SELECT avg(rvw.rating) FROM Review as rvw";
        Query query = entityManager.createQuery(hql);
        List list = query.getResultList();
        return (Double) list.get(0);
    }


}
