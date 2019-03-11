import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DieTest {
	@Rule
	  public final ExpectedException exception = ExpectedException.none();
	
	@Test
	//Test that preprogrammed Die object is working as expected
	public void loadedDieTest() {
		int[] progRoll = {1,2,6,5};
		Die die1 = new Die (progRoll);
		int[] dieTest = new int[10];
		//roll preprogrammed Die object 10 times; should run through the preprogrammed values then start over
		for (int i=0; i<=9; i++) {
			die1.roll();
			dieTest[i] = die1.getLastRoll();
			System.out.println(dieTest[i]);
		}
		Assert.assertEquals(
				Arrays.toString(new int[] {1,2,6,5,1,2,6,5,1,2}), 
				Arrays.toString(dieTest));
	}
	
	@Test
	//test that the nullPointerException is thrown when an empty array is passed as a parameter to Die obj
	public void nullExceptionTest() {
		exception.expect(NullPointerException.class);
		exception.expectMessage("Empty Array Initialized");
		int[] emptyArray = null;
		Die empty = new Die(emptyArray);
	}
	
	
}
