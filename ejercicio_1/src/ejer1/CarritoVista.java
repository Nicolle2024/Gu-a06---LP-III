package ejer1;

import java.util.List;
import java.util.Scanner;

public class CarritoVista {
    private Scanner scanner;

    public CarritoVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE CARRITO DE COMPRAS ===");
        System.out.println("1. Agregar producto al carrito");
        System.out.println("2. Ver carrito");
        System.out.println("3. Eliminar producto del carrito");
        System.out.println("4. Aplicar descuento");
        System.out.println("5. Calcular envío");
        System.out.println("6. Ver historial de compras");
        System.out.println("7. Realizar compra");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public String leerOpcion() {
        return scanner.nextLine();
    }

    public String leerProductoId() {
        System.out.print("Ingrese ID del producto: ");
        return scanner.nextLine();
    }

    public String leerNombreProducto() {
        System.out.print("Ingrese nombre del producto: ");
        return scanner.nextLine();
    }

    public double leerPrecio() {
        System.out.print("Ingrese precio del producto: ");
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public int leerCantidad() {
        System.out.print("Ingrese cantidad: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public double leerPorcentajeDescuento() {
        System.out.print("Ingrese porcentaje de descuento: ");
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public String leerDireccion() {
        System.out.print("Ingrese dirección para cálculo de envío: ");
        return scanner.nextLine();
    }

    public void mostrarCarrito(List<ItemCarrito> items, double descuento, double costoEnvio, double total) {
        System.out.println("\n=== CARRITO DE COMPRAS ===");
        if (items.isEmpty()) {
            System.out.println("El carrito está vacío");
        } else {
            for (ItemCarrito item : items) {
                System.out.printf("%s - %d x $%.2f = $%.2f%n",
                    item.getProducto().getNombre(),
                    item.getCantidad(),
                    item.getProducto().getPrecio(),
                    item.getSubtotal());
            }
            System.out.printf("Descuento: -$%.2f%n", descuento);
            System.out.printf("Costo de envío: $%.2f%n", costoEnvio);
            System.out.printf("TOTAL: $%.2f%n", total);
        }
    }

    public void mostrarHistorial(List<String> historial) {
        System.out.println("\n=== HISTORIAL DE COMPRAS ===");
        if (historial.isEmpty()) {
            System.out.println("No hay compras realizadas");
        } else {
            for (String compra : historial) {
                System.out.println(compra);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}