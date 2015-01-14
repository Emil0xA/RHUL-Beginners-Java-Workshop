package ExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Print joke from file. 
 * Display error message accordingly. 
 * 
 * Reference: 
 * Cay S. Horstmann. Big Java, 4th Edition, John Wiley & Sons. Feb, 2010 - Chapter 10.1 Reading and Writing Text Files
 * 
 * @author Emil Tan
 */
public class PrintJoke {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in); 

		String joke1Filename = "src/ExceptionHandling/ifjoke.txt";
		String joke2Filename = "src/ExceptionHandling/whilejoke.txt"; 

		try {
			System.out.println("I have two bad programmer joke.");
			System.out.print("Which do you want to read? (1 or 2)? > ");

			int choice = keyboard.nextInt(); 

			if(choice < 1 || choice > 2) {
				throw new IllegalArgumentException("Please enter either 1 or 2"); 
			}
			
			File jokeFile; 
			if(choice == 1) {
				jokeFile = new File(joke1Filename); 
			} else {
				jokeFile = new File(joke2Filename); 
			}

			Scanner fileIn = new Scanner(jokeFile); 

			while(fileIn.hasNextLine()) {
				System.out.println(fileIn.nextLine()); 
			}
			
			fileIn.close(); 
		} catch(InputMismatchException e) {
			System.out.println("Error: Please enter an integer.");
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch(FileNotFoundException e) {
			System.out.println("The file containing the joke does not exist. Please contact the programmer.");
		} catch(Exception e) {
			System.out.println("Something bad happened... Exiting... ");
		} finally {
			keyboard.close();
		}
	}
}
