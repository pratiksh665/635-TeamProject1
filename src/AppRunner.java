import java.util.ArrayList;
import java.util.Scanner;

import edu.princeton.cs.introcs.*;

//-------------------------TP 1.2 changes--------------------------------------------------//
public class AppRunner {

	public int numPlayers;
	public ArrayList<Player> playerList = new ArrayList();
	public boolean isHundred = false;

	public void playGame() {
		StdOut.println("Welcome to 635 Skunk project");
		StdOut.println("Creating the dice object");
		Scanner scan = new Scanner(System.in);
		StdOut.println("Would you like to see the rules? (Yes/No)");
		if (scan.next().equalsIgnoreCase("Yes") ) {
			showRules();
		}
		StdOut.println("Number of players: ");
		numPlayers = scan.nextInt();

		for (int i = 1; i <= numPlayers; i++) {
			StdOut.println("Player " + i + " Name: ");
			String playerName = scan.next();
			Player player = new Player(playerName);
			playerList.add(player);
		}

		// Player Turn (For loop was used because we know that a Skunk game has 5 turns
		// )

		while (!isHundred) {

			for (Player player : playerList) {

				Turn turn = new Turn();

				StdOut.println(player.name + " start your turn ?(Yes/No)"); // user prompt
				String decision = scan.next(); // storing user input
				if (decision.equalsIgnoreCase("No")) { // execute if user input = no
					StdOut.println(player.name + " skipped turn ");
				}

				while (decision.equalsIgnoreCase("Yes")) { // execute if user input = yes
					StdOut.println(player.name + " would you like to roll? (Yes/No)");
					String decisionRoll = scan.next();
					if (decisionRoll.equalsIgnoreCase("Yes")) {
						turn.turnRoll();
						
						StdOut.println("Roll Info: ");
						StdOut.println("Die 1: " + turn.getDie1Value() + ";" + "Die 2: " + turn.getDie2Value());
						StdOut.println("Roll total: " + turn.getDiceValue());
						StdOut.println("Turn total: " + turn.getTurnScore());
						StdOut.println("Game total: " + player.getScore());

						if (turn.isSkunk() || turn.isDoubleSkunk()) {
							StdOut.println("You rolled a Skunk; end of turn");
							if (turn.isSkunk()) {
								StdOut.println("Total score is " + player.getScore());
								player.chipPenalty(1);
							}
							else if (turn.isDoubleSkunk()) {
								player.setScore(0);
								StdOut.println("Total score is " + player.getScore());
								player.chipPenalty(2);
							}
							break;
						}
//
//						else {
//							if (player.hundred) {
//								this.hundred = true;
//								gameEnd(player);
//							}
//						}
					} 
					else if (decisionRoll.equalsIgnoreCase("No")) {
						player.setScore(turn.getTurnScore());
						StdOut.println(player.name + " is ending turn ");
						isHundred(player.getScore(), player);
						StdOut.println("Turn score was " + turn.getTurnScore());
						StdOut.println("Total score is " + player.getScore());
						
						break;
					}
				} // end of while loop
		//THIS STOPS GAME WHEN SCORE >= 100
				if (isHundred) {
					break;
				}
			} // end of for loop
			
		} // end of while loop
	} // end of playgame method

	public boolean isHundred(int score, Player player) {
		if (score >= 100) {
			isHundred = true;
			gameEnd(player);
		}
		return isHundred;
	}
	
	public void gameEnd(Player player) {
		System.out.println(player.name + " won the game with " + player.playerScore + " points!");
	}
	
	public void showRules() {
		String rules = "DIRECTIONS FOR PLAYING\n" + 
				"\n" + 
				"The object of the game is to accumulate a score of 100 points or more. A score is made by rolling the dice and combining the points "
				+ "\n" + 
				"on the two dice. For example: A 4 and 5 would be 9 points - if the player decides to take another roll of the dice and turns up" + 
				 "\n" + 
				"a 3 and 5 (8 points), he would then have an accumulated total of 17 points for the two rolls. The player has the privilege of continuing" +  
				"\n" + 
				"to shake to increase his score or of passing the dice to wait for the next series, thus preventing the possibility of rolling a Skunk and losing his score.\n" + 
				"\n" + 
				"PENALTIES:\n" + 
				"\n" + 
				"A skunk in any series voids the score for that series only and draws a penalty of 1 chip placed in the \"kitty,\" and loss of dice.\n" + 
				"\n" + 
				"A skunk and a deuce voids the score for that series only and draws a penalty of 2 chips placed in the \"kitty,\" and loss of dice.\n" + 
				"\n" + 
				"TWO skunks void the ENTIRE accumulated score and draws a penalty of 4 chips placed in the \"kitty,\" and loss of dice. Player must again start to score from scratch.\n" + 
				"\n" + 
				"Any number can play. [Assume at least two players!] The suggested number of chips to start is 50. There are sufficient chips in the box to allow 8 players to start with" + 
				"\n" + 
				"50 chips by placing a par value of \"one\" on white chips, 5 for 1 on red chips and 10 for 1 on the blue chips.\n" + 
				"\n" + 
				"The first player to accumulate a total of 100 or more points can continue to score as many points over 100 as he believes is needed to win. When he decides to stop, his" + 
				"\n" + 
				"total score is the \"goal.\" Each succeeding player receives one more chance to better the goal and end the game.\n" + 
				"\n" + 
				"The winner of each game collects all chips in \"kitty\" and in addition five chips from each losing player or 10 chips from any player without a score.\n" + 
				"";
		
		StdOut.println(rules);
	}
	
} // end of class
