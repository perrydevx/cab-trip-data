package com.perry.datarepublic.cab.service;

import com.perry.datarepublic.cab.repository.CabTripDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@CacheConfig(cacheNames={"cabTrips"})
public class CabTripDataServiceImpl implements CabTripDataService {

    @Autowired
    private CabTripDataRepository cabTripDataRepository;

    @Cacheable
    public Long findTripsByIdAndDate(String id, Date start, Date end) {
        return cabTripDataRepository.findTripsByIdAndDate(id, start, end);
    }

    @CacheEvict(value="cabTrips", allEntries=true)
    public void evictCache() {}


}
