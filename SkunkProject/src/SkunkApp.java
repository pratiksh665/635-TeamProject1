import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;


public class SkunkApp 
{
	
	public static void main (String [] args) 
	{
		StdOut.println("Creating the Dice Object");
		Dice diceObj = new Dice();
		StdOut.println("Using the dice object to perform roll");	
		diceObj.roll();
		StdOut.println("Printing the roll value from the Dice Object");	
		StdOut.println(diceObj.getLastRoll());
	}

}
