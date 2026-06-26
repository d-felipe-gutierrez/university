package exercises.exercise4;

public class Libro {
    private String isbn;
    private String titulo;
    private Integer nroEstante;
    private Integer paginas;
    private Double precioPorDia;
    private Autor autor;

    public Libro(String isbn, String titulo, Integer nroEstante, Integer paginas, Double precioPorDia, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.nroEstante = nroEstante;
        this.paginas = paginas;
        this.precioPorDia = precioPorDia;
        this.autor = autor;
    }

    public Double getPrecioPorDia() {
        return precioPorDia;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public boolean autorConTrayectoria() {
        return autor.conTrayectoria();
    }

    public boolean esEstantePar() {
        return (nroEstante % 2 == 0);
    }

    @Override
    public String toString() {
        return String.format("     - ISBN: %s\n" +
                "     - Titulo: %s\n" +
                "     - Numero de estante: %d\n" +
                "     - Paginas: %d\n" +
                "     - Precio por dia: %.2f\n" +
                "     - Autor: " + autor.toString(), isbn, titulo, nroEstante, paginas, precioPorDia);
    }
}
