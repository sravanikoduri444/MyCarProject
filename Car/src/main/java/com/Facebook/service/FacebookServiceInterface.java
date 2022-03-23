package com.Car.service;

import java.util.ArrayList;
import java.util.List;

import com.Car.entity.CarUser;
import com.Car.entity.CarUser;

public interface CarServiceInterface {

	//int createProfile(CarUser cu);

	//ArrayList<CarUser> viewAllProfileService();

	CarUser viewProfileService(CarUser fu);

	int editProfileService(CarUser fu, CarUser fu1);

	int deleteProfileService(CarUser fu);
	ArrayList<CarUser> searchProfileService(CarUser fu);

	ArrayList<CarUser> sortProfileService(CarUser fu);

	int createProfileService(CarUser cu);

	CarUser signinProfileService(CarUser fu);


	ArrayList<CarUser> viewAllProfileService();

	
}
