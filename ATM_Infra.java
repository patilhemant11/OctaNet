import java.util.*;

public class ATM_Infra
 {
     double balance;
     ArrayList<String> transactionHistory;

    public ATM_Infra() 
	{
        balance = 0.0;
        transactionHistory = new ArrayList<>();
    }

    public void displayMenu() 
	{
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
    }

    public void withdraw(double amount) 
	{
        if (amount <= balance) 
		{
            balance -= amount;
            transactionHistory.add("Withdraw: Rs " + amount);
            System.out.println("Withdrawn: Rs " + amount);
			System.out.println("Your current balance: Rs" + balance);
        } 
		else 
		{
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double amount) 
	{
        balance += amount;
        transactionHistory.add("Deposit: Rs " + amount);
        System.out.println("Deposited: Rs " + amount);
		System.out.println("Your current balance: Rs" + balance);
    }

    public void transfer(double amount) 
	{
        if (amount <= balance) 
		{
            balance -= amount;
            transactionHistory.add("Transfer: Rs " + amount);
            System.out.println("Transferred: Rs " + amount);
			System.out.println("Your current balance: Rs" + balance);
        } 
		else 
		{
            System.out.println("Insufficient balance for the transfer.");
        }
    }

    public void showTransactionHistory() 
	{
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) 
		{
            System.out.println(transaction);
			
        }
		System.out.println("Your current balance: Rs" + balance);
    }


    public static void main(String x[]) 
	{
        ATM_Infra atm = new ATM_Infra();
        Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter User ID :>>> ");
        String User = sc.nextLine();
        System.out.print("Enter PIN :>>> ");
        int pin = sc.nextInt(); 
		
		if (User != null && pin == 1234) 
		{
            System.out.println("Login successful.\n Welcome, " + User + "!");
            System.out.println("----------------------");
			while (true) 
			{
				atm.displayMenu();
				System.out.print("Enter your choice: ");
				int choice = sc.nextInt();

				switch (choice) 
					{
						case 1:
							atm.showTransactionHistory();
							break;
						case 2:
							System.out.print("Enter the withdrawal amount: Rs ");
							double withdrawAmount = sc.nextDouble();
							atm.withdraw(withdrawAmount);
							break;
						case 3:
							System.out.print("Enter the deposit amount: Rs ");
							double depositAmount = sc.nextDouble();
							atm.deposit(depositAmount);
							break;
						case 4:
							System.out.print("Enter the transfer amount: Rs ");
							double transferAmount = sc.nextDouble();
							atm.transfer(transferAmount);
							break;
						case 5:
							System.out.println("Thank you for using the ATM. Goodbye!");
							System.exit(0);
						default:
							System.out.println("Invalid choice. Please select a valid option.");
					}
            }
        }
		else 
		{
            System.out.println("Login failed. Please check your User ID and PIN.");
        }
    }
}