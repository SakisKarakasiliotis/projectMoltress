package com.concretepage.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Booking {
    private int id;
    private Integer estateId;
    private Date startDate;
    private Date endDate;
    private Integer visitorId;
    private Double totalPrice;
    private Integer persons;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "start_date", nullable = true)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = true)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "visitor_ID", nullable = true)
    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    @Basic
    @Column(name = "total_price", nullable = true, precision = 0)
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "persons", nullable = true)
    public Integer getPersons() {
        return persons;
    }

    public void setPersons(Integer persons) {
        this.persons = persons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking bookings = (Booking) o;

        if (id != bookings.id) return false;
        if (estateId != null ? !estateId.equals(bookings.estateId) : bookings.estateId != null) return false;
        if (startDate != null ? !startDate.equals(bookings.startDate) : bookings.startDate != null) return false;
        if (endDate != null ? !endDate.equals(bookings.endDate) : bookings.endDate != null) return false;
        if (visitorId != null ? !visitorId.equals(bookings.visitorId) : bookings.visitorId != null) return false;
        if (totalPrice != null ? !totalPrice.equals(bookings.totalPrice) : bookings.totalPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (estateId != null ? estateId.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (visitorId != null ? visitorId.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        return result;
    }
}
