package guia_ejercicios;

public class EjercicioUno {
    public static void main ( String[] args ) {
        figura1(4);
        System.out.println(' ');
        figura2(4);
        System.out.println(' ');
        figura3(5);
        System.out.println(' ');
        figura4(9);
    }

    public static void figura1(int lines) {
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print('*');
                System.out.print(' ');
            }

            System.out.println(' ');
        }

    }

    public static void figura2(int lines) {
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < 6; j++) {
                if (i%2 != 1) {
                    System.out.print('*');
                    System.out.print(' ');
                } else {
                    System.out.print(' ');
                    System.out.print('*');
                }
            }

            System.out.println(' ');
        }
    }

    public static void figura3(int lines) {
        for (int i =1; i <= lines; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print('*');
                System.out.print(' ');
            }

            System.out.println(' ');
        }
    }

    public static void figura4(int lines) {
        int half = lines/2 + 1;

        for (int i = 1; i <= lines; i++) {
            if (i <= half) {
                for (int j = 0; j < i; j++) {
                    System.out.print('*');
                    System.out.print(' ');
                }
            } else {
                for (int j = lines-i; j >= 0; j--) {
                    System.out.print('*');
                    System.out.print(' ');
                }
            }

            System.out.println(' ');
        }
    }
}