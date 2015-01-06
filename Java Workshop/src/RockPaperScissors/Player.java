package RockPaperScissors;

/**
 * Player of Rock-Paper-Scissors
 * 
 * @author Emil Tan
 */
public class Player {
	private String playerName; 
	private int playerScore; 
	
	/**
	 * Player constructor. Set player's name, and initialise player's score. 
	 * 
	 * @param name Player's name.
	 */
	public Player(String name) {
		playerName = name; 
		playerScore = 0; 
	}
	
	/**
	 * Retrieve name of the player. 
	 * 
	 * @return Player's name.
	 */
	public String getName() {
		return playerName; 
	}
	
	/**
	 * Add score to player's overall scores.
	 * 
	 * @param score Score to add.
	 */
	public void addScore(int score) {
		playerScore += score; 
	}
	
	/**
	 * Retrieve scores of the player.
	 * 
	 * @return Player's score.
	 */
	public int getScore() {
		return playerScore; 
	}
}
