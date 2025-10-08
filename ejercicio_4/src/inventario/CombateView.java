package inventario;

public class CombateView {

    public void mostrarEstadoCombate(Jugador jugador, Enemigo enemigo) {
        System.out.println("\n=== ESTADO DEL COMBATE ===");
        System.out.println(jugador.getNombre() + " (Salud: " + jugador.getSalud() + ", Nivel: " + jugador.getNivel() + ")");
        System.out.println(enemigo.getNombre() + " (Salud: " + enemigo.getSalud() + ", Nivel: " + enemigo.getNivel() + ", Tipo: " + enemigo.getTipo() + ")");
        System.out.println("===========================\n");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarResultado(Jugador jugador, Enemigo enemigo) {
        if (!jugador.estaVivo()) {
            System.out.println("\n💀 " + jugador.getNombre() + " ha sido derrotado...");
        } else if (!enemigo.estaVivo()) {
            System.out.println("\n🏆 " + jugador.getNombre() + " ha vencido a " + enemigo.getNombre() + "!");
        }
    }
}
