package tnhb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Loggedinimp {

	String myUrl ="jdbc:mysql://tnhb-monitor.cnqcnxjoo1nj.us-east-1.rds.amazonaws.com/tnhb_mon";
	    String root="root";
	    String pswd="yazhini1998";
	
	public String Updateloggedin(String username) throws Exception
	{
		
		
			 Connection conc = DriverManager.getConnection(myUrl, root, pswd);
//			 String query = "Update hb.users set loggedin= "+"'"+1+"'" +" where username="+"'"+username+"'";
			 
			 String query =  "UPDATE tnhb_mon.users SET loggedin = CASE loggedin  WHEN "+"'"+0+"'" +" THEN "+"'"+1+"'" +" ELSE "+"'"+2+"'" +" END  where username = "+"'"+username+"'";
			 Statement stm = conc.createStatement();
			 int rset=stm.executeUpdate(query);
			return username;
			 
		
			
	}
	
	public String Updateloggedout(String username) throws Exception
	{
		
		
			 Connection conc = DriverManager.getConnection(myUrl, root, pswd);
			 String query = "Update tnhb_mon.users set loggedin= "+"'"+0+"'" +" where username="+"'"+username+"'";
			 
//			 String query =  "UPDATE hb.users SET loggedin = CASE loggedin  WHEN "+"'"+0+"'" +" THEN "+"'"+1+"'" +" ELSE "+"'"+2+"'" +" END  where username = "+"'"+username+"'";
			 Statement stm = conc.createStatement();
			 int rset=stm.executeUpdate(query);
			return username;
			 
		
			
	}
		
	
	
	

}