package main;

public class CharacterRelationship {
	private int characterA = 0;
	private int characterB = 0;
	private int relationshipType = 0;
	private int act = 0;
		
	public CharacterRelationship(int inCharacterA, int inCharacterB, int inRelationshipType, int inAct) {
		characterA = inCharacterA;
		characterB = inCharacterB;
		relationshipType = inRelationshipType;
		act = inAct;		
	}
}
