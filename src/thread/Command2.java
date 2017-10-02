package thread;

import java.util.Scanner;

public class Command2 {
public static void main(String args[]) {
Scanner input = new Scanner(System.in);
double balance;
double[] deposit = new double[2];
double[] withdraw = new double[2];
System.out.print("Enter your balance: ");
balance = input.nextDouble();
System.out.print("Enter your cash to deposit1: ");
deposit[0] = input.nextDouble();
System.out.print("Enter your cash to deposit2: ");
deposit[1] = input.nextDouble();
System.out.print("Enter your cash to withdraw1: ");
withdraw[0] = input.nextDouble();
System.out.print("Enter your cash to withdraw2: ");
withdraw[1] = input.nextDouble();
MAcc account = new MAcc(balance=0);
ProcessThread1 a = new ProcessThread1(deposit, 1, account); 
ProcessThread1 b = new ProcessThread1(withdraw, 2, account);
a.start();
b.start();
}
}

class MAcc {
	double balance;
	double deposit,withdraw;
	
public MAcc(double balance) { 
	this.balance = balance;
}


public synchronized void process1(double[] amount, int type) {
for(int i=0; i<amount.length; i++) {
	 if(type == 1) {
			balance = balance + amount[i];
			System.out.printf("\nBalance 1 (Deposit) : %.2f",balance);    
		 }else if(type == 2){
			 if(balance > amount[i]){
				 balance = balance - amount[i]; 
				 System.out.printf("\nBalance 2 (Withdraw) : %.2f",balance); 
			 }else{
				 System.out.printf("\nBalance is not enough to withdraw!!!");
			 }
		}      
//code: type 1 = deposit, type 2 = withdraw;
	deposit =  balance + amount[i];
	withdraw = balance  - amount[i];
try { Thread.sleep(2);
} catch (InterruptedException ie) {}

}
}


public void process(double[] amount, int type) {
	for(int i=0; i<amount.length; i++) {
		//code: type 1 = deposit, type 2 = withdraw;
		 if(type == 1) {
				balance = balance + amount[i];
				System.out.printf("\nBalance 1 (Deposit) : %.2f",balance);    
			 }else if(type == 2){
				 if(balance > amount[i]){
					 balance = balance - amount[i]; 
					 System.out.printf("\nBalance 2 (Withdraw) : %.2f",balance); 
				 }else{
					 System.out.printf("\nBalance is not enough to withdraw!!!");
				 }
			}      
	try { Thread.sleep(2);
	} catch (InterruptedException ie) {}
	
	}
}
}
class ProcessThread1 extends Thread {
	double amount[];
	int type;
	MAcc account;
	double[] balance;
public ProcessThread1(double amount[], int type, MAcc account){
	this.amount = amount;
	this.type = type;
	this.account = account;
	}


public void run() {
account.process1(amount,type);



}
}

