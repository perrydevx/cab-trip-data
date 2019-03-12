package com.perry.datarepublic.cab;
import static org.assertj.core.api.Assertions.assertThat;
import com.perry.datarepublic.cab.controller.CabTripDataController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CabApplicationTests {

	@Autowired
	private CabTripDataController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
