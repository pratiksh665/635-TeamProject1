// -------------------------TP 1.2 changes--------------------------------------------------//
public class Turn
{

	private int turnScore;
	private Dice dice;
	private boolean isSkunk;

	public Turn()
	{
		dice = new Dice();
	}

	public void turnRoll()
	{
		dice.roll();

		if (dice.getDie1() == 1 || dice.getDie2() == 1 && dice.getLastRoll() != 2)
		{
			turnScore = 0;
			isSkunk = true;
		}

		else if (dice.getLastRoll() == 2)
		{
			turnScore = 0;
			isSkunk = true;
			// totalScore = 0;
		}

		else
		{
			turnScore += dice.getLastRoll();
			isSkunk = false;
		}
	}

	public int getTurnScore()
	{
		return this.turnScore;
	}

	public boolean isSkunk()
	{
		return isSkunk;
	}

	public int getDie1Value()
	{
		return dice.getDie1();
	}

	public int getDie2Value()
	{
		return dice.getDie2();
	}

	public int getDiceValue()
	{
		return getDie1Value() + getDie2Value();
	}

}
