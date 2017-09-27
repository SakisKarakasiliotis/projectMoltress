package com.concretepage.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "availabilities")
public class Availability {
    private int id;
    private Date startDate;
    private Date endDate;
    private Integer estateId;
    private Double price;
    private Byte available;
    private Byte allowSmoking;
    private Byte allowPets;
    private Byte allowParties;
    private Integer maxPersons;
    private Integer minDays;
    private Double extraCostPerPerson;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "estate_ID")
    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

//    @Basic
//    @Column(name = "available")
//    public Byte getAvailable() {
//        return available;
//    }

//    public void setAvailable(Byte available) {
//        this.available = available;
//    }

    @Basic
    @Column(name = "allow_smoking")
    public Byte getAllowSmoking() {
        return allowSmoking;
    }

    public void setAllowSmoking(Byte allowSmoking) {
        this.allowSmoking = allowSmoking;
    }

    @Basic
    @Column(name = "allow_pets")
    public Byte getAllowPets() {
        return allowPets;
    }

    public void setAllowPets(Byte allowPets) {
        this.allowPets = allowPets;
    }

    @Basic
    @Column(name = "allow_parties")
    public Byte getAllowParties() {
        return allowParties;
    }

    public void setAllowParties(Byte allowParties) {
        this.allowParties = allowParties;
    }

    @Basic
    @Column(name = "max_persons")
    public Integer getMaxPersons() {
        return maxPersons;
    }

    public void setMaxPersons(Integer maxPersons) {
        this.maxPersons = maxPersons;
    }

    @Basic
    @Column(name = "min_days")
    public Integer getMinDays() {
        return minDays;
    }

    public void setMinDays(Integer minDays) {
        this.minDays = minDays;
    }

    @Basic
    @Column(name = "extra_cost_per_person")
    public Double getExtraCostPerPerson() {
        return extraCostPerPerson;
    }

    public void setExtraCostPerPerson(Double extraCostPerPerson) { this.extraCostPerPerson = extraCostPerPerson; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Availability that = (Availability) o;

        if (id != that.id) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (estateId != null ? !estateId.equals(that.estateId) : that.estateId != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
//        if (available != null ? !available.equals(that.available) : that.available != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (estateId != null ? estateId.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
//        result = 31 * result + (available != null ? available.hashCode() : 0);
        return result;
    }
}
