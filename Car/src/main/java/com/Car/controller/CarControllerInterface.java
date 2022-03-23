package com.Car.controller;

import java.util.ArrayList;

import com.Car.entity.CarUser;

public interface CarControllerInterface {
	int createProfileController();
	ArrayList<CarUser> viewAllProfileController();
	int deleteProfileController();
	CarUser viewProfileController();
	ArrayList<CarUser> searchProfileController();
	int editProfileController();
	//void SortProfile();
	ArrayList<CarUser> SortProfileController();
	CarUser signinProfileController();
	
}