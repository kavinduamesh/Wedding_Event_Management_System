/*
 * 
 *this is a custom exception that check user's password any handle a exception if any
 */

package CustomExceptions;

public class PasswordIncorrect extends Exception {
	
	public PasswordIncorrect(String msg) {
		
		super(msg);//call super class constructor
	}

}
