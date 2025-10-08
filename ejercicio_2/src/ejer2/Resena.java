package ejer2;

public class Resena {
    private String username;
    private String productoId;
    private int calificacion;
    private String comentario;
    private String fecha;

    public Resena(String username, String productoId, int calificacion, String comentario, String fecha) {
        this.username = username;
        this.productoId = productoId;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    // Getters
    public String getUsername() { return username; }
    public String getProductoId() { return productoId; }
    public int getCalificacion() { return calificacion; }
    public String getComentario() { return comentario; }
    public String getFecha() { return fecha; }
}