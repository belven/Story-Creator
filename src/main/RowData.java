package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class RowData {
	public abstract void loadData();

	public abstract void saveData();

	public abstract String getDataTableName();

	public abstract ResultSet getData();

	public abstract PreparedStatement getUpdateStatement();

	public abstract PreparedStatement getReadStatement();

}
