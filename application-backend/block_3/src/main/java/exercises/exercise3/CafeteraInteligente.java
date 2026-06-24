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
        setContenidoActual(0);
        setEncendida(false);
        setCafesServidos(0);
        setTemperatura(0);
    }

    public String setCapacidadMaxima(Integer capacidadMaxima) {
        if (capacidadMaxima >= 100) {
            this.capacidadMaxima = capacidadMaxima;
            return "La capacidad se establecio correctamente.";
        } else {
            return "La capacidad maxima debe ser al menos de 100ml...";
        }
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

    public String encender() {
        if (encendida) {
            return "La cafetera ya esta encendida...";
        } else {
            setEncendida(true);
            setTemperatura(20);
            setContenidoActual(0);

            return "La cafetera se encendio...\n" +
                    "Se establecio la temperatura en " + temperatura + "°C.\n" +
                    "Se establecio el contenido actual en " + contenidoActual + "ml.";
        }
    }

    public String apagar() {
        if (encendida) {
            setEncendida(false);
            setCafesServidos(0);

           return "La cafetera se apago...\n" +
                    "Se establecio la cantidad de cafe servido en " + cafesServidos;
        } else {
            return "La cafetera ya esta apagada...";
        }
    }

    public String cargarAgua(Integer cantidad) {
        if (encendida) {
            setContenidoActual(contenidoActual + cantidad);

            return "La cafetera fue cargada con agua...\n" +
                    "Se establecio la cantidad de agua en la cafetera en " + contenidoActual;
        } else {
            return "No se puede cargar agua debido a que la cafetera no esta prendida...";
        }
    }

    public String calentar() {
        if (encendida) {
            setTemperatura(temperatura + 40);

            return "La cafetera se calento...\n" +
                    "Se establecio la cantidad de temperatura en " + temperatura;
        } else {
            return "No se puede cargar agua debido a que la cafetera no esta prendida...";
        }
    }

    public String servirCafe() {
        if (!encendida) {
            return "No se puede cargar agua debido a que la cafetera no esta prendida...";
        } else if (contenidoActual < 100) {
            return "No se puede cargar agua debido a que la cafetera no alcanza los 100ml...";
        } else if (temperatura < 90) {
            return "No se puede cargar agua debido a que la temperatura no alcanza los 90°C...";
        } else {
            setContenidoActual(contenidoActual - 100);
            setCafesServidos(++cafesServidos);

            return "Se sirvio cafe a un cliente\n" +
                    "Se establecio la cantidad de cafe servido en " + cafesServidos + " unidades\n" +
                    "Se establecio el contenido actual en " + contenidoActual + "ml.";
        }
    }

    @Override
    public String toString() {
        String estado = encendida ? "encendida" : "apagada";

        return String.format("Cafetera %s %s - Agua %dml, Temperatura: %d°C, Servidos: %d, Estado: %s",
                marca, modelo, contenidoActual, temperatura, cafesServidos, estado);
    }
}