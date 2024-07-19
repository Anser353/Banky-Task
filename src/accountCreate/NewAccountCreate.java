package accountCreate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import connection.CreateConnection;

public class NewAccountCreate extends CreateConnection
{
	int pin,a,otp,tp;
	String name,m;
	Connection c;
	Scanner obb=new Scanner(System.in);
	Scanner ob=new Scanner(System.in);

	public void NAC() throws SQLException
	{	
		String qry;
		c=getConnection();
		PreparedStatement ps;
		
		
		System.out.println("Enter Name:");
		name=obb.nextLine();
		System.out.println("Enter Mobile:");
		m=obb.nextLine();
		System.out.println("Enter deposit Amount:");
	a=ob.nextInt();
	System.out.println("Enter Transaction Pin:");
	tp=ob.nextInt();
	
	Random r=new Random();
	int ac=r.nextInt(99999999);
	System.out.println(ac);
	System.out.println("---------------------------------------------------------------------");
	System.out.println("Account Created Successfull");
	System.out.println();
	System.out.println("Your Account No:"+ac);
	System.out.println();
	int d=0,w=0,at=0;

		qry="insert into existingcustomer(accountno,name,mobileno,DepositAmount,tpin,deposit,withdraw,AmountTransfer)values(?,?,?,?,?,?,?,?);";
		ps=c.prepareStatement(qry);
		ps.setInt(1, ac);
		ps.setString(2,name);
		ps.setString(3,m);
		ps.setInt(4, a);
		ps.setInt(5, tp);
		ps.setInt(6, d);
		ps.setInt(7, w);
		ps.setInt(8, at);
		ps.executeUpdate();
		System.out.println("Account Conformation Message Successfully sent to Reg Mobile No! ");
		System.out.println("---------------------------------------------------------------------");
		

	}
	

}
