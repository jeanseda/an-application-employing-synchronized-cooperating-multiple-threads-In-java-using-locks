
/*  Name:  Jean Seda
 * Course: CNT 4714 
 * Spring 2021
 * Assignment title: Project2–Synchronized, Cooperating Threads Under Locking
 * Due Date: February 14, 2021 */

package part1;

import java.util.Random;

public class Withdrawal implements Runnable {

	private static Random generator = new Random();
	private static Random sleep = new Random();
	private BankAccount sharedLocation;
	String tname;

	public Withdrawal(BankAccount shared, String threadName) {
		sharedLocation = shared;
		tname = threadName;
	}

	@Override
	public void run() {

		while (true) {
			try {
				sharedLocation.withdrawal(generator.nextInt((50 - 1 + 1) + 1), tname);
				Thread.sleep(sleep.nextInt(100 - 1) + 1);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
