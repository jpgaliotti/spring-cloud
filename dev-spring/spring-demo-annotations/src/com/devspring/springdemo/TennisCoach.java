package com.devspring.springdemo;

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
	
	
	// setter/method injection
	/* 
	// define a setter method for injection
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: Inside setFortuneService() method");
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

        System.out.println(">> TennisCoach: inside constructor using @autowired and @qualifier");
        
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
