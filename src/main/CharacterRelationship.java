package main;

public class CharacterRelationship {
	private int characterA = 0;
	private int characterB = 0;
	private int relationshipType = 0;
	private int act = 0;

	public static enum RelationshipTypes {
		Child, Parent, Brother, Sister, Father, Mother
	}

	public CharacterRelationship(int inCharacterA, int inCharacterB, int inRelationshipType, int inAct) {
		setCharacterA(inCharacterA);
		setCharacterB(inCharacterB);
		setRelationshipType(inRelationshipType);
		setAct(inAct);
	}

	public int getCharacterA() {
		return characterA;
	}

	public void setCharacterA(int characterA) {
		this.characterA = characterA;
	}

	public int getCharacterB() {
		return characterB;
	}

	public void setCharacterB(int characterB) {
		this.characterB = characterB;
	}

	public int getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(int relationshipType) {
		this.relationshipType = relationshipType;
	}

	public int getAct() {
		return act;
	}

	public void setAct(int act) {
		this.act = act;
	}
}
