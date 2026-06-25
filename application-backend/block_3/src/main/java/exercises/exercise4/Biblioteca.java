package exercises.exercise4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Biblioteca {
    private Libro[] libros;
    private int cantidadLibros;
    private static final int MAX_LIBROS = 10;
    private File f;
    private Scanner sc;

    public Biblioteca() {
        libros = new Libro[MAX_LIBROS];
        cantidadLibros = 0;

        try {
            f = new File("block_3/src/main/resources/libros.csv");
            sc = new Scanner(f);

            cargarLibros();
        } catch(FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo: " + e);
        }
    }

    public void cargarLibros(){
        if (sc.hasNextLine()) {
            sc.nextLine();
        }

        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            String[] columnas = linea.split(",");

            String isbn = columnas[0];
            String titulo = columnas[1];
            Integer nroEstante = Integer.parseInt(columnas[2]);
            Integer paginas = Integer.parseInt(columnas[3]);
            Double precioPorDia = Double.parseDouble(columnas[4]);

            String autorId = columnas[5];
            String autorNombre = columnas[6];
            String autorApellido = columnas[7];
            Integer autorAniosCarrera = Integer.parseInt(columnas[8]);

            Autor autor = new Autor(autorId, autorNombre, autorApellido, autorAniosCarrera);
            Libro libro = new Libro(isbn, titulo, nroEstante, paginas, precioPorDia, autor);

            libros[cantidadLibros] = libro;
            cantidadLibros++;
        }
    }

    public String agruparLibros() {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i < cantidadLibros; i++) {
            Libro libro = libros[i];

            if (i > 0) {
                sb.append("\n\n");
                sb.append(libro.toString());
            } else {
                sb.append(libro.toString());
            }
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("* Cantidad libros: %d\n" +
                "* Maximos libros: %d\n" +
                "* Libros:\n" + agruparLibros(), cantidadLibros, MAX_LIBROS);
    }
}
