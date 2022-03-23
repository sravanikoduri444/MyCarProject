package com.Car;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.Car.controller.CarController;
import com.Car.controller.CarControllerInterface;
import com.Car.entity.CarUser;

public class ControllerTest {
    CarControllerInterface cc= null;
	@Before
	public void setUp() throws Exception {
		cc= new CarController();
	}

	@After
	public void tearDown() throws Exception {
		cc=null;
	}
	

	@Test
	public void testCreateProfileController() {
	int i = cc.createProfileController();
	assert i>0:"Fail to create profile";
	}

	@Test
	public void testViewAllProfileController() {
		ArrayList<CarUser> lis = cc.viewAllProfileController();
		assert lis!= null: "Test failed to view all profiles";
	}

	@Test
	public void testViewProfileController() {
		CarUser user = cc.viewProfileController();
		assert user!= null:"test failed to view profile";
		
	}

	@Test
	public void testEditProfileController() {
		int i  = cc.editProfileController();
		assert i>0: "Test failed to view profile";
	}

	@Test
	public void testDeleteProfileController() {
		int i = cc.deleteProfileController();
		assert i>0: "Test failed to delete profile";
		
	}

	@Test
	public void testSearchProfileController() {
		ArrayList<CarUser> lis = cc.searchProfileController();
		assert lis != null: "Test failed to search profiles";
	}

	@Test
	public void testSortProfileController() {
		ArrayList<CarUser> lis = cc.SortProfileController();
		assert lis != null: "Test failed to search profiles";

	}

}
