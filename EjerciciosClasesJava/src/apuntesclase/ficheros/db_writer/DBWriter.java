package apuntesclase.ficheros.db_writer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DBWriter {
	final static Scanner in = new Scanner(System.in);
	static String dbPath = "resources\\DBWriter\\database";

	public static void main(String[] args) {
		try (in) {

			System.out.println("Gimme a String");
			String s = in.next();

			String result = (s.charAt(0) == '#') ? "Si" : "No";

			System.out.println(result);
			return;
			//DBAction action = askAction();
		}
	}

	private static DBAction askAction() {
		System.out.println("Type action:");

		String input = in.next();
		switch (input.toUpperCase()) {
			case "CREATE" -> {
				return DBAction.CREATE;
			}
			case "READ" -> {
				return DBAction.READ;
			}
			case "UPDATE" -> {
				return DBAction.UPDATE;
			}
			case "DELETE" -> {
				return DBAction.DELETE;
			}
			default -> throw new IllegalArgumentException("Invalid action: " + input);
		}
	}

}

enum DBAction {
	CREATE,
	READ,
	UPDATE,
	DELETE
}

class DataTable {

	List<String> fields = new ArrayList<>();
	HashMap<String, String> tableMap = new HashMap<>();
	String path = null;

	public DataTable(String path, List<String> fields) {
		this.path = path;
		this.fields = fields;
		loadDatabase();
	}

	private void loadDatabase() {
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			reader.readLine();
			String line;

			while ((line = reader.readLine()) != null) {
				// Split values
				String[] values = line.split(",");
				String id = null;

				// Find ID
				for (String s : values) {
					if (s.charAt(0) == '#') {
						id = s;
						break;
					}
				}
				if (id == null) {
					throw new IllegalArgumentException("Could not find key");
				}

				// Introduced wrong amount of values
				if (values.length != fields.size()) {
					throw new IllegalArgumentException("Invalid amount of parameters");
				}

				// Values as entire String
				tableMap.put(values[0], line);
			}

		} catch (IOException e) {
			System.out.println("Exception caught while using BufferedReader");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	Set<String> getKeySet() {
		return tableMap.keySet();
	}

	public void addRow(String key, String values) {
		if (getKeySet().add(key)) {
			tableMap.put(key, values);
		}
	}

	public String[] readRow(String key) {
		if (getKeySet().contains(key)) {
			return tableMap.get(key).split(",");
		} else
			return null;
	}

	public void updateRow(String key, String values) {
		if (getKeySet().contains(key)) {
			tableMap.replace(key, values);
		}
	}

	public void deleteRow(String key) {
		if (getKeySet().contains(key)) {
			tableMap.remove(key);
		}
	}
}