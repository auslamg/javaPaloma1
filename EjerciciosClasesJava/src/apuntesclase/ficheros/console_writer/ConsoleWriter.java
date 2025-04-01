package apuntesclase.ficheros.console_writer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;

public class ConsoleWriter {

	static String path = "resources\\consoleWriter\\output.txt";	

	public static void main(String[] args) {
		BufferedReader input = null;
		PrintWriter output = null;

		File file = new File(path);
		if (!file.exists()) {
			try {
				Files.createDirectories(file.getParentFile().toPath());
				Files.createFile(file.toPath());
			} catch (IOException e) {
				System.err.println("Error creating file: " + e.getMessage());
				return;
			}
		}

		try {
			input = new BufferedReader(new InputStreamReader(System.in));
			output = new PrintWriter(new FileWriter(file, true)); // Append mode

			System.out.println("Enter text to write to the file (type 'exit' to quit):");
			String line;
			while ((line = input.readLine()) != null) {
				if ("//end".equalsIgnoreCase(line.trim())) {
					break;
				}
				output.println(line);
			}

		} catch (FileNotFoundException f) {
			System.err.println("File not found: " + f.getMessage());
		} catch (IOException e) {
			System.err.println("I/O error: " + e.getMessage());
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					System.err.println("Error closing input stream: " + e.getMessage());
				}
			}
			if (output != null) {
				output.close();
			}
		}
	}

}
