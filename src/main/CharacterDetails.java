package main;

public class CharacterDetails {

	public static int labelColumn = 0;
	public static int valueColumn = 1;

	public int ID = 0;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	private String firstName;
	private String secondName;

	public CharacterDetails(int inID, String inFirstName, String inSecondName) {
		ID = inID;
		setFirstName(inFirstName);
		setSecondName(inSecondName);
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
