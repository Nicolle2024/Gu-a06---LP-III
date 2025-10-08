package inventario;

public class CombateModel {
    private Jugador jugador;
    private Enemigo enemigo;

    public CombateModel(Jugador jugador, Enemigo enemigo) {
        this.jugador = jugador;
        this.enemigo = enemigo;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Enemigo getEnemigo() {
        return enemigo;
    }

    public boolean combateTerminado() {
        return !jugador.estaVivo() || !enemigo.estaVivo();
    }
}
