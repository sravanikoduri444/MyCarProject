package com.Car.Utility;

import com.Car.service.CarService;
import com.Car.service.CarServiceInterface;

public class ServiceFactory {

	public static CarServiceInterface createObject() {
		
		return new CarService();
	}

}
