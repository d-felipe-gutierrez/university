package exercises.exercise4;

import util.*;

public class App {
    public static void main() {
        MenuItem[] ops = {
                new MenuItem("1", "Crear biblioteca con carga de libros desde csv") {
                    @Override
                    public void execute() {
                        Biblioteca biblioteca = new Biblioteca();
                        System.out.println("\n" + biblioteca);
                    }
                }
        };

        Menu menu = new Menu("Bienvenido al \"Sistema Biblioteca Editorial\". Que desea hacer?",
                ops, "q", "Salir del sistema");

        menu.run();
    }
}
