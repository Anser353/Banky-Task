package deposit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import connection.CreateConnection;

public class AmountDeposit extends CreateConnection
{
	Connection c;
	Scanner obb=new Scanner(System.in);
	Scanner ob=new Scanner(System.in);

	public void deposit() throws SQLException
	{
		int a,am;
		String qry;
		c=getConnection();
		Statement st=c.createStatement();
		ResultSet rs;
		PreparedStatement ps;
		
		System.out.println("=== Amount Deposit ===");
		System.out.println("Enter Account No:");
		a=ob.nextInt();
		qry="select *from existingcustomer;";
		rs=st.executeQuery(qry);
		while(rs.next())
		{
			if(a==rs.getInt(1))
			{
				System.out.println("Account Holder Name: "+rs.getString(2));
			}
				
		}
		
		System.out.println("Enter Deposit Amount:");
		am=ob.nextInt();
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println("Your Deposit of Rs."+am+" is Successfull");
		System.out.println("-------------------------------------------");
		qry="update existingcustomer set deposit=? where accountno=?;";
		ps=c.prepareStatement(qry);
		ps.setInt(1, am);
		ps.setInt(2, a);
		ps.executeUpdate();
		
	}
}
