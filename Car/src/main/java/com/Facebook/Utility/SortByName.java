package com.Car.Utility;

import java.util.Comparator;

import com.Car.entity.CarUser;

public class SortByName implements Comparator <CarUser>{
	@Override
	public int compare(CarUser fu, CarUser fu1) {
		return fu.getName().compareTo(fu1.getName());
	}

}
