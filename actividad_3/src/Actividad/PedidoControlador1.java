package Actividad;

import java.util.List;
public class PedidoControlador {
	private PedidoModelo modelo;
	private PedidoVista vista;
	
	public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	 public void agregarPedido(String nombrePlato, String tipoPlato) {
		 if (!nombrePlato.isEmpty() && !tipoPlato.isEmpty()) {
	            modelo.agregarPedido(new Pedido(nombrePlato, tipoPlato));
	            vista.mostrarMensaje("Pedido agregado: " + nombrePlato);
	        } else {
	            vista.mostrarMensaje("El nombre del plato no puede estar vacío.");
	        }
	    }
	 public void eliminarPedido(String nombrePlato) {
	        modelo.eliminarPedido(nombrePlato);
	        vista.mostrarMensaje("Pedido eliminado: " + nombrePlato);
	    }

	    public void mostrarPedidos() {
	        List<Pedido> pedidos = modelo.getPedidos();
	        vista.mostrarPedidos(pedidos);
	    }

	    public void buscarPedidos(String nombrePlato) {
	        List<Pedido> resultados = modelo.buscarPedido(nombrePlato);
	        if (resultados.isEmpty()) {
	            vista.mostrarMensaje("No se encontraron pedidos con el nombre: " + nombrePlato);
	        } else {
	            vista.mostrarMensaje("Resultados de búsqueda:");
	            vista.mostrarPedidos(resultados);
	        }
	    }

	    public void marcarPedidoComoCompleto(String nombrePlato) {
	        boolean exito = modelo.marcarCompleto(nombrePlato);
	        if (exito) {
	            vista.mostrarMensaje("Pedido marcado como completo: " + nombrePlato);
	        } else {
	            vista.mostrarMensaje("No se encontró el pedido para marcar como completo.");
	        }
	    }

	    public void mostrarPedidosPendientes() {
	        List<Pedido> pendientes = modelo.obtenerPedidosPorEstado("pendiente");
	        vista.mostrarMensaje("Pedidos pendientes (" + modelo.contarPendientes() + "):");
	        vista.mostrarPedidos(pendientes);
	    }

	    public void mostrarHistorial() {
	        List<Pedido> historial = modelo.getHistorial();
	        vista.mostrarMensaje("Historial de pedidos (completos o eliminados):");
	        vista.mostrarPedidos(historial);
	    }

	    public void iniciar() {
	        String opcion;
	        do {
	            vista.mostrarMenu();
	            opcion = vista.solicitarOpcion();

	            switch (opcion) {
	                case "1":
	                    String nombrePlato = vista.solicitarNombrePlato();
	                    String tipoPlato = vista.solicitarTipoPlato(); 
	                    agregarPedido(nombrePlato, tipoPlato);
	                    break;

	                case "2":
	                    mostrarPedidos();
	                    break;

	                case "3":
	                    String eliminar = vista.solicitarNombrePlato();
	                    eliminarPedido(eliminar);
	                    break;

	                case "4":
	                    String buscar = vista.solicitarNombrePlato();
	                    buscarPedidos(buscar);
	                    break;

	                case "5":
	                    String completar = vista.solicitarNombrePlato();
	                    marcarPedidoComoCompleto(completar);
	                    break;

	                case "6":
	                    mostrarPedidosPendientes();
	                    break;

	                case "7":
	                    mostrarHistorial();
	                    break;

	                case "8":
	                    vista.mostrarMensaje("Saliendo del sistema...");
	                    break;

	                default:
	                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
	            }
	        } while (!opcion.equals("8"));

	        vista.cerrarScanner();
	    }
	}
		
