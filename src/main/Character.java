package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Character extends RowData {
	private int ID = 0;

	private String firstName = "Test";
	private String secondName = "Name";
	private String description = "Test description";
	private String readData = "SELECT * FROM [Characters] WHERE ID = ?";
	private String writeData = "SELECT * FROM [Characters] SET FirstName = ?, SecondName = ?, Description = ?, RaceID = ?, FactionID = ?, HomeID = ? WHERE ID = ? ";

	private List<CharacterRelationship> characterRelationships = new ArrayList<>();

	private int placeOfBirth = 0;
	private int race = 0;
	private int faction = 0;

	public Character(int inID, String inFirstName, String inSecondName) {
		ID = inID;
		setFirstName(inFirstName);
		setSecondName(inSecondName);
	}

	public Character(int inID, String inFirstName, String inSecondName, int inPlaceOfBirth, int inRace, int inFaction) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void loadData() {
		ResultSet rs = getData();
		try {
			if (rs.next()) {
				setFirstName(rs.getString("FirstName"));
				setSecondName(rs.getString("SecondName"));
				setDescription(rs.getString("Description"));
				setRace(rs.getInt("RaceID"));
				setFaction(rs.getInt("FactionID"));
				setPlaceOfBirth(rs.getInt("HomeID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveData() {
		try {
			getUpdateStatement().executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getDataTableName() {
		return "Characters";
	}

	@Override
	public ResultSet getData() {
		try {
			return getReadStatement().getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PreparedStatement getUpdateStatement() {
		try {
			int row = 0;
			PreparedStatement ps = CharacterEditorUI.getConnection().prepareStatement(writeData);
			ps.setString(row++, getFirstName());
			ps.setString(row++, getSecondName());
			ps.setInt(row++, getRace());
			ps.setInt(row++, getFaction());
			ps.setString(row++, getDescription());
			ps.setInt(row++, getPlaceOfBirth());
			ps.setInt(row++, getID());
			return ps;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PreparedStatement getReadStatement() {
		try {
			PreparedStatement ps = CharacterEditorUI.getConnection().prepareStatement(readData);
			ps.setInt(0, getID());
			return ps;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
