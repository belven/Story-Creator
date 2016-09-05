package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Faction extends RowData {
	private int ID = 0;
	private String factionName = "Test Faction";
	private String readData = "SELECT * FROM [Factions] WHERE ID = ?";
	private String writeData = "SELECT * FROM [Factions] SET FactionName = ? WHERE ID = ? ";

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

	@Override
	public void loadData() {
		ResultSet rs = getData();
		try {
			if (rs.next()) {
				setFactionName(rs.getString("FactionName"));
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
		return "Factions";
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
			PreparedStatement ps = CharacterEditorUI.getConnection().prepareStatement(writeData);
			ps.setString(0, getFactionName());
			ps.setInt(1, getID());
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