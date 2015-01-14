package ExceptionHandling;

import java.util.InputMismatchException;

/**
 * Print joke from file. 
 * Display error message accordingly. 
 * 
 * Reference: 
 * Cay S. Horstmann. Big Java, 4th Edition, John Wiley & Sons. Feb, 2010 - Chapter 10.1 Reading and Writing Text Files
 * 
 * @author Emil Tan
 */
public class ExpectIntException extends InputMismatchException {
	public ExpectIntException() {
		
	}
	public ExpectIntException(String message) {
		super(message); 
	}
	public String getMessage() {
		return "Error: Please enter an integer."; 
	}
}
