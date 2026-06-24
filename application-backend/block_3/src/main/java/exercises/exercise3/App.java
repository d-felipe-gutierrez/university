package exercises.exercise3;

import exercises.util.Menu;
import exercises.util.MenuItem;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese los atributos correspondientes a la cafetera...");

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Capacidad maxima: ");
        Integer capacidadMaxima = sc.nextInt();

        CafeteraInteligente cafetera = new CafeteraInteligente(marca, modelo, capacidadMaxima);

        MenuItem[] ops = {
                new MenuItem("1", "Encender") {
                    @Override
                    public void execute() {
                        System.out.println(cafetera.encender());
                    }
                },
                new MenuItem("2", "Apagar") {
                    @Override
                    public void execute() {
                        System.out.println(cafetera.apagar());
                    }
                },
                new MenuItem("3", "Cargar agua") {
                    @Override
                    public void execute() {
                        System.out.println("Cuanta agua desea cargar?");

                        Integer cantidad = sc.nextInt();
                        System.out.println(cafetera.cargarAgua(cantidad));
                    }
                },
                new MenuItem("4", "Calentar") {
                    @Override
                    public void execute() {
                        System.out.println(cafetera.calentar());
                    }
                },
                new MenuItem("5", "Servir cafe") {
                    @Override
                    public void execute() {
                        System.out.println(cafetera.servirCafe());
                    }
                },
                new MenuItem("6", "Mostrar info. cafetera") {
                    @Override
                    public void execute() {
                        System.out.println(cafetera);
                    }
                }
        };

        Menu menu = new Menu("Que desea hacer con la cafetera?", ops, "0", "Finalizar uso de cafetera");

        menu.run();
    }
}
