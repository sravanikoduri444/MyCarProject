package com.Car.dao;

import java.util.ArrayList;
import java.util.List;
import com.Car.entity.CarUser;
public interface CarDAOInterface {
	int createProfileDAO(CarUser cu);
	ArrayList<CarUser> viewAllProfileDAO();
	CarUser viewProfileDAO(CarUser fu);
	int editProfileDAO(CarUser fu, CarUser fu1);
	int deleteProfileDAO(CarUser fu);
	ArrayList<CarUser> searchProfileDAO(CarUser fu);
	ArrayList<CarUser> sortProfileDAO(CarUser fu);
	CarUser signinProfileDAO(CarUser fu);

}
