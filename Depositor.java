
/*  Name:  Jean Seda
 * Course: CNT 4714 
 * Spring 2021
 * Assignment title: Project2–Synchronized, Cooperating Threads Under Locking
 * Due Date: February 14, 2021 */

package part1;

import java.util.Random;

public class Depositor implements Runnable {

	private static Random generator = new Random();
	private static Random sleep = new Random();
	private ABankAccount sharedLocation; // can this be the bank?
	String tname;

	// constructor

	public Depositor(ABankAccount shared, String name) {
		sharedLocation = shared;
		tname = name;
	}

	public void run() {
		while (true) {
			try {
				sharedLocation.deposit(generator.nextInt((250 - 1 + 1) + 1), tname);
				Thread.sleep(sleep.nextInt(2000 - 1) + 1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
