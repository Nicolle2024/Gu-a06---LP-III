package inventario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventarioModel modelo = new InventarioModel();
        InventarioView vista = new InventarioView();
        InventarioController controlador = new InventarioController(modelo, vista);
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            vista.mostrarMenu();
            do {
                String opcionStr = sc.nextLine();
                try {
                    opcion = Integer.parseInt(opcionStr);
                } catch (NumberFormatException e) {
                    opcion = -1;
                    System.out.print("Seleccione una opción valida: ");
                }
            } while (opcion == -1);
            
            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad;
                    do {
                        String cantidadStr = sc.nextLine();
                        try {
                            cantidad = Integer.parseInt(cantidadStr);
                        } catch (NumberFormatException e) {
                            cantidad = -1;
                            System.out.print("Ingrese una cantidad válida: ");
                        }
                    } while (cantidad == -1);
                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = sc.nextLine();
                    controlador.agregarItem(nombre, cantidad, tipo, descripcion);
                }

                case 2 -> {
                    System.out.print("Ingrese el nombre del ítem a eliminar: ");
                    String nombre = sc.nextLine();
                    controlador.eliminarItem(nombre);
                }

                case 3 -> controlador.verInventario();

                case 4 -> {
                    System.out.print("Ingrese el nombre del ítem: ");
                    String nombre = sc.nextLine();
                    controlador.mostrarDetalles(nombre);
                }

                case 5 -> {
                    System.out.print("Ingrese el nombre del ítem: ");
                    String nombre = sc.nextLine();
                    controlador.buscarItem(nombre);
                }

                case 6 -> {
                    System.out.print("Ingrese el nombre del ítem que desea usar: ");
                    String nombre = sc.nextLine();
                    controlador.usarItem(nombre);
                }

                case 0 -> System.out.println("Saliendo del sistema de inventario...");

                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }

            System.out.println();

        } while (opcion != 0);

        sc.close();
    }
}
