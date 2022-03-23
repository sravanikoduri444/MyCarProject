package com.Car;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.Car.entity.CarUser;
import com.Car.service.CarService;
import com.Car.service.CarServiceInterface;

public class ServiceTest {
	CarServiceInterface cs = null;
	@Before
	public void setUp() throws Exception {
		cs = new CarService();
	}
	@After
	public void tearDown() throws Exception {
		cs=null;
	}

	@Test
	public void testCreateProfileService() {
		System.out.println("CREATING PROFILE SERVICE TEST");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		String name = sc.next();
		
		System.out.println("Enter phonenumber");
		String phonenumber = sc.next();
		
		System.out.println("Enter email");
		String email = sc.next();
		
		System.out.println("Enter address");
		String address = sc.next();
		
		CarUser cu = new CarUser();
		cu.setName(name);
		cu.setphonenumber(phonenumber);
		cu.setEmail(email);
		cu.setAddress(address);
		int i = cs.createProfileService(cu);
		assert i>0:"Test failed to create profile";
	}

	@Test
	public void testViewProfileService() {
		System.out.println("VIEWING PROFILE SERVICE TEST");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the email whose profile you wish to view : ");
        String email = sc.next();
		CarUser fu = new CarUser();
		fu.setEmail(email);
		CarUser user = cs.viewProfileService(fu);
		assert user != null: "Test failed to view profile";
	}

	@Test
	public void testDeleteProfileService() {
		System.out.println("DELETING PROFILE SERVICE TEST");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the email whose profile you wish to delete : ");
		String email = s.next();
		System.out.println();
		
		CarUser fu = new CarUser();
		fu.setEmail(email);
		
		int i = cs.deleteProfileService(fu);
		assert i>0: "Test failed to delete profile";
	}

	

	@Test
	public void testSearchProfileService() {
		System.out.println("SEARCHING PROFILE SERVICE TEST");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a name you wish to search : ");
		String name = s.next();
		System.out.println();
		
		CarUser fu = new CarUser();
		fu.setName(name);
		
		ArrayList<CarUser> lis = cs.searchProfileService(fu);
		assert lis != null: "Test failed to search profile";
	}

	@Test
	public void testEditProfileService() {
		System.out.println("EDITING PROFILE SERVICE TEST");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter email whose profile you wish to edit : ");
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
		assert i>0: "Test failed to edit profile";
	}

	@Test
	public void testSortProfileService() {
		System.out.println("SORTING PROFILE SERVICE TEST");
		Scanner sc = new Scanner(System.in);
		ArrayList<CarUser> lis = new ArrayList<CarUser>();
		CarUser fu = new CarUser();
		lis = cs.sortProfileService(fu);
		assert lis != null: "Test failed to search profiles";
	}

	@Test
	public void testSigninProfileService() {
		System.out.println("SIGN-IN SERVICE TEST");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the email to sign-in");
		String email=sc.next();
		System.out.println("Enter the phonenumber to signin");
		String phonenumber = sc.next();
		CarUser fu = new CarUser();
		fu.setEmail(email);
		fu.setphonenumber(phonenumber);
		CarUser user = cs.viewProfileService(fu);
		assert user != null: "Test failed to sign-in";
	}

	@Test
	public void testViewAllProfileService() {
		System.out.println("VIEW ALL PROFILE SERVICE TEST");
         ArrayList<CarUser> lis =cs.viewAllProfileService();
         assert lis!= null: "Test failed to view all profiles";
		
	}

}
