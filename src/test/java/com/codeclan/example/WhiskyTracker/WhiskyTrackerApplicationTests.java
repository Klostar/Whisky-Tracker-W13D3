package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getAllWhiskyOfAYear(){
		List<Whisky> results = whiskyRepository.getAllWhiskyFromParticularYear(1991);

	}

	@Test
	public void getAllWhiskyFromRegion(){
		List<Whisky> results = whiskyRepository.getAllWhiskyFromRegion("Highland");
	}


	@Test
	public void  getAllDistilleryFromRegion(){
		List<Distillery> results = distilleryRepository.getAllDistilleryFromRegion("Highland");
	}

	@Test
	public void getAllWhiskyByDistileryByAge(){
		List<Whisky> results = whiskyRepository.getAllWhiskyByDistileryByAge(1L, 15);
	}
}
