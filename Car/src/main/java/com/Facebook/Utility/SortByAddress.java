package com.Car.Utility;

import java.util.Comparator;

import com.Car.entity.CarUser;

public class SortByAddress implements Comparator<CarUser> {

	@Override
	public int compare(CarUser c1, CarUser c2) {
		// TODO Auto-generated method stub
		return c1.getAddress().compareTo(c2.getAddress());
	}

}
