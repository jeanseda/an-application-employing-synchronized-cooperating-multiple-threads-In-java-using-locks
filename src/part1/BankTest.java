/*  Name:  Jean Seda
 * Course: CNT 4714 
 * Spring 2021
 * Assignment title: Project2–Synchronized, Cooperating Threads Under Locking
 * Due Date: February 14, 2021 */

package part1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService threads = Executors.newFixedThreadPool(14);
		ABankAccount sharedLocation = new ABankAccount();

		try {
			System.out.println("\tDeposit Threads\t\t\t  Withdrawal Threads\t\t\t\t\t\t    Balance");
			System.out.println("\t-------------\t\t\t  ----------------\t\t\t\t\t\t -------------");
			threads.execute(new Depositor(sharedLocation, "Thread D1"));
			threads.execute(new Withdrawal(sharedLocation, "Thread W1"));
			threads.execute(new Withdrawal(sharedLocation, "Thread W2"));
			threads.execute(new Depositor(sharedLocation, "Thread D2"));
			threads.execute(new Depositor(sharedLocation, "Thread D3"));
			threads.execute(new Depositor(sharedLocation, "Thread D4"));
			threads.execute(new Depositor(sharedLocation, "Thread D5"));
			threads.execute(new Withdrawal(sharedLocation, "Thread W3"));
			threads.execute(new Withdrawal(sharedLocation, "Thread W4"));
			threads.execute(new Withdrawal(sharedLocation, "Thread W5"));
			threads.execute(new Withdrawal(sharedLocation, "Thread W6"));
			threads.execute(new Withdrawal(sharedLocation, "Thread W7"));
			threads.execute(new Withdrawal(sharedLocation, "Thread W8"));
			threads.execute(new Withdrawal(sharedLocation, "Thread W9"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		threads.shutdown();

	}

}
