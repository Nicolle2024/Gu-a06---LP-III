package ejer2;

public class Main {
    public static void main(String[] args) {
        AutenticacionModelo modelo = new AutenticacionModelo();
        AutenticacionVista vista = new AutenticacionVista();
        AutenticacionControlador controlador = new AutenticacionControlador(modelo, vista);
        
        controlador.gestionarAutenticacion();
        vista.cerrarScanner();
    }
}