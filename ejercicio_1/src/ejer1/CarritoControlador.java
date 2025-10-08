package ejer1;

import java.util.ArrayList;
import java.util.List;

public class CarritoControlador {
    private CarritoModelo modelo;
    private CarritoVista vista;
    private List<Producto> productos;

    public CarritoControlador(CarritoModelo modelo, CarritoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.productos = new ArrayList<>();
        inicializarProductos();
    }

    private void inicializarProductos() {
        productos.add(new Producto("P001", "Laptop", 1200.00, 10));
        productos.add(new Producto("P002", "Mouse", 25.50, 50));
        productos.add(new Producto("P003", "Teclado", 45.00, 30));
        productos.add(new Producto("P004", "Monitor", 300.00, 15));
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            String opcionStr = vista.leerOpcion();
            try {
                opcion = Integer.parseInt(opcionStr);
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    agregarProductoAlCarrito();
                    break;
                case 2:
                    verCarrito();
                    break;
                case 3:
                    eliminarProductoDelCarrito();
                    break;
                case 4:
                    aplicarDescuento();
                    break;
                case 5:
                    calcularEnvio();
                    break;
                case 6:
                    verHistorialCompras();
                    break;
                case 7:
                    realizarCompra();
                    break;
                case 8:
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida");
            }
        } while (opcion != 8);
        
        vista.cerrarScanner();
    }

    private void agregarProductoAlCarrito() {
        vista.mostrarMensaje("\nProductos disponibles:");
        for (Producto producto : productos) {
            System.out.printf("%s - %s - $%.2f - Stock: %d%n",
                producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getStock());
        }

        String productoId = vista.leerProductoId();
        Producto productoSeleccionado = null;

        for (Producto producto : productos) {
            if (producto.getId().equals(productoId)) {
                productoSeleccionado = producto;
                break;
            }
        }

        if (productoSeleccionado != null) {
            int cantidad = vista.leerCantidad();
            if (cantidad > 0 && cantidad <= productoSeleccionado.getStock()) {
                modelo.agregarProducto(productoSeleccionado, cantidad);
                vista.mostrarMensaje("Producto agregado al carrito");
            } else {
                vista.mostrarMensaje("Cantidad no válida o stock insuficiente");
            }
        } else {
            vista.mostrarMensaje("Producto no encontrado");
        }
    }

    private void verCarrito() {
        vista.mostrarCarrito(modelo.getItems(), modelo.getDescuento(), 
                           modelo.getCostoEnvio(), modelo.calcularTotal());
    }

    private void eliminarProductoDelCarrito() {
        String productoId = vista.leerProductoId();
        modelo.eliminarProducto(productoId);
        vista.mostrarMensaje("Producto eliminado del carrito");
    }

    private void aplicarDescuento() {
        double porcentaje = vista.leerPorcentajeDescuento();
        modelo.aplicarDescuento(porcentaje);
        vista.mostrarMensaje("Descuento aplicado: " + porcentaje + "%");
    }

    private void calcularEnvio() {
        String direccion = vista.leerDireccion();
        modelo.calcularEnvio(direccion);
        vista.mostrarMensaje("Cálculo de envío actualizado");
    }

    private void verHistorialCompras() {
        vista.mostrarHistorial(modelo.getHistorialCompras());
    }

    private void realizarCompra() {
        if (modelo.getItems().isEmpty()) {
            vista.mostrarMensaje("El carrito está vacío");
        } else {
            modelo.realizarCompra();
            vista.mostrarMensaje("¡Compra realizada exitosamente!");
        }
    }
}