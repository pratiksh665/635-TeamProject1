
public class Player {

	public int playerScore;
	public String name;
	public boolean hundred;
	public int chip;

	
	public Player () {
		
	}
	
	public Player (String name) {
		this.name = name;
		this.chip = 50;
	}
	
	public int getChip() {
		return chip;
	}
	
	public void chipPenalty(int subChip) {
		chip = chip - subChip;
	}
	
	public int getScore() {
		return playerScore;
	}
	
	public void setScore(int score) {
		playerScore += score;
	}

}
