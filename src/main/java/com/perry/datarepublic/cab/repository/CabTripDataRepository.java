package com.perry.datarepublic.cab.repository;

import com.perry.datarepublic.cab.model.CabTripData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface CabTripDataRepository extends JpaRepository<CabTripData, Integer> {
    @Query(value = "SELECT count(c.medallion) FROM CabTripData c WHERE c.medallion = :id AND (c.pickupDatetime between :start AND :end)")
    Long findTripsByIdAndDate(@Param("id") String id, @Param("start") Date start, @Param("end") Date end);
}
