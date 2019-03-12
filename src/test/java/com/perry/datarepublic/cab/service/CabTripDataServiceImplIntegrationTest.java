package com.perry.datarepublic.cab.service;

import com.perry.datarepublic.cab.model.CabTripData;
import com.perry.datarepublic.cab.repository.CabTripDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CabTripDataServiceImplIntegrationTest {

    @Autowired
    private CabTripDataRepository cabTripDataRepository;


    @Test
    public void should_return_trip_count_of_cab_in_given_day() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date start = formatter.parse("2013-12-31");
        Date end = new Date(start.getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(end);
        c.add(Calendar.DATE, 1);
        end = c.getTime();

        CabTripData cab = new CabTripData();
        cab.setMedallion("123");
        cab.setPickupDatetime(start);
        cabTripDataRepository.save(cab);

        Long totalTrips = cabTripDataRepository.findTripsByIdAndDate("123", start, end);
        assertEquals(new Long(1L), totalTrips);
    }

    @Test
    public void should_return_zero_if_no_trips_of_cab_in_given_day() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date start = formatter.parse("2013-12-31");
        Date end = new Date(start.getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(end);
        c.add(Calendar.DATE, 1);
        end = c.getTime();

        Date beforeDate = new Date(start.getTime());
        c.setTime(beforeDate);
        c.add(Calendar.DATE, -5);
        beforeDate = c.getTime();

        CabTripData cab = new CabTripData();
        cab.setMedallion("123");
        cab.setPickupDatetime(beforeDate);
        cabTripDataRepository.save(cab);

        Long totalTrips = cabTripDataRepository.findTripsByIdAndDate("123", start, end);
        assertEquals(new Long(0), totalTrips);
    }

    @Test
    public void should_return_zero_if_no_trips_of_cabId_in_given_day() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date start = formatter.parse("2013-12-31");
        Date end = new Date(start.getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(end);
        c.add(Calendar.DATE, 1);
        end = c.getTime();

        CabTripData cab = new CabTripData();
        cab.setMedallion("123");
        cab.setPickupDatetime(start);
        cabTripDataRepository.save(cab);

        Long totalTrips = cabTripDataRepository.findTripsByIdAndDate("555", start, end);
        assertEquals(new Long(0L), totalTrips);
    }

}