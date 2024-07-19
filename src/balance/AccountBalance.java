package balance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import connection.CreateConnection;

public class AccountBalance extends CreateConnection 
{
	Connection c;
	Scanner obb=new Scanner(System.in);
	Scanner ob=new Scanner(System.in);



	public void Balance() throws SQLException
	{
			int a,am,tpin;
			String qry;
			c=getConnection();
			Statement st=c.createStatement();
			ResultSet rs;
			PreparedStatement ps;
			
			System.out.println("=== Balance Checking ===");
			System.out.println("Enter Account No:");
			a=ob.nextInt();
//			qry="select *from existingcustomer;";
//			rs=st.executeQuery(qry);
//			while(rs.next())
//			{
//				if(a==rs.getInt(1))
//				{
//					System.out.println("Account Holder Name: "+rs.getString(2));
//				}
//					
//			}
//			
			System.out.println("Enter tpin tpin:");
			tpin=ob.nextInt();
			qry="select *from existingcustomer;";
			rs=st.executeQuery(qry);
			while(rs.next())
			{
				if(tpin==rs.getInt(4))
				{
					System.out.println("Your Total Balance "+rs.getInt(9));

				}
				
			}
			System.out.println();
	
	}
	}

