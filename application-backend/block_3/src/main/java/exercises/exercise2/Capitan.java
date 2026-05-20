package exercises.exercise2;

public class Capitan {
    private String ident;
    private String nombre;
    private String apellido;
    private int antig;

    public Capitan(String ident, String nombre, String apellido, int antig) {
        this.ident = ident;
        this.nombre = nombre;
        this.apellido = apellido;
        this.antig = antig;
    }

    public int getAntig() {
        return antig;
    }
}
