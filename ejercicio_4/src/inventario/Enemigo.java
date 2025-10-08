package inventario;

import java.util.Random;

public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getNivel() {
        return nivel;
    }

    public String getTipo() {
        return tipo;
    }

    public void recibirDaño(int daño) {
        salud -= daño;
        if (salud < 0) salud = 0;
        System.out.println(nombre + " ha recibido " + daño + " de daño. Salud restante: " + salud);
    }

    public int atacar() {
        Random r = new Random();
        int daño = 4 + r.nextInt(6); // daño aleatorio (entre 4 y 9) como pide el informe
        System.out.println(nombre + " ataca causando " + daño + " de daño.");
        return daño;
    }

    public boolean estaVivo() {
        return salud > 0;
    }
}
