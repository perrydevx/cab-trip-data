package com.perry.datarepublic.cab.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="cab_trip_data")
public class CabTripData {

    @Id
    private String medallion;

    @Column(name="hack_license")
    private String hackLicense;

    @Column(name="vendor_id")
    private String vendorId;

    @Column(name="rate_code")
    private Integer rateCode;

    @Column(name="store_and_fwd_flag")
    private String storeAndFwdFlag;

    @Column(name="pickup_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pickupDatetime;

    @Column(name="dropoff_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dropoffDatetime;

    @Column(name="passenger_count")
    private Integer passengerCount;

    @Column(name="trip_time_in_secs")
    private Integer tripTimeInSecs;

    @Column(name="trip_distance")
    private Float tripDistance;

    @Column(name="pickup_longitude")
    private Float pickupLongitude;

    @Column(name="pickup_latitude")
    private Float pickupLatitude;

    @Column(name="dropoff_longitude")
    private Float dropoffLongitude;

    @Column(name="dropoff_latitude")
    private Float dropoffLatitude;

    public String getMedallion() {
        return medallion;
    }

    public void setMedallion(String medallion) {
        this.medallion = medallion;
    }

    public String getHackLicense() {
        return hackLicense;
    }

    public void setHackLicense(String hackLicense) {
        this.hackLicense = hackLicense;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getRateCode() {
        return rateCode;
    }

    public void setRateCode(Integer rateCode) {
        this.rateCode = rateCode;
    }

    public String getStoreAndFwdFlag() {
        return storeAndFwdFlag;
    }

    public void setStoreAndFwdFlag(String storeAndFwdFlag) {
        this.storeAndFwdFlag = storeAndFwdFlag;
    }

    public Date getPickupDatetime() {
        return pickupDatetime;
    }

    public void setPickupDatetime(Date pickupDatetime) {
        this.pickupDatetime = pickupDatetime;
    }

    public Date getDropoffDatetime() {
        return dropoffDatetime;
    }

    public void setDropoffDatetime(Date dropoffDatetime) {
        this.dropoffDatetime = dropoffDatetime;
    }

    public Integer getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(Integer passengerCount) {
        this.passengerCount = passengerCount;
    }

    public Integer getTripTimeInSecs() {
        return tripTimeInSecs;
    }

    public void setTripTimeInSecs(Integer tripTimeInSecs) {
        this.tripTimeInSecs = tripTimeInSecs;
    }

    public Float getTripDistance() {
        return tripDistance;
    }

    public void setTripDistance(Float tripDistance) {
        this.tripDistance = tripDistance;
    }

    public Float getPickupLongitude() {
        return pickupLongitude;
    }

    public void setPickupLongitude(Float pickupLongitude) {
        this.pickupLongitude = pickupLongitude;
    }

    public Float getPickupLatitude() {
        return pickupLatitude;
    }

    public void setPickupLatitude(Float pickupLatitude) {
        this.pickupLatitude = pickupLatitude;
    }

    public Float getDropoffLongitude() {
        return dropoffLongitude;
    }

    public void setDropoffLongitude(Float dropoffLongitude) {
        this.dropoffLongitude = dropoffLongitude;
    }

    public Float getDropoffLatitude() {
        return dropoffLatitude;
    }

    public void setDropoffLatitude(Float dropoffLatitude) {
        this.dropoffLatitude = dropoffLatitude;
    }
}


