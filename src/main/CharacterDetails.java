package main;

public class CharacterDetails {
	private int ID = 0;
	
	private String firstName = "Test";
	private String secondName = "Name";
	
	private Arrary<CharacterRelationship> characterRelationships = new Array<>();
	
	private int placeOfBirth = 0;
	private int race = 0;
	private int faction = 0;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public CharacterDetails(int inID, String inFirstName, String inSecondName) {
		ID = inID;
		setFirstName(inFirstName);
		setSecondName(inSecondName);
	}
	
	public CharacterDetails(int inID, String inFirstName, String inSecondName, Arrary<CharacterRelationhip> inRelationships, int inRace, int inFaction) {
		this(inID, inFirstName, inSecondName);
		characterRelationships = inRelationships;
		race = inRace;
		faction = inFaction;
	}

	@Override
	public String toString() {
		return getFirstName() + " " + getSecondName();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String inFirstName) {
		firstName = inFirstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String inSecondName) {
		secondName = inSecondName;
	}
}
