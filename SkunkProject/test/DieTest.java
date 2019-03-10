import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class DieTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void loadedDieTest() {
		int[] progRoll = {1,2,6,5};
		Die die1 = new Die (progRoll);
		int[] dieTest = new int[10];
		for (int i=0; i<=3; i++) {
			die1.roll();
			dieTest[i] = die1.getLastRoll();
			System.out.println(dieTest[i]);
		}
		Assert.assertEquals(
				Arrays.toString(dieTest), 
				Arrays.toString(new int[] {1,2,6,5}));
	}

}
