package apuntesclase.ficheros.check_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Program checks if text file contains a word or a regexp
  */
public class CheckReader {

    static String inputPath = "resources\\checkReader\\input.txt";

    static String regex = "Lorem";
    
    static List<Integer> linesAt = new ArrayList<>();

    static boolean errorFound = false;
    public static void main(String[] args) {
        System.out.println("Scanning for word "+ regex + "...");
        
        boolean isContained = isContained();
        int repsCount = checkReps(); 

        if (!errorFound) {
            System.out.println("File contains regex?: " + (String.valueOf(isContained)));
            System.out.println("Repetitions found: " + repsCount);
            System.err.println("Repetitions at lines: " + linesAt);       
        }
        else {
            System.out.println("Error found, program terminated");
        }
    }

    static private boolean isContained() {
        BufferedReader input = null;

        // Make file if not exists
        File file = new File(inputPath);
        if (!file.exists()) {
            try {
                Files.createDirectories(file.getParentFile().toPath());
                Files.createFile(file.toPath());
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
                errorFound = true;
                return false;
            }
        }

        try {
            input = new BufferedReader(new FileReader(inputPath));
            String line;
            while ((line = input.readLine()) != null) {
                if (line.contains(regex)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            errorFound = true;
        } catch (IOException e) {
            System.out.println("Couldn't read file!");
            errorFound = true;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println("Couldn't close resource!");
                    errorFound = true;
                }
            }
        }
        return false;
    }

    static private int checkReps() {
        int result = 0;

        BufferedReader input = null;

        // Make file if not exists
        File file = new File(inputPath);
        if (!file.exists()) {
            try {
                Files.createDirectories(file.getParentFile().toPath());
                Files.createFile(file.toPath());
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
                errorFound = true;
                return result;
            }
        }

        try {
            input = new BufferedReader(new FileReader(inputPath));
            String line;
            
            int currLine = 0;
            while ((line = input.readLine()) != null) {
                currLine++;
                if (line.contains(regex)) {
                    String[] splitLine = line.split(regex);
                    result += splitLine.length;
                    for (int i = 0; i < splitLine.length; i++) {
                        linesAt.add(currLine);                        
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            errorFound = true;
        } catch (IOException e) {
            System.out.println("Couldn't read file!");
            errorFound = true;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println("Couldn't close resource!");
                    errorFound = true;
                }
            }
        }
        return result;
    }

}
