package exercises.exercise3;

public class CafeteraInteligente {
    private String marca;
    private String modelo;
    private Integer capacidadMaxima;
    private Integer contenidoActual;
    private Boolean encendida;
    private Integer cafesServidos;
    private Integer temperatura;

    public CafeteraInteligente(String marca, String modelo, Integer capacidadMaxima, Integer contenidoActual, Boolean encendida, Integer cafesServidos, Integer temperatura) {
        this.marca = marca;
        this.modelo = modelo;
        this.setCapacidadMaxima(capacidadMaxima);
        this.setContenidoActual(contenidoActual);
        this.setEncendida(encendida);
        this.setCafesServidos(cafesServidos);
        this.setTemperatura(temperatura);
    }

    public CafeteraInteligente(String marca, String modelo, Integer capacidadMaxima, Integer contenidoActual, Boolean encendida, Integer temperatura) {
        this.marca = marca;
        this.modelo = modelo;
        this.setCapacidadMaxima(capacidadMaxima);
        this.setContenidoActual(contenidoActual);
        this.setEncendida(encendida);
        this.setTemperatura(temperatura);
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
        setEncendida(true);
        setTemperatura(20);
        setContenidoActual(0);
    }

    public void apagar() {
        setEncendida(false);
        setCafesServidos(0);
    }

    public void cargarAgua(Integer cantidad) {
        if (!encendida) return;

        setContenidoActual(cantidad);
    }

    public void calentar() {
        if (encendida) setTemperatura(temperatura + 40);
    }

    public boolean servirCafe() {
        if (encendida && (contenidoActual >= 100) && (temperatura >= 90)) {
            setContenidoActual(contenidoActual - 100);
            setCafesServidos(++cafesServidos);
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        String estado = encendida == true ? "encendida" : "apagada";

        return String.format("Cafetera %s %s - Agua %dml, Temperatura: %d°C, Servidos: %d, Estado: %s",
                marca, modelo, contenidoActual, temperatura, cafesServidos, estado);
    }
}