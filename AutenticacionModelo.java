package ejer2;

import java.util.ArrayList;
import java.util.List;

public class AutenticacionModelo {
    private List<Usuario> usuarios;
    private List<Resena> resenas;
    private Usuario usuarioActual;

    public AutenticacionModelo() {
        this.usuarios = new ArrayList<>();
        this.resenas = new ArrayList<>();
        this.usuarioActual = null;
        
        // Usuario de prueba
        usuarios.add(new Usuario("admin", "1234", "admin@tienda.com"));
    }

    public boolean registrarUsuario(String username, String password, String email) {
        // Verificar si el usuario ya existe
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return false;
            }
        }
        
        usuarios.add(new Usuario(username, password, email));
        return true;
    }

    public boolean iniciarSesion(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.verificarPassword(password)) {
                usuario.setAutenticado(true);
                usuarioActual = usuario;
                return true;
            }
        }
        return false;
    }

    public void cerrarSesion() {
        if (usuarioActual != null) {
            usuarioActual.setAutenticado(false);
        }
        usuarioActual = null;
    }

    public void agregarResena(String productoId, int calificacion, String comentario, String fecha) {
        if (usuarioActual != null) {
            Resena resena = new Resena(usuarioActual.getUsername(), productoId, calificacion, comentario, fecha);
            resenas.add(resena);
        }
    }

    public List<Resena> getResenasPorProducto(String productoId) {
        List<Resena> resenasProducto = new ArrayList<>();
        for (Resena resena : resenas) {
            if (resena.getProductoId().equals(productoId)) {
                resenasProducto.add(resena);
            }
        }
        return resenasProducto;
    }

    public double getCalificacionPromedio(String productoId) {
        List<Resena> resenasProducto = getResenasPorProducto(productoId);
        if (resenasProducto.isEmpty()) {
            return 0.0;
        }
        
        int suma = 0;
        for (Resena resena : resenasProducto) {
            suma += resena.getCalificacion();
        }
        return (double) suma / resenasProducto.size();
    }

    // Getters
    public Usuario getUsuarioActual() { return usuarioActual; }
    public List<Resena> getResenas() { return resenas; }
}