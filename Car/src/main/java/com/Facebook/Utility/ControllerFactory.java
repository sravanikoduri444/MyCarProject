package com.Car.Utility;

import com.Car.controller.CarController;
import com.Car.controller.CarControllerInterface;

public class ControllerFactory {

	public static CarControllerInterface createObject() {
		
		return new CarController();
	}

}
