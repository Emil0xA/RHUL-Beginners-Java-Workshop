package RockPaperScissors;

import java.util.Scanner;

/**
 * A program that plays Rock-Paper-Scissors. 
 * 
 * @author Emil Tan
 */
public class PlayRPS {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		int playerNum = 0;

		try{
			System.out.print("Please enter the number of players: ");
			playerNum = keyboard.nextInt(); 
		} catch(Exception e) {
			System.out.println("Invalid input... Exiting now...");
			System.exit(0); 
		}

		if(playerNum < 1) {
			System.out.println("You need at least 1 player...");
			System.exit(0); 
		}
		
		keyboard.nextLine();   
		
		String[] playerNames = new String[playerNum]; 
		try{
			for(int player = 0; player < playerNum; player++) {
				System.out.print("Please enter the player " + (player + 1) + "'s name: ");
				playerNames[player] = keyboard.nextLine(); 	
			}
		} catch(Exception e) {
			System.out.println("Invalid input... Exiting now...");
			System.exit(0); 
		}

		RockPaperScissors rps = new RockPaperScissors(playerNum, playerNames);

		String option = ""; 
		while(!option.equals("Y")) {
			rps.play();
			
			try {
				System.out.print("Do you want to quit now? (Y/N): "); 
				option = keyboard.nextLine(); 
			} catch(Exception e) {
				System.out.println("A problem occurred whilst trying to process your input... Exiting...");
				System.exit(0); 
			}
		}

		keyboard.close();
	}
}
