package com.Car.controller;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.Car.Utility.ServiceFactory;
import com.Car.Utility.SortByAddress;
import com.Car.Utility.SortByName;
import com.Car.entity.CarUser;
import com.Car.entity.EntityFactory;
//import com.Car.entity.TimelineDetails;
import com.Car.service.CarServiceInterface;

public class CarController implements CarControllerInterface {
	CarServiceInterface cs = null;
	Scanner sc = null;
	Logger log = Logger.getLogger("Car Controller");
	public CarController(){
	sc=new Scanner(System.in);
	 cs = ServiceFactory.createObject();
	}
	public int createProfileController() {
		log.info("inside create profile method of controller");
		Scanner sc = new Scanner(System.in);
		log.info("Enter name");
		String name = sc.next();
		
		log.info("Enter phonenumber");
		String phonenumber = sc.next();
		
		log.info("Enter email");
		String email = sc.next();
		
		log.info("Enter address");
		String address = sc.next();
		
		CarUser cu = new CarUser();
		cu.setName(name);
		cu.setphonenumber(phonenumber);
		cu.setEmail(email);
		cu.setAddress(address);
		int i = cs.createProfileService(cu);
		if(i>0)
		{
			System.out.println("your profile created");
		}
		else
		{
			System.out.println("could not create profile");
		}
		return i;
		

	}
	public ArrayList<CarUser> viewAllProfileController() {
		//CarServiceInterface as=new AjayService();
		ArrayList<CarUser> lis =cs.viewAllProfileService();
		
		System.out.println(lis.size() + " records found in database");
		
		if(lis.size() > 0) {
			for (CarUser i : lis) {
				System.out.println("*****************************");
				System.out.println("Name is "+i.getName());
				System.out.println("phonenumber is "+i.getphonenumber());
				System.out.println("Email is "+i.getEmail());
				System.out.println("Address is "+i.getAddress());
			}
		}
		else {
			System.out.println("No profiles found in database");
		}
		/*
		ll.forEach(s->{
			System.out.println("********************");
			System.out.println(s.getName());
			System.out.println(s.getphonenumber());
			System.out.println(s.getEmail());
			System.out.println(s.getAddress());
			});
		
		System.out.println("after sorting");
		
		Collections.sort(ll,new SortByAddress());
		ll.forEach(s->{
			System.out.println("********************");
			System.out.println(s.getName());
			System.out.println(s.getphonenumber());
			System.out.println(s.getEmail());
			System.out.println(s.getAddress());
			});
			*/
		return lis;
		
	}
	@Override
	public CarUser viewProfileController() {
		System.out.print("Enter the email whose profile you wish to view : ");
		String email = sc.next();
		
		CarUser fu = new CarUser();
		fu.setEmail(email);
		
		CarUser user = cs.viewProfileService(fu);
		
		if (user != null) {
			System.out.println("Name is " + user.getName());
			System.out.println("phonenumber is " + user.getphonenumber());
			System.out.println("Email is " + user.getEmail());
			System.out.println("Address " + user.getAddress());
		}
		
		else {
			System.out.println("Profile not found");
		}
		return user;
		
		
	}
	@Override
	public int editProfileController() {
		System.out.println("EDITING PROFILE : ");
		
		System.out.print("Enter the email whose profile you wish to edit : ");
		String email = sc.next();
		
		CarUser fu = new CarUser();
		fu.setEmail(email);
		
		System.out.print("Edit name : ");
		String name = sc.next();
		
		System.out.print("Edit phonenumber : ");
		String phonenumber = sc.next();
		
		System.out.print("Edit address : ");
		String address = sc.next();
		
		CarUser fu1 = new CarUser();
		fu1.setName(name);
		fu1.setphonenumber(phonenumber);
		fu1.setAddress(address);
		int i = cs.editProfileService(fu, fu1);
		
		if (i > 0) {
			System.out.println("Profile edited");
			
		}	
		else {
			System.out.println("Could not edit your profile");
			
		}
		
		return i;

	}

	@Override
	public int deleteProfileController() {
		System.out.print("Enter the email whose profile you wish to view : ");
		String email = sc.next();
		
		CarUser fu = new CarUser();
		fu.setEmail(email);
		
		int i = cs.deleteProfileService(fu);
		
		if (i > 0) {
			System.out.println("Profile deleted");
		}
		
		else {
			System.out.println("Could not delete your profile");
		}
		return i;
		
	}
	@Override
	public ArrayList<CarUser> searchProfileController() {
		System.out.print("Enter a name you wish to search : ");
		String name = sc.next();
		
		CarUser fu = new CarUser();
		fu.setName(name);
		
		ArrayList<CarUser> lis = cs.searchProfileService(fu);
		
		if (lis != null) {
			for (CarUser user : lis) {
				System.out.println("-----------------------");
				System.out.println("Name is " + user.getName());
				System.out.println("phonenumber is " + user.getphonenumber());
				System.out.println("Email is " + user.getEmail());
				System.out.println("Address " + user.getAddress());
			}
		}
		else
		{
			System.out.println("Profile not found");
		}
		return lis;
	}
	public ArrayList<CarUser> SortProfileController() {
		System.out.println("SORTING PROFILES BY NAME : ");
		ArrayList<CarUser> lis = new ArrayList<CarUser>();
		CarUser fu = new CarUser();
		
		lis = cs.sortProfileService(fu);
		
		if (lis != null) {
			Collections.sort(lis, new SortByName());
			System.out.println("Profiles in Sorted Order");
			for (CarUser user : lis) {
				System.out.println("^^^^^^^^^^^^^^");
				System.out.println("Name is " + user.getName());
				System.out.println("phonenumber is " + user.getphonenumber());
				System.out.println("Email is " + user.getEmail());
				System.out.println("Address is " + user.getAddress());
			}
			
			
		}
		
		else {
			System.out.println("No profiles found");
			
		}
		
		return lis;
		
	}
	@Override
	public CarUser signinProfileController() {
		System.out.println("Enter the email to signin");
		String email=sc.next();
		System.out.println("Enter the phonenumber to signin");
		String phonenumber = sc.next();
		CarUser fu = new CarUser();
		fu.setEmail(email);
		fu.setphonenumber(phonenumber);
		CarUser user = cs.viewProfileService(fu);
		return user;
	}
}
	