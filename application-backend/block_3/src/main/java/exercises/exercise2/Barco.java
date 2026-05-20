package exercises.exercise2;

public class Barco {
    private String matricula;
    private int numMuelle;
    private int capCarga;
    private float costoAlq;
    private Capitan capitan;

    public Barco(String matricula, int numMuelle, int capCarga, float costoAlq, Capitan capitan) {
        this.matricula = matricula;
        this.numMuelle = numMuelle;
        this.capCarga = capCarga;
        this.costoAlq = costoAlq;
        this.capitan = capitan;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getNumMuelle() {
        return numMuelle;
    }

    public int getCapCarga() {
        return capCarga;
    }

    public float getCostoAlq() {
        return costoAlq;
    }

    public Capitan getCapitan() {
        return capitan;
    }
}
