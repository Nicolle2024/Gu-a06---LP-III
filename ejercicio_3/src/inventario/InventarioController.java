package inventario;

public class InventarioController {
    private InventarioModel model;
    private InventarioView view;

    public InventarioController(InventarioModel model, InventarioView view) {
        this.model = model;
        this.view = view;
    }

    public void agregarItem(String nombre, int cantidad, String tipo, String descripcion) {
        Item existente = model.buscarItem(nombre);
        if (existente != null) {
            existente.setCantidad(existente.getCantidad() + cantidad);
        	view.mostrarMensaje("\nEl ítem ya existe. Se incremento su cantidad. " + existente);
            
        } else {
            Item nuevoItem = new Item(nombre, cantidad, tipo, descripcion);
            model.agregarItem(nuevoItem);
            view.mostrarMensaje("\nSe agregó al inventario: " + nuevoItem);
        }
    }

    public void eliminarItem(String nombre) {
        Item item = model.buscarItem(nombre);
        if (item != null) {
            model.eliminarItem(item);
            view.mostrarMensaje("Se eliminó del inventario: " + nombre);
        } else {
            view.mostrarMensaje("El ítem '" + nombre + "' no existe.");
        }
    }

    public void verInventario() {
        view.mostrarInventario(model.obtenerItems());
    }

    public void mostrarDetalles(String nombre) {
        Item item = model.buscarItem(nombre);
        view.mostrarDetallesItem(item);
    }

    public void buscarItem(String nombre) {
        Item item = model.buscarItem(nombre);
        if (item != null) {
            view.mostrarMensaje("\nÍtem encontrado: " + item);
        } else {
            view.mostrarMensaje("\nNo se encontró el ítem '" + nombre + "'");
        }
    }

    public void usarItem(String nombre) {
        Item item = model.buscarItem(nombre);
        if (item != null) {
            item.usarItem();
        } else {
            view.mostrarMensaje("\nNo se encontró el ítem '" + nombre + "'");
        }
    }
}
