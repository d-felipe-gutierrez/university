package exercises.exercise2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static void main(String[] args)
            throws FileNotFoundException {

        File f =
                new File(
                        "src/main/java/exercises/exercise2/public/barcos.csv"
                );

        Scanner sc = new Scanner(f);

        Puerto puerto = new Puerto();

        if (sc.hasNextLine()) {
            sc.nextLine();
        }

        while (sc.hasNextLine()) {

            String linea = sc.nextLine();

            String[] columnas = linea.split(",");

            String matricula = columnas[0];

            int numMuelle =
                    Integer.parseInt(columnas[1]);

            int capCarga =
                    Integer.parseInt(columnas[2]);

            float costoAlq =
                    Float.parseFloat(columnas[3]);

            String ident = columnas[4];
            String nombre = columnas[5];
            String apellido = columnas[6];

            int antig =
                    Integer.parseInt(columnas[7]);

            Capitan capitan =
                    new Capitan(
                            ident,
                            nombre,
                            apellido,
                            antig
                    );

            Barco barco =
                    new Barco(
                            matricula,
                            numMuelle,
                            capCarga,
                            costoAlq,
                            capitan
                    );

            puerto.agregarBarco(barco);
        }

        sc.close();

        // Punto 2
        System.out.println("=== LISTA DE BARCOS ===");
        puerto.mostrarBarcos();

        // Punto 3
        System.out.println("=== RECAUDACION TOTAL ===");

        System.out.printf(
                "%.2f%n",
                puerto.calcularRecaudacionTotal()
        );

        // Punto 4
        System.out.println();
        System.out.println(
                "=== BARCOS CON CAPITANES DE MAS DE 18 ANIOS ==="
        );

        puerto.mostrarBarcosCapitanExperimentado();

        // Punto 5
        System.out.println(
                "Promedio de carga en muelles pares: "
                        + puerto.calcularPromedioCargaMuellePar()
        );
    }
}