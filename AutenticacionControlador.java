package ejer2;

import java.util.List;

public class AutenticacionControlador {
    private AutenticacionModelo modelo;
    private AutenticacionVista vista;

    public AutenticacionControlador(AutenticacionModelo modelo, AutenticacionVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void gestionarAutenticacion() {
        int opcion;
        do {
            vista.mostrarEstadoSesion(modelo.getUsuarioActual());
            vista.mostrarMenuAutenticacion();
            String opcionStr = vista.leerOpcion();
            try {
                opcion = Integer.parseInt(opcionStr);
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    iniciarSesion();
                    break;
                case 3:
                    cerrarSesion();
                    break;
                case 4:
                    agregarResena();
                    break;
                case 5:
                    verResenasProducto();
                    break;
                case 6:
                    vista.mostrarMensaje("Volviendo al menú principal...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida");
            }
        } while (opcion != 6);
    }

    private void registrarUsuario() {
        String username = vista.leerUsername();
        String password = vista.leerPassword();
        String email = vista.leerEmail();

        if (modelo.registrarUsuario(username, password, email)) {
            vista.mostrarMensaje("Usuario registrado exitosamente");
        } else {
            vista.mostrarMensaje("Error: El usuario ya existe");
        }
    }

    private void iniciarSesion() {
        if (modelo.getUsuarioActual() != null) {
            vista.mostrarMensaje("Ya hay una sesión activa");
            return;
        }

        String username = vista.leerUsername();
        String password = vista.leerPassword();

        if (modelo.iniciarSesion(username, password)) {
            vista.mostrarMensaje("Sesión iniciada correctamente");
        } else {
            vista.mostrarMensaje("Error: Credenciales incorrectas");
        }
    }

    private void cerrarSesion() {
        modelo.cerrarSesion();
        vista.mostrarMensaje("Sesión cerrada correctamente");
    }

    private void agregarResena() {
        if (modelo.getUsuarioActual() == null) {
            vista.mostrarMensaje("Debe iniciar sesión para agregar reseñas");
            return;
        }

        String productoId = vista.leerProductoIdResena();
        int calificacion = vista.leerCalificacion();
        String comentario = vista.leerComentario();
        String fecha = vista.leerFecha();

        if (calificacion == 0) {
            vista.mostrarMensaje("Calificación no válida");
            return;
        }

        modelo.agregarResena(productoId, calificacion, comentario, fecha);
        vista.mostrarMensaje("Reseña agregada exitosamente");
    }

    private void verResenasProducto() {
        String productoId = vista.leerProductoIdResena();
        List<Resena> resenas = modelo.getResenasPorProducto(productoId);
        double promedio = modelo.getCalificacionPromedio(productoId);
        
        vista.mostrarResenas(resenas, promedio);
    }
}