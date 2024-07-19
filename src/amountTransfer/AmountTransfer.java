package amountTransfer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import connection.CreateConnection;

public class AmountTransfer extends CreateConnection
{
	Connection c;
	Scanner obb=new Scanner(System.in);
	Scanner ob=new Scanner(System.in);


	public void AmountTransfer() throws SQLException
	{
		int a,a2,am,tpin;
		String qry;
		c=getConnection();
		Statement st=c.createStatement();
		ResultSet rs;
		PreparedStatement ps;
		
		System.out.println("=== Amount Transfer ===");
		System.out.println("Enter From Account No:");
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
		System.out.println();
		System.out.println("Enter To Account No:");
		a2=ob.nextInt();
		qry="select *from existingcustomer;";
		rs=st.executeQuery(qry);
		while(rs.next())
		{
			if(a2==rs.getInt(1))
			{
				System.out.println("Account Holder Name: "+rs.getString(2));
			}
				
		}		
		System.out.println("Enter Transfer Amount :");
		am=ob.nextInt();
		System.out.println("Enter  tpin:");
		tpin=ob.nextInt();
		qry="select *from existingcustomer;";
		rs=st.executeQuery(qry);
		while(rs.next())
		{
			if(tpin==rs.getInt(4))
			{
				System.out.println("AmountTransfer of Rs."+am+" is Successfull");

			}
							
		}
		System.out.println();
		
		
		qry="update existingcustomer set AmountTransfer=? where accountno=?;";
		ps=c.prepareStatement(qry);
		ps.setInt(1, am);
		ps.setInt(2, a);
		ps.executeUpdate();
	}
}
