package com.perry.datarepublic.cab.controller;


import com.perry.datarepublic.cab.service.CabTripDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CabTripDataController.class)
public class CabTripDataControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CabTripDataService cabTripDataService;

    @Test
    public void should_return_total_trips_of_one_cab() throws Exception {
        when(cabTripDataService.findTripsByIdAndDate(Mockito.anyString(), Mockito.any(), Mockito.any())).thenReturn(300L);

        this.mvc.perform(get("/cab/2013-12-31?id=111"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"111\":300}")));
    }

    @Test
    public void should_return_total_trips_of_multiple_cabs() throws Exception {
        when(cabTripDataService.findTripsByIdAndDate(Mockito.anyString(), Mockito.any(), Mockito.any())).thenReturn(300L);

        this.mvc.perform(get("/cab/2013-12-31?id=111,222"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"111\":300,\"222\":300}")));

        this.mvc.perform(get("/cab/2013-12-31?id=45&id=55"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"55\":300,\"45\":300}")));
    }

    @Test(expected = NestedServletException.class)
    public void should_throw_exception_if_date_is_not_valid_format() throws Exception {
        this.mvc.perform(get("/cab/not-a-date?id=123"));
    }

    @Test
    public void should_return_trips_of_one_cab_fresh_data() throws Exception {
        when(cabTripDataService.findTripsByIdAndDate(Mockito.anyString(), Mockito.any(), Mockito.any())).thenReturn(300L);
        this.mvc.perform(get("/cab/fresh/2013-12-31?id=111"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"111\":300}")));

        verify(cabTripDataService).evictCache();
    }

    @Test
    public void should_clear_cache() throws Exception {
        this.mvc.perform(get("/clear-cache")).andExpect(status().isOk());
        verify(cabTripDataService).evictCache();
    }
}


