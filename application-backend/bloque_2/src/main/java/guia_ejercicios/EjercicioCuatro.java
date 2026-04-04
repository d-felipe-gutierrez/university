package guia_ejercicios;

import java.util.Scanner;

public class EjercicioCuatro {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la cantidad de horas trabajadas: ");
        int cantHoras = sc.nextInt();
        System.out.print("Ingrese la cantidad de tareas completadas: ");
        int cantTareas = sc.nextInt();

        int indicieProd = calcularIndice(cantTareas, cantHoras);

        System.out.println("- Nombre: " + nombre);
        System.out.println("- Horas trabajadas: " + cantHoras);
        System.out.println("- Tareas completadas: " + cantTareas);
        System.out.println("- Indice de productividad: " + indicieProd);
    }

    public static int calcularIndice(int cantTareas, int cantHoras) {
        int res = 0;

        if (cantHoras <= 8) {
            res = cantTareas*10 - 5*(8 - cantHoras);
        } else {
            res = cantTareas*10 + 5;
        }

        return res;
    }
}
