import org.junit.Assert;
import org.junit.Test;


// Assert,assertEquals (expected, actual)
// where expected = premethod output
//       actual = post method output
public class PlayerTest {
	

	Player p1 = new Player("pratiksh"); //calling the overloaded constructor in the Player Class (name = pratiksh, chip = 50)
	Player p2 = new Player("anna");     //calling the overloaded constructor in the Player Class (name = anna, chip = 50)
	Player p3 = new Player("khadija");  //calling the overloaded constructor in the Player Class (name = khadija, chip = 50)

	
    @Test
    public void constructorTest() {
        Assert.assertEquals("pratiksh", p1.name); // due to object creation we know p1.name should be pratiksh
        Assert.assertEquals(50, p1.getChip());  //method gets the default value of the chip variable
        Assert.assertEquals(0, p1.getScore()); //method gets the default value of the playerScore variable
    }

    @Test
    public void testPenalty() {
        Assert.assertEquals(50, p2.getChip());  //method gets the default value of the chip variable
        p2.chipPenalty(10); // //method sets the updated value of the chip variable based on the argument passed into the function
        Assert.assertEquals(40, p2.getChip()); //method gets the updated value of the chip variable
    }

    @Test
    public void setScoreTest() {
        p3.setScore(100); //method sets the updated value of the playerScore variable based on the argument passed into the function
        Assert.assertEquals(100, p3.getScore()); //method gets the updated value of the playerScore variable
    }

}

