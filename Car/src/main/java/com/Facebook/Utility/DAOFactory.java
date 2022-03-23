package com.Car.Utility;

import com.Car.dao.CarDAO;
import com.Car.dao.CarDAOInterface;

public class DAOFactory {

	public static CarDAOInterface createObject() {
		// TODO Auto-generated method stub
		return new CarDAO();
	}

}
