package inventario;

// import java.util.Random;
import java.util.Scanner;

public class CombateController {
    private CombateModel model;
    private CombateView view;
    private Scanner sc;

    public CombateController(CombateModel model, CombateView view) {
        this.model = model;
        this.view = view;
        this.sc = new Scanner(System.in);
    }

    public void iniciarCombate() {
        Jugador jugador = model.getJugador();
        Enemigo enemigo = model.getEnemigo();
        // Random random = new Random();

        view.mostrarMensaje("\n⚔️  ¡Comienza el combate entre " + jugador.getNombre() + " y " + enemigo.getNombre() + "!");

        while (!model.combateTerminado()) {
            view.mostrarEstadoCombate(jugador, enemigo);
            System.out.println("1. Atacar");
            System.out.println("2. Usar objeto");
            System.out.println("3. Equipar arma");
            System.out.println("0. Huir del combate");
            System.out.print("Elige una acción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    int daño = jugador.atacar();
                    enemigo.recibirDaño(daño);
                }
                case 2 -> {
                    System.out.print("Nombre del objeto a usar: ");
                    String nombreItem = sc.nextLine();
                    jugador.usarObjeto(nombreItem);
                }
                case 3 -> {
                    System.out.print("Nombre del arma a equipar: ");
                    String nombreArma = sc.nextLine();
                    Item arma = jugador.getInventario().buscarItem(nombreArma);
                    jugador.equiparArma(arma);
                }
                case 0 -> {
                    view.mostrarMensaje("🏃‍♂️ " + jugador.getNombre() + " ha huido del combate...");
                    return;
                }
                default -> view.mostrarMensaje("Opción inválida.");
            }

            // Turno del enemigo si sigue vivo
            if (enemigo.estaVivo()) {
                int dañoEnemigo = enemigo.atacar();
                jugador.recibirDaño(dañoEnemigo);
            }
        }

        view.mostrarResultado(jugador, enemigo);
    }
}
