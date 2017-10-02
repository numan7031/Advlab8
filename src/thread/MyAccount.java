package thread;

import java.util.Scanner;

class MyAccount {
	public static double balance = 0;

	public MyAccount(double balance) {
		MyAccount.balance = balance;
	}

	public synchronized static void process(double[] amount, int type) {
		for (int i = 0; i < amount.length; i++) {
			// code: type 1 = deposit, type 2 = withdraw;
			if (type == 1) {
				balance = balance + amount[i];
				System.out.printf("Balance1 (Deposit): %.2f\n", balance);
			} else {
				if (balance < amount[i]) {
					System.out.printf("Balance is not enough to withdraw!!\n");
				} else {
					balance = balance - amount[i];
					System.out.printf("Balance2 (Withdraw): %.2f\n", balance);
				}
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException ie) {
			}
		}
	}
}

class ProcessThread extends Thread {
	public double amount[];
	int type;
	public MyAccount account;

	public ProcessThread(double amount[], int type, MyAccount account) {
		this.amount = amount;
		this.type = type;
		this.account = account;
	}

	public void run() {
		MyAccount.process(amount, type);
	}
}
