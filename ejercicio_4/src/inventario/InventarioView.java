package inventario;

import java.util.List;

public class InventarioView {

    public void mostrarInventario(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("\n [El inventario está vacío ]");
        } else {
            System.out.println("=== Inventario del Jugador ===");
            for (Item item : items) {
                System.out.println("- " + item);
            }
        }
        System.out.println();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarDetallesItem(Item item) {
        if (item != null) {
            System.out.println("\n=== Detalles del Ítem ===");
            System.out.println("Nombre: " + item.getNombre());
            System.out.println("Tipo: " + item.getTipo());
            System.out.println("Cantidad: " + item.getCantidad());
            System.out.println("Descripción: " + item.getDescripcion());
        } else {
            System.out.println("\n[ Ítem no encontrado ]");
        }
        System.out.println();
    }
    
    public void mostrarMenu() {
    	System.out.println("=== MENÚ DEL INVENTARIO ===");
        System.out.println("1. Agregar ítem");
        System.out.println("2. Eliminar ítem");
        System.out.println("3. Ver inventario");
        System.out.println("4. Mostrar detalles de un ítem");
        System.out.println("5. Buscar ítem");
        System.out.println("6. Usar ítem");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
}