package com.perry.datarepublic.cab.service;


import java.util.Date;

public interface CabTripDataService {

    public Long findTripsByIdAndDate(String id, Date start, Date end);

    public void evictCache();
}
