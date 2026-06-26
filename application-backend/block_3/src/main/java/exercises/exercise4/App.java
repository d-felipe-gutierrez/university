package exercises.exercise4;

import util.*;

public class App {
    private static Biblioteca biblioteca;

    public static void main() {
        MenuItem[] ops = {
                new MenuItem("1", "Crear biblioteca con carga de libros desde csv") {
                    @Override
                    public void execute() {
                        biblioteca = new Biblioteca();
                        System.out.println("\n" + biblioteca);
                    }
                },
                new MenuItem("2", "Calcular recaudacion estimada") {
                    @Override
                    public void execute() {
                        try {
                            System.out.println("\nLa recaudacion estimada es de " + biblioteca.estimarRecaudacion());
                        } catch(NullPointerException e) {
                            System.out.println("No se cargaron los datos de ninguna biblioteca: " + e);
                        }
                    }
                },
                new MenuItem("3", "Mostrar autores con trayectoria") {
                    @Override
                    public void execute() {
                        try {
                            System.out.println("La cantidad de autores con trayectoria es de: " + biblioteca.autoresConTrayectoria());
                        } catch(NullPointerException e) {
                            System.out.println("No se cargaron los datos de ninguna biblioteca: " + e);
                        }
                    }
                },
                new MenuItem("4", "Calcular promedio de paginas en libros ubicados en estantes pares") {
                    @Override
                    public void execute() {
                        try {
                            System.out.println("El promedio de paginas de libros en estanterias ubicadas en posiciones de estantes pares, es de: " + biblioteca.promedioPaginas());
                        } catch(NullPointerException e) {
                            System.out.println("No se cargaron los datos de ninguna biblioteca: " + e);
                        }
                    }
                }
        };

        Menu menu = new Menu("Bienvenido al \"Sistema Biblioteca Editorial\". Que desea hacer?",
                ops, "q", "Salir del sistema");

        menu.run();
    }
}
