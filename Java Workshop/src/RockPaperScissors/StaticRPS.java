package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

/**
 * A simple program that plays Rock-Paper-Scissors
 * Non-Object-Oriented - Just a quick refresher after the Christmas break.  
 * 
 * @author Emil Tan
 */
public class StaticRPS {
	/** Integer representation of Rock */
	private static final int ROCK = 1; 
	/** Integer representation of Paper */
	private static final int PAPER = 2; 
	/** Integer representation of Scissors */
	private static final int SCISSORS = 3; 

	public static String printChoice(int play) {
		if(play == ROCK) {
			return "Rock";
		} else if(play == PAPER) {
			return "Paper"; 
		} else if(play == SCISSORS) {
			return "Scissors";
		} 
		return ""; 
	}
	
	public static void checkWinning(int playersPlay, int aiPlay) {
		if(playersPlay == aiPlay) {
			System.out.println("It's a tie");
		} else if(playersPlay == ROCK) {
			if(aiPlay == PAPER) {
				System.out.println("You lost :(");
			} else if(aiPlay == SCISSORS) {
				System.out.println("You won! :D");
			}
		} else if(playersPlay == PAPER) {
			if(aiPlay == ROCK) {
				System.out.println("You won! :D");
			} else if(aiPlay == SCISSORS) {
				System.out.println("You lost :(");
			}
		} else if(playersPlay == SCISSORS) {
			if(aiPlay == ROCK) {
				System.out.println("You lost :(");
			} else if(aiPlay == PAPER) {
				System.out.println("You won! :D");
			}
		}
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in); 

		int playersPlay = 0; 

		boolean validInput = false; 

		while(!validInput) {
			try {
				System.out.print("What do you play? [1] Rock; [2] Paper; or [3] Scissors? ");
				playersPlay = keyboard.nextInt(); 

				if(playersPlay > 0 && playersPlay < 4) {
					validInput = true; 
				} else {
					System.out.println("Invalid input... Please try again...");
				}				
			} catch(Exception e) {
				System.out.println("Invalid input... Please try again...");
				keyboard.nextLine(); 
			}
		} 
		keyboard.close();
		
		Random randomGenerator = new Random();
		int aiPlay = randomGenerator.nextInt(3) + 1; //randomGenerator range from 0..2, I want 1..3
		
		System.out.println("You played " + printChoice(playersPlay));
		System.out.println("The AI played " + printChoice(aiPlay));
		
		checkWinning(playersPlay, aiPlay);
	}
}
