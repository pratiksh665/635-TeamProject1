import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	
	// Updated showRules() method to display info from a text file called SkunkRules for code reusability
	public void showRules() {
		
		 // The name of the file to open.
        String fileName = "SkunkRules";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //read line by line in the text file until the line is not null
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
        	System.out.println("Error reading file '" + fileName + "'");                  
        }
    }
	
} // end of class
