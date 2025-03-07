package apuntesclase.ficheros;

//1: Leer todos los archivos
//2: Leer ficheros y directorios y su tipo
//3: Leer el árbol de directorios y sus contenidos
//4: Sacar con el siguiente formato
/* 
 * [dir1]       [dir2]      [dir3]
 * [dir1-1]     d           g
 * b            e           h
 * c            f           i 
 */

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListarDirs {

    public static void main(String[] args) {

        Path currentDir = Paths.get("").toAbsolutePath();

        final File thisFile = new File("EjerciciosClasesJava\\src\\apuntesclase\\ficheros\\ListarDirs.java");
        final File parentFolder = thisFile.getParentFile();

        System.out.println("Fichero: " + parentFolder.getName());

        for (String f : parentFolder.getParentFile().list()) {
            System.out.println(f);
        }

    }
}
