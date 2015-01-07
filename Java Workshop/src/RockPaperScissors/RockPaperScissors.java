package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

/**
 * A program that sets up a game of Rock-Paper-Scissors. 
 * 
 * @author Emil Tan
 */
public class RockPaperScissors {
	/** For players to input plays */
	private Scanner keyboard = new Scanner(System.in); 

	/** An arrays of players */
	private Player[] players; 
	
	/** An arrays of AIs, essentially players */
	private Player[] ais; 
	
	/** Integer representing Rock */
	private final int ROCK = 1; 
	/** Integer representing Paper */
	private final int PAPER = 2;
	/** Integer representing Scissors */
	private final int SCISSORS = 3;

	/**
	 * Constructor of the Rock-Paper-Scissors game. 
	 * 
	 * @param playerNum Number of players 
	 * @param playerNames Respective player's name
	 */
	public RockPaperScissors(int playerNum, String playerNames[]) {
		players = new Player[playerNum];
		ais = new Player[playerNum];

		for(int player = 0; player < playerNum; player++) {
			players[player] = new Player(playerNames[player]);
			ais[player] = new Player(playerNames[player] + "'s AI"); 
		}
	}

	/**
	 * "Main" method that play each rounds, and calls scoring() to determine the outcome. 
	 */
	public void play() {
		for(int player = 0; player < players.length; player++) {
			System.out.print(players[player].getName() + " what do you play? [1] Rock; [2] Paper; or [3] Scissors? ");
			int playerPlay = keyboard.nextInt(); 

			Random randomGenerator = new Random();
			int aiPlay = randomGenerator.nextInt(3) + 1; //randomGenerator range from 0..2, I want 1..3
			System.out.print(ais[player].getName() + " plays ... ");
			if(aiPlay == ROCK) {
				System.out.println("Rock");
			} else if(aiPlay == PAPER) {
				System.out.println("Paper");
			} else if(aiPlay == SCISSORS) {
				System.out.println("Scissors");
			} else {
				System.out.println("Something unusual happened. Exiting now... Please inform the programmer.");
				System.exit(0);
			}
			System.out.print(players[player].getName());
			scoring(player, playerPlay, aiPlay); 
		}
		printScores(); 
	}

	/**
	 * Determines if the game is won, lost, or drawn, then allocate scores to the respective players. 
	 * 
	 * @param player The player who is currently playing
	 * @param playerPlay Play made by the player
	 * @param aiPlay Play made by the AI
	 */
	public void scoring(int player, int playerPlay, int aiPlay) {
		if(playerPlay == ROCK) {
			if(aiPlay == PAPER) {
				System.out.println(" lost..."); 
				ais[player].addScore(3);
				return;
			} else if(aiPlay == SCISSORS) {
				System.out.println(" won!"); 
				players[player].addScore(3);
				return; 
			}
		} else if(playerPlay == PAPER) {
			if(aiPlay == ROCK) {
				System.out.println(" won!"); 
				players[player].addScore(3);
				return;
			} else if(aiPlay == SCISSORS) {
				System.out.println(" lost..."); 
				ais[player].addScore(3);
				return; 
			}
		} else if(playerPlay == SCISSORS) {
			if(aiPlay == ROCK) {
				System.out.println(" lost..."); 
				ais[player].addScore(3);
				return;
			} else if(aiPlay == PAPER) {
				System.out.println(" won!"); 
				players[player].addScore(3);
				return; 
			}
		} else {
			System.out.println("... Something unusual happened. Exiting now... Please inform the programmer.");
			System.exit(0);
		}
		System.out.println(" draws with the AI!");
		players[player].addScore(1); 
		ais[player].addScore(1);
	}

	/**
	 * Print the current scores. 
	 */
	public void printScores() {
		System.out.println("--------------"); 
		for(int player = 0; player < players.length; player++) {
			System.out.print(players[player].getName() + ": " + players[player].getScore() + "\t"); 
		}
		System.out.println();
		for(int player = 0; player < players.length; player++) {
			System.out.print(ais[player].getName() + ": " + ais[player].getScore() + "\t");
		}
		System.out.println("\n--------------");
	}
}
