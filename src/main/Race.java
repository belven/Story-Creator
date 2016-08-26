package main;

public class Race {
	private int ID = 0;
	private String raceName = "Test Race";

	public Race(int inID, String inRaceName) {
		ID = inID;
		raceName = inRaceName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

}
