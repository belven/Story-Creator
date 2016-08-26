package main;

import java.util.ArrayList;
import java.util.List;

public class CharacterDetails {
	private int ID = 0;

	private String firstName = "Test";
	private String secondName = "Name";

	private List<CharacterRelationship> characterRelationships = new ArrayList<>();

	private int placeOfBirth = 0;
	private int race = 0;
	private int faction = 0;

	public CharacterDetails(int inID, String inFirstName, String inSecondName) {
		ID = inID;
		setFirstName(inFirstName);
		setSecondName(inSecondName);
	}

	public CharacterDetails(int inID, String inFirstName, String inSecondName, int inPlaceOfBirth, int inRace,
			int inFaction) {
		this(inID, inFirstName, inSecondName);
		setRace(inRace);
		setFaction(inFaction);
		setPlaceOfBirth(inPlaceOfBirth);
	}

	public int getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(int placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public int getRace() {
		return race;
	}

	public void setRace(int race) {
		this.race = race;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public int getFaction() {
		return faction;
	}

	public void setFaction(int faction) {
		this.faction = faction;
	}

	public List<CharacterRelationship> getCharacterRelationships() {
		return characterRelationships;
	}

	public void setCharacterRelationships(List<CharacterRelationship> tempRelationships) {
		this.characterRelationships = tempRelationships;
	}
}
