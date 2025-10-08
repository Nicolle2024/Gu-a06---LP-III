package Actividad;

import java.util.List;
import java.util.Scanner;
public class PedidoVista {
	private Scanner scanner;
	public PedidoVista() {
	scanner = new Scanner(System.in);
}
public String solicitarNombrePlato() {
	String nombre;
    do {
        System.out.print("Introduce el nombre del plato: ");
        nombre = scanner.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
        }
    } while (nombre.isEmpty());
    return nombre;
}
public String solicitarTipoPlato() {
    String tipo;
    do {
        System.out.print("Introduce el tipo de plato (entrante/principal/postre): ");
        tipo = scanner.nextLine().trim();
        if (tipo.isEmpty()) {
            System.out.println("El tipo no puede estar vacío.");
        }
    } while (tipo.isEmpty());
    return tipo;
}

public void mostrarPedidos(List<Pedido> pedidos) {
	if (pedidos.isEmpty()) {
		System.out.println("No hay pedidos en la lista.");
	} else {
		System.out.println("Lista de Pedidos:");
		for (Pedido pedido : pedidos) {
			System.out.println("- " + pedido.getNombrePlato());
		}
	}
}
public void mostrarMenu() {
	System.out.println("\nOpciones:");
	System.out.println("1. Agregar Pedido");
	System.out.println("2. Mostrar Pedido");
	System.out.println("3. Eliminar Pedido");
	System.out.println("4. Buscar Pedido");
	System.out.println("5. Marcar pedido como completo");
	System.out.println("6. Mostrar pedidos pendientes");
	System.out.println("7. Mostrar historial");
	System.out.println("8. Salir");

}
public String solicitarOpcion() {
	System.out.print("Selecciona una opción: ");
	return scanner.nextLine();
}
public int leerEntero(String mensaje) {
    System.out.print(mensaje);
    while (!scanner.hasNextInt()) {
        System.out.print("Ingresa un número válido: ");
        scanner.next();
    }
    int valor = scanner.nextInt();
    scanner.nextLine(); 
    return valor;
}
public void mostrarMensaje(String mensaje) {
	System.out.println(mensaje);
}
public void cerrarScanner() {
	scanner.close();
}
}
