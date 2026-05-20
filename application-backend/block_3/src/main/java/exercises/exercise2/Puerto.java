package exercises.exercise2;

import java.util.ArrayList;

public class Puerto {

    private ArrayList<Barco> barcos;

    public Puerto() {
        barcos = new ArrayList<>();
    }

    public void agregarBarco(Barco barco) {
        barcos.add(barco);
    }

    public ArrayList<Barco> getBarcos() {
        return barcos;
    }

    // Punto 3
    public double calcularRecaudacionTotal() {

        double total = 0;

        for (Barco b : barcos) {
            total += b.getCostoAlq() * 15;
        }

        return total;
    }

    // Punto 4
    public void mostrarBarcosCapitanExperimentado() {

        for (Barco b : barcos) {

            if (b.getCapitan().getAntig() > 18) {

                System.out.println("Matricula: " + b.getMatricula());
                System.out.println("Numero muelle: " + b.getNumMuelle());
                System.out.println("Capacidad de carga: " + b.getCapCarga());
                System.out.println("Costo alquiler: " + b.getCostoAlq());

                System.out.println(
                        "Capitan: "
                                + b.getCapitan().getNombre()
                                + " "
                                + b.getCapitan().getApellido()
                );

                System.out.println(
                        "Antiguedad: "
                                + b.getCapitan().getAntig()
                );

                System.out.println();
            }
        }
    }

    // Punto 5
    public double calcularPromedioCargaMuellePar() {

        int totalCarga = 0;
        int cantidad = 0;

        for (Barco b : barcos) {

            if (b.getNumMuelle() % 2 == 0) {

                totalCarga += b.getCapCarga();
                cantidad++;
            }
        }

        if (cantidad == 0) {
            return 0;
        }

        return (double) totalCarga / cantidad;
    }

    public void mostrarBarcos() {

        for (Barco b : barcos) {

            System.out.println("Matricula: " + b.getMatricula());
            System.out.println("Numero muelle: " + b.getNumMuelle());
            System.out.println("Capacidad de carga: " + b.getCapCarga());
            System.out.println("Costo alquiler: " + b.getCostoAlq());

            System.out.println(
                    "Capitan: "
                            + b.getCapitan().getNombre()
                            + " "
                            + b.getCapitan().getApellido()
            );

            System.out.println();
        }
    }
}
