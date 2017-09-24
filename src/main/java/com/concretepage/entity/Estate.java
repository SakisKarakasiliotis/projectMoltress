package com.concretepage.entity;

import javax.persistence.*;

@Entity
@Table(name = "estates")
public class Estate {
    private int id;
    private Integer ownerId;
    private Double size;
    private String latitude;
    private String longitude;
    private String country;
    private String city;
    private String type;
    private Integer beds;
    private Integer rooms;
    private Integer bathrooms;
    private Byte sittingRoom;
    private String about;
    private Byte wifi;
    private Byte airCondition;
    private Byte heating;
    private Byte kitchen;
    private Byte parking;
    private Integer floor;
    private Integer storeys;
    private Byte elevator;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "owner_ID", nullable = true)
    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "size", nullable = true, precision = 0)
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Basic
    @Column(name = "latitude", nullable = true, length = 45)
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude", nullable = true, length = 45)
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "country", nullable = true, length = 45)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 100)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "beds", nullable = true, length = 100)
    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    @Basic
    @Column(name = "rooms", nullable = true, length = 100)
    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    @Basic
    @Column(name = "bathrooms", nullable = true, length = 100)
    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathroms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    @Basic
    @Column(name = "sitting_room", nullable = true, length = 100)
    public Byte getSittingRoom() { return sittingRoom; }

    public void setSittingRoom(Byte sittingRoom) { this.sittingRoom = sittingRoom; }

    @Basic
    @Column(name = "about", nullable = true, length = 100)
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Basic
    @Column(name = "wifi", nullable = true, length = 100)
    public Byte getWifi() {
        return wifi;
    }

    public void setWifi(Byte wifi) {
        this.wifi = wifi;
    }

    @Basic
    @Column(name = "air_condition", nullable = true, length = 100)
    public Byte getAirCondition() {
        return airCondition;
    }

    public void setAirCondition(Byte airCondition) {
        this.airCondition = airCondition;
    }

    @Basic
    @Column(name = "heating", nullable = true, length = 100)
    public Byte getHeating() {
        return heating;
    }

    public void setHeating(Byte heating) {
        this.heating= heating;
    }

    @Basic
    @Column(name = "kitchen", nullable = true, length = 100)
    public Byte getKitchen() {
        return kitchen;
    }

    public void setKitchen(Byte kitchen) {
        this.kitchen = kitchen;
    }

    @Basic
    @Column(name = "parking", nullable = true, length = 100)
    public Byte getParking() {
        return parking;
    }

    public void setParking(Byte parking) {
        this.parking = parking;
    }

    @Basic
    @Column(name = "floor", nullable = true, length = 100)
    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    @Basic
    @Column(name = "storeys", nullable = true, length = 100)
    public Integer getStoreys() {
        return storeys;
    }

    public void setStoreys(Integer storeys) {
        this.storeys = storeys;
    }

    @Basic
    @Column(name = "elevator", nullable = true, length = 100)
    public Byte getElevator() {
        return elevator;
    }

    public void setAirElevator(Byte elevator) {
        this.elevator = elevator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estate estates = (Estate) o;

        if (id != estates.id) return false;
        if (ownerId != null ? !ownerId.equals(estates.ownerId) : estates.ownerId != null) return false;
        if (size != null ? !size.equals(estates.size) : estates.size != null) return false;
        if (latitude != null ? !latitude.equals(estates.latitude) : estates.latitude != null) return false;
        if (longitude != null ? !longitude.equals(estates.longitude) : estates.longitude != null) return false;
        if (country != null ? !country.equals(estates.country) : estates.country != null) return false;
        if (city != null ? !city.equals(estates.city) : estates.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
