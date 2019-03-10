import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;


public class SkunkApp 
{
	
	public static void main (String [] args) 
	{
		StdOut.println("Welcome to 635 Skunk project");
		StdOut.println("Creating the dice object");
		Dice diceObj = new Dice();
		StdOut.println("Using the dice object to print out the random roll's value: " + diceObj.getLastRoll());	
		
		int[] preProgrammedRoll = {1,2};
		StdOut.println("Updating the reference pointer of the object variable to execute a new constructor");
		Die dieObj = new Die(preProgrammedRoll);
		StdOut.println("Using the dice object to perform the preprogrammed roll");	
		dieObj.roll();
		StdOut.println("Die object's pre programmed roll: " + dieObj.getLastRoll());
		StdOut.println("Using the dice object to print out the pre programmed roll's value: " + diceObj.getLastRoll());	

		
	}

}
