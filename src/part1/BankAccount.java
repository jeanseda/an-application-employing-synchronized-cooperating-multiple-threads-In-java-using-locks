
/*  Name:  Jean Seda
 * Course: CNT 4714 
 * Spring 2021
 * Assignment title: Project2–Synchronized, Cooperating Threads Under Locking
 * Due Date: February 14, 2021 */

package part1;

public interface BankAccount {

	public void deposit(int value, String threadName);

	public void withdrawal(int withdrawal, String threadName);
}
