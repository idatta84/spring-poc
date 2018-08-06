package com.springconcepts.designpatterns.singleton;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

//@DependsOn("Configuration")
//@Startup
@Component
//@Singleton
public class SingletonPoolManager {
	
	private static SingletonPoolManager instance;
	

	private SingletonPoolManager(){
		
	}
	
	public static SingletonPoolManager getInstance(){
		if(!Optional.ofNullable(instance).isPresent()){
			instance = new SingletonPoolManager();
		}
		System.out.println(instance.toString()+" | "+instance.hashCode());
		
		return instance;
	}
	
	@PostConstruct
	public void checkInstances(){
		if(Optional.ofNullable(instance).isPresent()){
			System.out.println(instance.toString()+" | "+instance.hashCode());
		}else{
			System.out.println("instance is null");
		}
	}
}
