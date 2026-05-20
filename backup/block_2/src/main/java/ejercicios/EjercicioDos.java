package ejercicios;

import java.util.Scanner;

public class EjercicioDos {
    public static void main ( String[] args ) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Porvafor, ingrese el codigo del libro: ");
        String cadena = sc.nextLine();

        int[] cadenaFormateada = formatearCadena(cadena);
        System.out.println(comprobarCadena(cadenaFormateada));
    }

    public static int[] formatearCadena(String cadena) {
        int[] values = new int[10];
        short count = 0;

        for (int i = 0; i < cadena.length(); i++) {
            char num = cadena.charAt(i);

            if (num != '-') {
                values[count] = (int) num;
                count++;
            }
        }

        return values;
    }

    public static boolean comprobarCadena(int[] cadena) {
        int result = 0;
        short mult = 10;

        for (int i = 0; i < 10; i++) {
            result += cadena[i] * mult;
            mult--;
        }

        return result%11 == 0;
    }
}
