package com.concretepage.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reviews {
    private int id;
    private Integer userId;
    private Integer estateId;
    private Double rating;
    private String description;
    private Integer bookingId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_ID", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "estate_ID", nullable = true)
    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    @Basic
    @Column(name = "rating", nullable = true, precision = 0)
    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "booking_ID", nullable = true)
    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reviews reviews = (Reviews) o;

        if (id != reviews.id) return false;
        if (userId != null ? !userId.equals(reviews.userId) : reviews.userId != null) return false;
        if (estateId != null ? !estateId.equals(reviews.estateId) : reviews.estateId != null) return false;
        if (rating != null ? !rating.equals(reviews.rating) : reviews.rating != null) return false;
        if (description != null ? !description.equals(reviews.description) : reviews.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (estateId != null ? estateId.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
