package guia_ejercicios;

public class Mascota {
    short energia;
    short humor;
    boolean dormido = false;
    boolean vivo = true;
    short numIngesta = 0;
    short numActividades = 0;

    // Constructor
    public Mascota(short energia, short humor) {
        setEnergia(energia);
        setHumor(humor);
    }

    // Setters
    public void setEnergia (short energia) {
        if (energia >= 0 && energia <= 100) {
            this.energia = energia;
        } else {
            throw new IllegalArgumentException("La energía debe estar entre 0 y 100");
        }

        if (energia == 0) {
            morir();
        }
    }

    public void setHumor (short humor) {
        if (humor >= 1 && humor <= 5) {
            this.humor = humor;
        } else {
            throw new IllegalArgumentException("El humor debe estar entre 1 y 5");
        }
    }

    // Getters
    public short getEnergia () {
        return energia;
    }

    public short getHumor () {
        return humor;
    }

    // Comportamientos de ingesta
    public void comer () {
        if (dormido) {
            System.out.println("La mascota esta durmiendo...");
            return;
        }

        short nuevaEnergia = (short) (energia+10);

        if (nuevaEnergia <= 100) {
            setEnergia(nuevaEnergia);
        } else {
            setEnergia((short) 100);
        }

        if (humor < 5) {
            humor += 1;
        }

        numActividades = 0;
        numIngesta++;
        comprobarIngesta(numIngesta);
    }

    public void beber () {
        if (dormido) {
            System.out.println("La mascota esta durmiendo...");
            return;
        }

        short nuevaEnergia = (short) (energia+5);

        if (nuevaEnergia <= 100) {
            setEnergia(nuevaEnergia);
        } else {
            setEnergia((short) 100);
        }

        if (humor < 5) {
            humor += 1;
        }

        numActividades = 0;
        numIngesta++;
        comprobarIngesta(numIngesta);
    }

    public void comprobarIngesta(short numIngesta) {
        if (numIngesta >= 5) {
            morir();
        } else if (numIngesta >= 3) {
            if (humor <= 1) {
                humor = 0;
            } else {
                humor--;
            }
        }
    }

    // Comportamientos de actividades
    public void correr () {
        if (dormido) {
            System.out.println("La mascota esta durmiendo...");
            return;
        }

        setEnergia((short) (energia-35));

        if (humor >= 2) {
            humor = 0;
        } else {
            humor -= 2;
        }

        numIngesta = 0;
        numActividades++;
        comprobarActividades(numActividades);
    }

    public void saltar () {
        if (dormido) {
            System.out.println("La mascota esta durmiendo...");
            return;
        }

        setEnergia((short) (energia-15));

        if (humor <= 2) {
            humor = 0;
        } else {
            humor -= 2;
        }

        numIngesta = 0;
        numActividades++;
        comprobarActividades(numActividades);
    }

    public void comprobarActividades (short numActividades) {
        if (numActividades >= 3) {
            dormir();
        }
    }

    // Otros comportamientos
    public void dormir () {
        if (dormido) {
            System.out.println("La mascota ya esta dormida...");
            return;
        }

        dormido = true;

        short nuevaEnergia = (short) (energia+25);

        if (nuevaEnergia <= 100) {
            energia = nuevaEnergia;
        } else {
            energia = 100;
        }

        if (humor >= 3) {
            humor = 5;
        } else {
            humor += 2;
        }

        numIngesta = 0;
    }

    public void despertar () {
        if (!dormido) {
            System.out.println("La mascota ya esta despierta...");
            return;
        }

        dormido = false;

        if (humor <= 1) {
            humor = 0;
        } else {
            humor--;
        }
    }

    public void morir () {
        System.out.println("Tu mascota ha muerto de cansancio 0_0");

        vivo = false;
    }
}