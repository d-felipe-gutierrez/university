package guia_ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioTres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        do {
            System.out.println("Ingrese un numero entero positivo");
            n = sc.nextInt();
        } while (n <= 0);

        System.out.println(buscarMultiplos(n));
    }

    public static ArrayList<Integer> buscarMultiplos(int n) {
        ArrayList<Integer> multiplos = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i%3 == 0 ^ i%5 == 0) {
                multiplos.add(i);
            }
        }

        return multiplos;
    }
}