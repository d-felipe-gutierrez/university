package exercises.exercise2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main (String[] args) throws FileNotFoundException
    {
        File f = new File("src/main/java/exercises/exercise2/public/barcos.csv");
        Scanner sc = new Scanner(f);
        String linea;
        ArrayList<Barco> barcos = new ArrayList<>();

        if (sc.hasNextLine())
            linea = sc.nextLine();

        while (sc.hasNextLine()) {
            linea = sc.nextLine();
            String[] columnas = linea.split(",");

            String matricula = columnas[0];
            int numMuelle = Integer.parseInt(columnas[1]);
            int capCarga = Integer.parseInt(columnas[2]);
            float costoAlq = Float.parseFloat(columnas[3]);

            String ident = columnas[4];
            String nombre = columnas[5];
            String apellido = columnas[6];
            int antig = Integer.parseInt(columnas[7]);

            Capitan capitan = new Capitan(ident, nombre, apellido, antig);
            Barco barco = new Barco(matricula, numMuelle, capCarga, costoAlq, capitan);

            barcos.add(barco);
        }

        sc.close();

        for (Barco b : barcos) {
            System.out.println("Matricula: " + b.getMatricula() + "\n" +
                    "Numero muelle: " + b.getNumMuelle() + "\n" +
                    "Capacidad de carga: " + b.getCapCarga() + "\n" +
                    "Costo alquiler: " + b.getCostoAlq() + "\n\n");
        }

        double recaudTotal = 0;

        for (Barco b : barcos) {
            recaudTotal += 15 * b.getCostoAlq();;
        }

        System.out.printf("%.4f%n", recaudTotal);
        System.out.println("");

        for (Barco b : barcos) {
            if (b.getCapitanAntig() > 18)
                System.out.println("Matricula: " + b.getMatricula() + "\n" +
                        "Numero muelle: " + b.getNumMuelle() + "\n" +
                        "Capacidad de carga: " + b.getCapCarga() + "\n" +
                        "Costo alquiler: " + b.getCostoAlq() + "\n" +
                        "Antiguedad capitan: " + b.getCapitanAntig() + "\n\n");
        }

        int cTons = 0;
        int totalTons = 0;

        for (Barco b : barcos) {
            if (b.getNumMuelle() % 2 == 0){
                totalTons += b.getCapCarga();
                cTons ++;
            }
        }

        System.out.println("La cantidad promedio de carga es: " + (totalTons/cTons));
    }
}
