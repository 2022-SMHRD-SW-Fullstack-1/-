package Model;

public class PlayerDTO {
	
	private String name;
	private int ability;
	public int score;
	
	public PlayerDTO(String d_name, int ability, int score) {
		this.name = d_name;
		this.ability = ability;
		this.score = score;
	}
	int b;
	public String getD_name() {
		return name;
	}


	public int getAbility() {
		return ability;
	}

	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	

}
