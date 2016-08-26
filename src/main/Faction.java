package main;

public class Faction {
	private int ID = 0;
	private String factionName = "Test Faction";

	public Faction(int inID, String inFactionName) {
		ID = inID;
		factionName = inFactionName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFactionName() {
		return factionName;
	}

	public void setFactionName(String factionName) {
		this.factionName = factionName;
	}

}