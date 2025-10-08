package ejer1;

import java.util.ArrayList;
import java.util.List;

public class CarritoModelo {
    private List<ItemCarrito> items;
    private List<String> historialCompras;
    private double descuento;
    private double costoEnvio;

    public CarritoModelo() {
        this.items = new ArrayList<>();
        this.historialCompras = new ArrayList<>();
        this.descuento = 0.0;
        this.costoEnvio = 5.0; // Costo base de envío
    }

    public void agregarProducto(Producto producto, int cantidad) {
        for (ItemCarrito item : items) {
            if (item.getProducto().getId().equals(producto.getId())) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }
        items.add(new ItemCarrito(producto, cantidad));
    }

    public void eliminarProducto(String productoId) {
        items.removeIf(item -> item.getProducto().getId().equals(productoId));
    }

    public void actualizarCantidad(String productoId, int cantidad) {
        for (ItemCarrito item : items) {
            if (item.getProducto().getId().equals(productoId)) {
                if (cantidad <= 0) {
                    eliminarProducto(productoId);
                } else {
                    item.setCantidad(cantidad);
                }
                return;
            }
        }
    }

    public double calcularTotal() {
        double subtotal = items.stream()
                .mapToDouble(ItemCarrito::getSubtotal)
                .sum();
        return subtotal - descuento + costoEnvio;
    }

    public void aplicarDescuento(double porcentaje) {
        double subtotal = items.stream()
                .mapToDouble(ItemCarrito::getSubtotal)
                .sum();
        this.descuento = subtotal * (porcentaje / 100);
    }

    public void calcularEnvio(String direccion) {
        // Lógica simplificada para cálculo de envío
        if (direccion.toLowerCase().contains("centro")) {
            this.costoEnvio = 2.0;
        } else {
            this.costoEnvio = 5.0;
        }
    }

    public void realizarCompra() {
        if (!items.isEmpty()) {
            String compra = "Compra realizada - Total: $" + String.format("%.2f", calcularTotal());
            historialCompras.add(compra);
            items.clear();
            descuento = 0.0;
        }
    }

    // Getters
    public List<ItemCarrito> getItems() { return items; }
    public List<String> getHistorialCompras() { return historialCompras; }
    public double getDescuento() { return descuento; }
    public double getCostoEnvio() { return costoEnvio; }
}