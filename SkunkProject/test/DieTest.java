import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class DieTest {

	
	@Test
	public void loadedDieTest() {
		int[] progRoll = {1,2,6,5};
		Die die1 = new Die (progRoll);
		int[] dieTest = new int[4];

		
		for (int arrayIndex=progRoll.length-1; arrayIndex>=1; arrayIndex=arrayIndex -1) {
			die1.roll();
			dieTest[arrayIndex] = die1.getLastRoll();
			System.out.println(dieTest[arrayIndex]);
		}
			
		
		String actual = Arrays.toString(dieTest);
		String expected = Arrays.toString(new int[] {1,2,6,5});
		
		Assert.assertEquals(actual,expected);
	}

}
