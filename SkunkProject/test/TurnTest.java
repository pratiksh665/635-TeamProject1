import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TurnTest {

		private Dice dice, dice2;
		private Die die1, die2, die3, die4;
		private int[] rollDie1, rollDie2, rollDie3, rollDie4;

		@Before
		public void setUp() throws Exception
		{
	 		this.rollDie1 = new int[] { 1, 2, 3 };
			this.die1 = new Die(rollDie1);

			this.rollDie2 = new int[] { 1, 2, 3 };
			this.die2 = new Die(rollDie2);
			
			this.dice = new Dice(die1, die2);
			
			this.rollDie3 = new int[] { 3, 4, 5 };
			this.die3 = new Die(rollDie3);

			this.rollDie4 = new int[] { 4, 5, 6 };
			this.die4 = new Die(rollDie4);
						
			this.dice2 = new Dice(die3, die4);
			
		}
		
		@Test
		public void testIsSkunk() {
			Turn turn = new Turn(dice);
			turn.turnRoll();
			boolean testBol = turn.isSkunk();
			assertTrue(testBol);
		}
		
		@Test
		public void testScore() {
			Turn turn2 = new Turn(dice2);
			turn2.turnRoll();
			int testScore = 7;
			int actualScore = turn2.getTurnScore();
			assertEquals(testScore,actualScore);
		}
		
		@Test
		public void testScoreAfterSkunk() {
			Turn turn = new Turn(dice);
			turn.turnRoll();
			int testScore = 0;
			int actualScore = turn.getTurnScore();
			assertEquals(testScore,actualScore);
		}
}
