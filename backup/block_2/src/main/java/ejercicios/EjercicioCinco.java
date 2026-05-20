package ejercicios;

import java.util.Scanner;
import java.util.ArrayList;

public class EjercicioCinco {
    public static void main( String[] args ) {
        int[] notas = tomarValores().stream().mapToInt(i -> i).toArray();
        int max = -1;
        int min = 11;
        int sum = 0;
        int cant = 0;
        int cantAp = 0;
        int cantDesap = 0;

        for (int nota : notas) {
            min = calcMin(nota, min);
            max = calcMax(nota, max);
            sum += nota;
            cant++;
            cantAp += calcAp(nota);
            cantDesap += calcDesap(nota);
        }
        double prom = calcProm(sum, cant);

        System.out.println("- Nota máxima: " + max);
        System.out.println("- Nota mínima: " + min);
        System.out.println("- Promedio: " + prom);
        System.out.println("- Aprobados: " + cantAp);
        System.out.println("- Desaprobados: " + cantDesap);
    }

    public static ArrayList<Integer> tomarValores() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> notas = new ArrayList<>();
        int n;

        System.out.println("Ingrese las notas de a una:");
        do {
            n = sc.nextInt();
            if (n > 0 && n < 10) {
                notas.add(n);
            } else {
                System.out.println("El numero no se guardo, por no estar en el rango apropiado.");
            }
        } while (n != -1);

        return notas;
    }

    public static int calcMin(int nota, int min) {
        if (nota < min) {
            min = nota;
        }
        return min;
    }

    public static int calcMax(int nota, int max) {
        if (nota > max) {
            max = nota;
        }
        return max;
    }

    public static double calcProm(int sum, int cant) {
        return (double) sum/cant;
    }

    public static short calcAp (int nota) {
        if (nota >= 6) {
            return 1;
        }
        return 0;
    }

    public static short calcDesap (int nota) {
        if (nota < 6) {
            return 1;
        }
        return 0;
    }
}
