package ejer2;

import java.util.List;
import java.util.Scanner;

public class AutenticacionVista {
    private Scanner scanner;

    public AutenticacionVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenuAutenticacion() {
        System.out.println("\nSISTEMA DE AUTENTICACIÓN");
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar sesión");
        System.out.println("3. Cerrar sesión");
        System.out.println("4. Agregar reseña");
        System.out.println("5. Ver reseñas de producto");
        System.out.println("6. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
    }

    public String leerOpcion() {
        return scanner.nextLine();
    }

    public String leerUsername() {
        System.out.print("Ingrese username: ");
        return scanner.nextLine();
    }

    public String leerPassword() {
        System.out.print("Ingrese password: ");
        return scanner.nextLine();
    }

    public String leerEmail() {
        System.out.print("Ingrese email: ");
        return scanner.nextLine();
    }

    public String leerProductoIdResena() {
        System.out.print("Ingrese ID del producto a reseñar: ");
        return scanner.nextLine();
    }

    public int leerCalificacion() {
        System.out.print("Ingrese calificación (1-5): ");
        try {
            int calificacion = Integer.parseInt(scanner.nextLine());
            if (calificacion < 1 || calificacion > 5) {
                return 0;
            }
            return calificacion;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public String leerComentario() {
        System.out.print("Ingrese comentario: ");
        return scanner.nextLine();
    }

    public String leerFecha() {
        System.out.print("Ingrese fecha (dd/mm/aaaa): ");
        return scanner.nextLine();
    }

    public void mostrarResenas(List<Resena> resenas, double promedio) {
        System.out.println("\n=== RESEÑAS DEL PRODUCTO ===");
        if (resenas.isEmpty()) {
            System.out.println("No hay reseñas para este producto");
        } else {
            System.out.printf("Calificación promedio: %.1f/5.0%n", promedio);
            for (Resena resena : resenas) {
                System.out.printf("Usuario: %s | Calificación: %d/5 | Fecha: %s%n",
                    resena.getUsername(), resena.getCalificacion(), resena.getFecha());
                System.out.printf("Comentario: %s%n", resena.getComentario());
                System.out.println("---");
            }
        }
    }

    public void mostrarEstadoSesion(Usuario usuario) {
        if (usuario != null) {
            System.out.println("Sesión activa: " + usuario.getUsername());
        } else {
            System.out.println("No hay sesión activa");
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}