package apuntesclase.ficheros.db_writer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DBWriter {
	final static Scanner in = new Scanner(System.in);
	static String dbPath = "resources\\DBWriter\\database";

	static Map<String, List<?>> DB = new HashMap<>();

	public static void main(String[] args) {
		loadDatabase();
		readCommand();
		DBAction action = askAction();

		in.close();
	}

	private static void loadDatabase() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'loadDatabase'");
	}

	private static void readCommand() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'readCommand'");
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

class TableManager {

    @SuppressWarnings("static-access")
	public TableManager(String name, String DBpath, Scanner in) {
		this.in = in;
		loadTable(DBpath);
    }

	private void loadTable(String path) {
		BufferedReader input = null;

		// Make file if not exists
		File file = new File(DBPath + "\\" + name + ".txt");
		if (!file.exists()) {
			try {
				Files.createDirectories(file.getParentFile().toPath());
				Files.createFile(file.toPath());
			} catch (IOException e) {
				System.err.println("Error creating file: " + e.getMessage());
			}
		}


		
	}
	
	static Scanner in;

	String name;

	HashSet<String> columns = new HashSet<>();
	String DBPath = "resources\\DBWriter\\database";

	//Map<String, List<?>> table = new HashMap<>();

	protected void addRow(String id, List<?> values) {
		table.put(id, values);
	}

	protected List<?> readRow(String id) {
		return table.get(id);
	}

	protected void updateRow(String id, List<?> values) {
		table.replace(DBPath, values);
	}

	protected void deleteRow(String id) {

	}
}
