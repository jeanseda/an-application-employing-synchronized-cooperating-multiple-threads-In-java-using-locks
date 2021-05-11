
/*  Name:  Jean Seda
 * Course: CNT 4714 
 * Spring 2021
 * Assignment title: Project2–Synchronized, Cooperating Threads Under Locking
 * Due Date: February 14, 2021 */

package part1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// holds the account money 
public class ABankAccount implements BankAccount {

	private Lock accessLock = new ReentrantLock(); // exclusive access to the buffer

	private Condition canDeposit = accessLock.newCondition();
	private Condition canWithdraw = accessLock.newCondition();

	private int balance = 0;
	private boolean occupied = false; // occupied status

	@Override
	public void deposit(int money, String threadName) {

		accessLock.lock();

		try {
			balance += money;
			System.out.print("   " + threadName + " deposits " + " money $" + money);
			System.out.println("\t\t\t\t\t\t\t\t\t (+) Balance is " + balance); // not sure if this is required

			canWithdraw.signal();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			accessLock.unlock(); // releasing the lock
		}
		// put money in the account and sleeps for a while
		// let everybody knows that money was deposited
		// 5 threads deposit ( between $1 to $250)

	}

	@Override
	public void withdrawal(int withdrawal, String threadName) {

		accessLock.lock();
		try {
			System.out.print("\t\t\t\t\t Thread " + threadName + " withdraws " + withdrawal);

			if (balance < withdrawal) {
				System.out.println("\t\t\t\t\t (****) WITHDRAWAL BLOCKED - INSUFFICIENT FUNDS!!!");
				canWithdraw.await();
			} else if (balance > withdrawal) {
				balance -= withdrawal;

				System.out.println("\t\t\t\t\t (-) Balance is " + balance); // not sure if this is required

			}

			canDeposit.signal();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			accessLock.unlock(); // releasing the lock
		}

	}

	public void DisplayState(String operation) {

		System.out.printf("%-40s%d\t\t\t\t%b\n", operation, balance, occupied);
	}

}
