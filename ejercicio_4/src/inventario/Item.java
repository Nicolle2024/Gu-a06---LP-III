package inventario;

public class Item {
    private String nombre;
    private int cantidad;
    private String tipo;
    private String descripcion;

    public Item(String nombre, int cantidad, String tipo, String descripcion) {
        this.nombre = nombre;
        this.setCantidad(cantidad);
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    // añadido al esquema
    public int getCantidad() {
        return cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void usarItem() {
        if (cantidad > 0) {
            setCantidad(cantidad - 1);
            System.out.println("\nHas usado el ítem: " + nombre + ". Cantidad restante: " + cantidad);
        } else {
            System.out.println("No quedan más unidades de " + nombre);
        }
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") x" + cantidad;
    }

    // añadido al esquema
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}