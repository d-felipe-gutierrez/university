package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EjercicioSeis {
    public static void main( String[] args ) {
        File archivo = new File("public/numeros.txt");
        int cNums = 0;
        int cNoNums = 0;
        int cPares = 0;
        int cImpares = 0;
        int sum = 0;

        try (Scanner sc = new Scanner(archivo)) {
            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    int num = sc.nextInt();
                    cNums++;

                    if (num % 2 == 0) {
                        cPares++;
                    } else {
                        cImpares++;
                    }

                    sum += num;
                } else {
                    cNoNums++;
                    sc.next();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo: " + e.getMessage());
        }

        System.out.println("Cantidad de números leídos: " + cNums);
        System.out.println("Cantidad de líneas/datos no válidos: " + cNoNums);
        System.out.println("Cantidad de números pares: " + cPares);
        System.out.println("Cantidad de números impares: " + cImpares);
        System.out.println("Promedio: " + calcularProm(sum, cNums));
    }
    public static double calcularProm(int sum, int cNums) {
        if (cNums == 0) {
            return 0.0;
        }
        return (double) sum / cNums;
    }
}