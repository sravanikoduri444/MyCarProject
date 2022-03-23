package com.Car.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.Car.entity.CarUser;
//import com.Car.entity.TimelineDetails;
public class CarDAO implements CarDAOInterface {
	Connection con=null;
	public CarDAO(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@SravaniSandhya:1521:XE","system","Sravani");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int createProfileDAO(CarUser cu) {
		int i=0;
		try{
			PreparedStatement ps=con.prepareStatement("insert into CarUser values(?,?,?,?)");
			ps.setString(1, cu.getName());
			ps.setString(2, cu.getPassword());
			ps.setString(3,cu.getEmail() );
			ps.setString(4, cu.getAddress());
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public ArrayList<CarUser> viewAllProfileDAO() {
		ArrayList<CarUser> ll = new ArrayList<CarUser>();
		try{
			PreparedStatement ps=con.prepareStatement("select *from CarUser");
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a=res.getString(4);

				CarUser ss=new CarUser();
				ss.setName(n);
				ss.setPassword(p);
				ss.setEmail(e);
				ss.setAddress(a);
				
				ll.add(ss);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ll;
	}
	@Override
	public CarUser viewProfileDAO(CarUser fu) {	
		CarUser user = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from CarUser where email = ?");
			ps.setString(1, fu.getEmail());
			
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a = res.getString(4);
				user = new CarUser();
				user.setName(n);
				user.setPassword(p);
				user.setEmail(e);
				user.setAddress(a);
				
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int editProfileDAO(CarUser fu, CarUser fu1) {
		PreparedStatement ps = null;
		int i = 0;
		
		try {
			 ps = con.prepareStatement("update CarUser set name = ?, password = ?, address = ?  where email = ?");
			ps.setString(1, fu1.getName());
			ps.setString(2, fu1.getPassword());
			ps.setString(3, fu1.getAddress());
			ps.setString(4, fu.getEmail());
			i = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			if(ps!=null) {
					try {
						ps.close();}
			catch (SQLException e) {
					e.printStackTrace();}
				}
			}
		return i;
		
	}

	@Override
	public int deleteProfileDAO(CarUser fu) {
		int i = 0;
		try {
			PreparedStatement ps = con.prepareStatement("delete from CarUser where email = ?");
			ps.setString(1, fu.getEmail());
			i=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			}
		return i;
	}

	@Override
	public ArrayList<CarUser> searchProfileDAO(CarUser fu) {
		ArrayList<CarUser> lis = new ArrayList<CarUser>() ;
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from CarUser where name = ?");
			ps.setString(1, fu.getName());
			
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a = res.getString(4);
				
				CarUser user = new CarUser();
				user.setName(n);
				user.setPassword(p);
				user.setEmail(e);
				user.setAddress(a);
				
				lis.add(user);
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return lis;
	}
	@Override
	public ArrayList<CarUser> sortProfileDAO(CarUser fu) {
		ArrayList<CarUser> lis = new ArrayList<CarUser>();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from CarUser");
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a = res.getString(4);
				
				CarUser user = new CarUser();
				user = new CarUser();
				user.setName(n);
				user.setPassword(p);
				user.setEmail(e);
				
				lis.add(user);
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return lis;
	}
	@Override
	public CarUser signinProfileDAO(CarUser fu) {
    CarUser lis = new CarUser() ;
		try {
			PreparedStatement ps = con.prepareStatement("select * from CarUser where email = ?");
			ps.setString(1, fu.getEmail());
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				//String n = res.getString(1);
				String e = res.getString(2);
				String p = res.getString(3);
				CarUser user = new CarUser();
				user.setEmail(e);
				user.setPassword(p);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return lis;
	}
	
}
	
	

