package Actividad;

import java.util.List;
public class PedidoControlador {
	private PedidoModelo modelo;
	private PedidoVista vista;
	
	public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	public void agregarPedido(String nombrePlato) {
		
		if (!nombrePlato.isEmpty()) {
			modelo.agregarPedido(new Pedido(nombrePlato));
			vista.mostrarMensaje("Pedido agregado: " + nombrePlato);
			} else {
				vista.mostrarMensaje("El nombre del plato no puede estar vacío.");
			}
	}
	public void eliminarPedidos(String nombrePlato) {
		List<Pedido> pedidos = modelo.getPedidos();
		boolean encontrado = false;
		
		for (Pedido p: pedidos) {
			if (p.getNombrePlato().equalsIgnoreCase(nombrePlato)) {
				modelo.eliminarPedidos(p);
				vista.mostrarMensaje("Pedido eliminado: "+nombrePlato);
				encontrado = true;
				break;
			}
		}
		if(!encontrado) {
			vista.mostrarMensaje("No se encontro pedido");
		}
	}
	public void mostrarPedidos() {
		List<Pedido> pedidos = modelo.getPedidos();
		vista.mostrarPedidos(pedidos);
	}
	
	public void buscarPedidos(String nombrePlato) {
		List<Pedido> resultados = modelo.buscarPedidos(nombrePlato);
		if(resultados.isEmpty()) {
			vista.mostrarMensaje("No se encontraron pedidos"+ nombrePlato);
		}else {
			vista.mostrarMensaje(nombrePlato);
		}
	}
	
	public void actualizarPedido(int indice, String nuevoNombre) {
		Pedido pedidoActualizado = new Pedido(nuevoNombre);
		modelo.actualizarPedido(indice, pedidoActualizado);
		vista.mostrarMensaje("Pedido actualizado:" +indice);
	
	}
	public void iniciar() {
		String opcion;
		do {
			vista.mostrarMenu();
			opcion = vista.solicitarOpcion();
			switch (opcion) {
			case "1":
				String nombrePlato = vista.solicitarNombrePlato();
				agregarPedido(nombrePlato);
				break;
			case "2":
				mostrarPedidos();
				break;
			case "3":
				String eliminar = vista.solicitarNombrePlato();
				eliminarPedidos (eliminar);
				break;
			case "4":
				String buscar = vista.solicitarNombrePlato();
				buscarPedidos(buscar);
				break;
			case "5":
				vista.mostrarMensaje("Saliendo...");
				break;
			default:
				vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
			}
			} while (!opcion.equals("5"));
			vista.cerrarScanner();
		}
		}
		