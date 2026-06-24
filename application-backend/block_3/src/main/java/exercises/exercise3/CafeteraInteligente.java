package exercises.exercise3;

public class CafeteraInteligente {
    private String marca;
    private String modelo;
    private Integer capacidadMaxima;
    private Integer contenidoActual;
    private Boolean encendida;
    private Integer cafesServidos;
    private Integer temperatura;

    public CafeteraInteligente(String marca, String modelo, Integer capacidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.setCapacidadMaxima(capacidadMaxima);
        setEncendida(false);
        setCafesServidos(0);
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setContenidoActual(Integer contenidoActual) {
        if (contenidoActual < 0) {
            this.contenidoActual = 0;
        } else if (contenidoActual > capacidadMaxima) {
            this.contenidoActual = capacidadMaxima;
        } else {
            this.contenidoActual = contenidoActual;
        }
    }

    public void setEncendida(Boolean encendida) {
        this.encendida = encendida;
    }

    public void setCafesServidos(Integer cafesServidos) {
        this.cafesServidos = cafesServidos;
    }

    public void setTemperatura(Integer temperatura) {
        if (temperatura < 20) {
            this.temperatura = 20;
        } else if (temperatura > 100) {
            this.temperatura = 100;
        } else {
            this.temperatura = temperatura;
        }
    }

    public void encender() {
        if (encendida) {
            System.out.println("La cafetera ya esta encendida...");
        } else {
            setEncendida(true);
            setTemperatura(20);
            setContenidoActual(0);

            System.out.println("La cafetera se encendio...\n" +
                    "Se establecio la temperatura en " + temperatura + "°C.\n" +
                    "Se establecio el contenido actual en " + contenidoActual + "ml.");
        }
    }

    public void apagar() {
        if (encendida) {
            setEncendida(false);
            setCafesServidos(0);

            System.out.println("La cafetera se apago...\n" +
                    "Se establecio la cantidad de cafe servido en " + cafesServidos);
        } else {
            System.out.println("La cafetera ya esta apagada...");
        }
    }

    public void cargarAgua(Integer cantidad) {
        if (encendida) {
            setContenidoActual(contenidoActual + cantidad);

            System.out.println("La cafetera fue cargada con agua...\n" +
                    "Se establecio la cantidad de agua en la cafetera en " + contenidoActual);
        } else {
            System.out.println("No se puede cargar agua debido a que la cafetera no esta prendida...");
        }
    }

    public void calentar() {
        if (encendida) {
            setTemperatura(temperatura + 40);

            System.out.println("La cafetera se calento...\n" +
                    "Se establecio la cantidad de temperatura en " + temperatura);
        } else {
            System.out.println("No se puede cargar agua debido a que la cafetera no esta prendida...");
        }
    }

    public boolean servirCafe() {
        if (!encendida) {
            System.out.println("No se puede cargar agua debido a que la cafetera no esta prendida...");
        } else if (contenidoActual < 100) {
            System.out.println("No se puede cargar agua debido a que la cafetera no alcanza los 100ml...");
        } else if (temperatura < 90) {
            System.out.println("No se puede cargar agua debido a que la temperatura no alcanza los 90°C...");
        } else {
            setContenidoActual(contenidoActual - 100);
            setCafesServidos(++cafesServidos);

            System.out.println("Se sirvio cafe a un cliente\n" +
                    "Se establecio la cantidad de cafe servido en " + cafesServidos + " unidades\n" +
                    "Se establecio el contenido actual en " + contenidoActual + "ml.");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String estado = encendida == true ? "encendida" : "apagada";

        return String.format("Cafetera %s %s - Agua %dml, Temperatura: %d°C, Servidos: %d, Estado: %s",
                marca, modelo, contenidoActual, temperatura, cafesServidos, estado);
    }
}