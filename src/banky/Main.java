package banky;
import java.sql.SQLException;
import java.util.Scanner;

import accountCreate.NewAccountCreate;
import amountTransfer.AmountTransfer;
import balance.AccountBalance;
import deposit.AmountDeposit;
import withdrawal.Withdrawall;

public class Main {

	public static void main(String[] args) throws SQLException 
	{
		int input;
		while(true)
		{
		Scanner obb=new Scanner(System.in);
		System.out.println();
		System.out.println("1.Create Account    2.Deposit    3.Withdraw    4.Balance    5.Amount-Transfer    6.Exit");
		System.out.println();
		input=obb.nextInt();
		switch(input)
		{
		case 1:
			NewAccountCreate n=new NewAccountCreate();
			n.NAC();
			break;
		case 2:
			AmountDeposit a=new AmountDeposit();
			a.deposit();
			break;
		case 3:
			Withdrawall w=new Withdrawall();
			w.withdraw();
			break;
		case 4:
			AccountBalance b=new AccountBalance();
			b.Balance();
			break;
		case 5:
			AmountTransfer at=new AmountTransfer();
			at.AmountTransfer();
			break;
		case 6:
			System.exit(0);
		}
		}
	}
}
