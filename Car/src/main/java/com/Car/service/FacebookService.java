package com.Car.service;
import java.util.ArrayList;
import java.util.List;
import com.Car.Utility.DAOFactory;
import com.Car.dao.CarDAOInterface;
import com.Car.entity.CarUser;
public class CarService implements CarServiceInterface {
    CarDAOInterface cd = null;
    public CarService()
    {
    	cd=DAOFactory.createObject();
    }
	public int createProfileService(CarUser fu) {
		int i = cd.createProfileDAO(fu);
		return i;
		
	}
	@Override
	public CarUser viewProfileService(CarUser fu) {
		CarUser user = cd.viewProfileDAO(fu);
		return user;
	}
	@Override
	public int deleteProfileService(CarUser fu) {
		int i = cd.deleteProfileDAO(fu);
		return i;
	}
	@Override
	public ArrayList<CarUser> searchProfileService(CarUser fu) {
		ArrayList<CarUser> lis = cd.searchProfileDAO(fu);
		return lis;
	}
	@Override
	public int editProfileService(CarUser fu, CarUser fu1) {
		int i = cd.editProfileDAO(fu, fu1);
		return i;
	}
	@Override
	public ArrayList<CarUser> sortProfileService(CarUser fu) {
		ArrayList<CarUser> lis = cd.sortProfileDAO(fu);
		return lis;
	}
	@Override
	public CarUser signinProfileService(CarUser fu) {
		CarUser a = cd.viewProfileDAO(fu);
		return a;	
	}
	
	public ArrayList<CarUser> viewAllProfileService() {
		ArrayList<CarUser> lis = cd.viewAllProfileDAO();
		return lis;
	}
		
 
}
