package com.Car.view;
import java.util.Scanner;
import com.Car.Utility.ControllerFactory;
import com.Car.controller.CarControllerInterface;
import com.Car.entity.CarUser;
public class CarView {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s ="y";
		while(s.equals("y")) {
			CarControllerInterface ca = ControllerFactory.createObject();
			System.out.println("********MAIN MENU*********");
			System.out.println("Press 1 to sign-in");
			System.out.println("Press 2 to sign-up");
			System.out.println("enter your choice");
		    int a = sc.nextInt();
		    if(a==2) {
		    	System.out.println("*********** Sign-up ***********");
				System.out.println("Press 1 to create profile");
				ca.createProfileController();
		    }
		    else if(a==1){
		    	CarUser cu = ca.signinProfileController();
		    	if (cu != null) {
						System.out.println("*****************Sign-in***************");
						System.out.println("Press 1 to sign in profile");
						System.out.println("press 2 to edit profile");
						System.out.println("press 3 to delete profile");
						System.out.println("press 4 to view profile");
						System.out.println("press 5 to search profile");
						System.out.println("Press 6 to sorting order");
						System.out.println("Press 7 to viewALL profile");
						System.out.print("Enter your choice : ");
						int ch = sc.nextInt();
						switch(ch)
						{
						case 1: ca.signinProfileController();
						break;
						case 2:ca.editProfileController();
							break;
						case 3: ca.deleteProfileController();
						break;
						case 4: ca.viewProfileController();
						break;
						case 5: ca.searchProfileController();
						break;
						case 6:
							ca.SortProfileController();
							break;
						case 7:
							ca.viewAllProfileController();
							break;
						default:System.out.println("wrong choice");
						}
					}
		    	else {
		    		System.out.println("Not registered");
		    	}
						
					System.out.print("Do you wish to continue (y/n) : ");
					s=sc.next();
		    }
		}
	}
		
	}
