import java.util.Scanner;

import edu.princeton.cs.introcs.*;
//-------------------------TP 1.2 changes--------------------------------------------------//
public class AppRunner
{

	public int numPlayers;
	public String playerName;

	public void playGame()
	{
		StdOut.println("Welcome to 635 Skunk project");
		StdOut.println("Creating the dice object");
		Scanner scan = new Scanner(System.in);
		// StdOut.println("Number of players: ");
		// numPlayers = scan.nextInt();

		StdOut.println("Player Name: ");
		playerName = scan.nextLine();

		// Player Turn (For loop was used because we know that a Skunk game has 5 turns
		// )
		for (int i = 1; i <= 5; i++)
		{

			Turn turn = new Turn();

			StdOut.println(playerName + " start your turn " + i + " ?(Yes/No)"); // user prompt
			String decision = scan.nextLine(); // storing user input
			if (decision.equalsIgnoreCase("No"))
			{ // execute if user input = no
				StdOut.println(playerName + " skipped turn " + i);
				if (i >= 5)
				{
					StdOut.println("Thank you for playing the skunk game");
				}
			}

			while (decision.equalsIgnoreCase("Yes"))
			{ // execute if user input = yes
				StdOut.println(playerName + " would you like to roll? (Yes/No)");
				String decisionRoll = scan.nextLine();
				if (decisionRoll.equalsIgnoreCase("Yes"))
				{
					turn.turnRoll();
					StdOut.println("Roll Info: ");
					StdOut.println("Die 1: " + turn.getDie1Value() + ";" + "Die 2: " + turn.getDie2Value());
					StdOut.println("Roll total: " + turn.getDiceValue());
					StdOut.println("Turn total: " + turn.getTurnScore() + "   Turn " + i);

					if (turn.isSkunk())
					{
						StdOut.println("You rolled a Skunk; end of turn");
						break;
					}
				} 
				else if (decisionRoll.equalsIgnoreCase("No"))
				{
					StdOut.println(playerName + " is ending turn " + i);
					StdOut.println("Turn " + i + " score was " + turn.getTurnScore());
					break;
				}
			} //end of while loop
		} //end of for loop
	} //end of playgame method
} //end of class
