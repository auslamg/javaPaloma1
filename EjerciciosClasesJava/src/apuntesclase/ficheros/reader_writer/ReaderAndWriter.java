package apuntesclase.ficheros.reader_writer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//Diferencia entre BufferedReader, etc.
//Diferencia entre BufferedWriter, PrintWrtier, etc.

///Tarea
/// Leer por consola hasta que no quede entrada
/// Por cada ejecucion, añadir contenido al archivo

/**
 * Reads a file from the inputed path and makes a new file copying the text
 */
public class ReaderAndWriter {

	static String inputPath = "resources\\readerAndWriter\\input.txt";
	static String outputPath = "resources\\readerAndWriter\\output.txt";

	public static void main(String[] args) throws IOException {
		manualClosed();
	}

	/**
	 * Resources are declared and initialized outside of try statement, so they must
	 * be closed manually after execution in finally block
	 */
	static void manualClosed() throws IOException {
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;

		try {
			inputStream = new BufferedReader(new FileReader(inputPath));
			outputStream = new PrintWriter(new FileWriter(new File(outputPath)));

			String l;
			while ((l = inputStream.readLine()) != null) {
				outputStream.println(l);
			}

		} catch (FileNotFoundException f) {
			System.out.println("ARCHIVO NO ENCONTRADO");
		} catch (IOException e) {
			System.out.println("ERROR DETECTADO");
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

	/**
	 * Resources are declared and initialized inside of try statement, so they close
	 * automatically when the try finishes
	 */
	static private void autoClosed() {
		try (BufferedReader inputStream = new BufferedReader(new FileReader(inputPath));
				PrintWriter outputStream = new PrintWriter(new FileWriter(new File(outputPath)))) {

			String l;
			while ((l = inputStream.readLine()) != null) {
				outputStream.println(l);
			}

		} catch (FileNotFoundException f) {
			System.out.println("ARCHIVO NO ENCONTRADO");
		} catch (IOException e) {
			System.out.println("ERROR DETECTADO");
		} finally {
			// Empty
		}
	}

}

enum MyEnum {
	a,
	b,
	c;

    private MyEnum() {
    }
	
};
