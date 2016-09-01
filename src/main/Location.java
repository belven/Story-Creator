package main;

public class Location {
	private int ID = 0;
	private String name = "Test Location";
	private String description = "Test Location Description";

	public Location(int inID, String inName) {
		ID = inID;
		name = inName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}