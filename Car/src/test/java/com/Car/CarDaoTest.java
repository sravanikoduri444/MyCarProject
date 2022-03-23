package com.Car;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.Car.dao.CarDAO;
import com.Car.dao.CarDAOInterface;
import com.Car.entity.CarUser;

public class CarDaoTest {
    CarDAOInterface cd = null;
	@Before
	public void setUp() throws Exception {
		cd = new CarDAO();
	}

	@After
	public void tearDown() throws Exception {
		cd=null;
	}

	@Test
	public void testCreateProfileDAO() {
		System.out.println("CREATING PROFILE DAO TEST");
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
		int i = cd.createProfileDAO(cu);
		assert i>0:"Test failed to create profile";
	}

	@Test
	public void testViewAllProfileDAO() {
		
		System.out.println("VIEW ALL PROFILE SERVICE TEST");
        ArrayList<CarUser> lis =cd.viewAllProfileDAO();
        assert lis!= null: "Test failed to view all profiles";
	}

	@Test
	public void testViewProfileDAO() {
		System.out.println("VIEWING PROFILE DAO TEST");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the email whose profile you wish to view : ");
        String email = sc.next();
		CarUser fu = new CarUser();
		fu.setEmail(email);
		CarUser user = cd.viewProfileDAO(fu);
		assert user != null: "Test failed to view profile";
	}

	@Test
	public void testEditProfileDAO() {
		System.out.println("EDITING PROFILE DAOTEST");
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
		int i = cd.editProfileDAO(fu, fu1);
		assert i>0: "Test failed to edit profile";
	}

	@Test
	public void testDeleteProfileDAO() {
		System.out.println("DELETING PROFILE STEST");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the email whose profile you wish to delete : ");
		String email = s.next();
		System.out.println();
		
		CarUser fu = new CarUser();
		fu.setEmail(email);
		
		int i = cd.deleteProfileDAO(fu);
		assert i>0: "Test failed to delete profile";
	}

	@Test
	public void testSearchProfileDAO() {
		System.out.println("SEARCHING PROFILE DAO TEST");
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a name you wish to search : ");
		String name = s.next();
		System.out.println();
		
		CarUser fu = new CarUser();
		fu.setName(name);
		
		ArrayList<CarUser> lis = cd.searchProfileDAO(fu);
		assert lis != null: "Test failed to search profile";
	}

	@Test
	public void testSortProfileDAO() {
		System.out.println("SORTING PROFILE DAO TEST");
		Scanner sc = new Scanner(System.in);
		ArrayList<CarUser> lis = new ArrayList<CarUser>();
		CarUser fu = new CarUser();
		lis = cd.sortProfileDAO(fu);
		assert lis != null: "Test failed to search profiles";
	}

	@Test
	public void testSigninProfileDAO() {
		System.out.println("SIGN-IN DAO TEST");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the email to sign-in");
		String email=sc.next();
		System.out.println("Enter the phonenumber to signin");
		String phonenumber = sc.next();
		CarUser fu = new CarUser();
		fu.setEmail(email);
		fu.setphonenumber(phonenumber);
		CarUser user = cd.viewProfileDAO(fu);
		assert user != null: "Test failed to sign-in";
	}

}
