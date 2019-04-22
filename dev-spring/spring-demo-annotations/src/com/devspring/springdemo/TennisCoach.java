package com.devspring.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	// field injection
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// define default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: Inside default constructor");
	}
	
	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: Inside of doMyStartupStuff() method");
	}
	
	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: Inside of doMyCleanupStuff() method");
	}
	
	// setter/method injection
	/* 
	// define a setter method for injection
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		fortuneService=theFortuneService;
	}
	*/
	
	// constructor injection
	/*
	@Autowired
	public TennisCoach (FortuneService theFortuneService) {
		fortuneService=theFortuneService;
	}
	*/
	
	// constructor injection with @Qualifier
	/*
	@Autowired
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }
	*/
	
	@Override
	public String getDailyWorkout() {

		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

}
