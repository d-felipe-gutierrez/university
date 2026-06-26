package exercises.exercise4;

public class Autor {
    private String id;
    private String nombre;
    private String apellido;
    private Integer aniosCarrera;

    public Autor(String id, String nombre, String apellido, Integer aniosCarrera) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.aniosCarrera = aniosCarrera;
    }

    public boolean conTrayectoria() {
        if (aniosCarrera > 18) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("[Id: %s; Nombre: %s; Apellido: %s; Años carrera: %d]",
                id, nombre, apellido, aniosCarrera);
    }
}
