import java.util.Scanner;

import edu.princeton.cs.introcs.*;

public class RunGame {
	
	public int numPlayers;
	public String playerName;

	
	public void playGame() {
		StdOut.println("Welcome to 635 Skunk project");
		StdOut.println("Creating the dice object");
		Scanner scan = new Scanner(System.in);
//		StdOut.println("Number of players: ");
//		numPlayers = scan.nextInt();
		
		StdOut.println("Player Name: ");
		playerName = scan.nextLine();
		
		//Player Turn
		
		for (int i = 1; i <= 5; i++) {
			
			Turn turn = new Turn();
			
			StdOut.println(playerName + " start your turn " + i + " ?(Yes/No)");
			String decision = scan.nextLine();
			if(decision.equalsIgnoreCase("No")) {
				StdOut.println(playerName + " skipped turn " + i);
			} 
			
			while (decision.equalsIgnoreCase("Yes")) {
				StdOut.println(playerName + " would you like to roll? (Yes/No)");
				String decisionRoll = scan.nextLine();
				if (decisionRoll.equalsIgnoreCase("Yes")) {
				turn.turnRoll();
				StdOut.println("Roll Info: "); 
				StdOut.println("Die 1: " + turn.getDie1Value() + ";" + "Die 2: " + turn.getDie2Value());
				StdOut.println("Roll total: " + turn.getDiceValue());
				StdOut.println("Turn total: " + turn.getTurnScore() + "   Turn " + i);
				
				if (turn.isSkunk()) {
					StdOut.println("You rolled a Skunk; end of turn"); 
					break;
				}
				}
				else if (decisionRoll.equalsIgnoreCase("No")) {
					StdOut.println(playerName + " is ending turn " + i);
					StdOut.println("Turn " + i + " score was " + turn.getTurnScore());
					break;
				}

			} 

		}

	}
	//
	
	
}
