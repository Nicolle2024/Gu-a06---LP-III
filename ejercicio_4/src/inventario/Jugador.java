package inventario;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private Item armaEquipada;
    private InventarioModel inventario;

    public Jugador(String nombre, int salud, int nivel) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.inventario = new InventarioModel();
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

    public InventarioModel getInventario() {
        return inventario;
    }

    public Item getArmaEquipada() {
        return armaEquipada;
    }

    public void equiparArma(Item arma) {
        if (arma != null && arma.getTipo().equalsIgnoreCase("arma")) {
            this.armaEquipada = arma;
            System.out.println(nombre + " ha equipado: " + arma.getNombre());
        } else {
            System.out.println("No es un arma válida para equipar");
        }
    }

    public void recibirDaño(int daño) {
        salud -= daño;
        if (salud < 0) salud = 0;
        System.out.println(nombre + " ha recibido " + daño + " de daño. Salud restante: " + salud);
    }

    public void usarObjeto(String nombreItem) {
        Item item = inventario.buscarItem(nombreItem);
        if (item != null && item.getTipo().equalsIgnoreCase("poción")) {
            item.usarItem();
            salud += 30; // simulamos efecto de curación simple
            System.out.println(nombre + " ha usado una " + item.getNombre() + " y recupera 30 de salud.");
        } else {
            System.out.println("No puedes usar ese objeto");
        }
    }

    public int atacar() {
        int daño = 5; // daño base
        if (armaEquipada != null) {
            daño += 10; // daño adicional si tiene arma
            System.out.println(nombre + " ataca con " + armaEquipada.getNombre() + " causando " + daño + " de daño!");
        } else {
            System.out.println(nombre + " ataca con sus puños causando " + daño + " de daño!");
        }
        return daño;
    }

    public boolean estaVivo() {
        return salud > 0;
    }
}
