package inventario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear jugador
        System.out.print("Nombre del jugador: ");
        String nombre = sc.nextLine();
        Jugador jugador = new Jugador(nombre, 100, 1);

        // Cargar algunos ítems al inventario del jugador
        jugador.getInventario().agregarItem(new Item("Espada de Hierro", 1, "arma", "Una espada básica."));
        jugador.getInventario().agregarItem(new Item("Poción de Vida", 2, "poción", "Recupera salud."));

        // Crear enemigo
        Enemigo enemigo = new Enemigo("Goblin", 60, 1, "Criatura salvaje");

        // Crear combate MVC
        CombateModel combateModel = new CombateModel(jugador, enemigo);
        CombateView combateView = new CombateView();
        CombateController combateController = new CombateController(combateModel, combateView);

        // Iniciar combate
        combateController.iniciarCombate();

        sc.close();
    }
}
