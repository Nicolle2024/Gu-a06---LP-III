package Actividad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidoModelo {
	private List<Pedido> pedidos;
	private List<Pedido> historial;
	
	public PedidoModelo() {
		pedidos = new ArrayList<>();
		historial = new ArrayList<>();
	}
	public void agregarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void eliminarPedido(String pedido) {
		for (Pedido p : new ArrayList<>(pedidos)) { 
			if (p.getNombrePlato().equalsIgnoreCase(pedido)) { 
				p.setEstado("eliminado"); 
				historial.add(p); 
				pedidos.remove(p); 
				break; 
			} 
		} 
	}
	public boolean marcarCompleto(String nombre) { 
		for (Pedido p : new ArrayList<>(pedidos)) { 
			if (p.getNombrePlato().equalsIgnoreCase(nombre)) { 
				p.setEstado("completo"); 
				historial.add(p); 
				pedidos.remove(p); 
				return true; 
			} 
		} 
		return false; 
	}
	 public void actualizarPedido(int indice, Pedido pedidoActualizado) {
	        if (indice >= 0 && indice < pedidos.size()) {
	            pedidos.set(indice, pedidoActualizado);
	        }
	    }
	 public List<Pedido> buscarPedido(String nombrePlato) {
	        List<Pedido> resultados = new ArrayList<>();
	        for (Pedido pedido : pedidos) {
	            if (pedido.getNombrePlato().toLowerCase().contains(nombrePlato.toLowerCase())) {
	                resultados.add(pedido);
	            }
	        }
	        return resultados;
	    }

	    public Map<String, Object> contarPedidos() {
	        Map<String, Object> estadisticas = new HashMap<>();
	        estadisticas.put("total", pedidos.size());

	        Map<String, Integer> porTipo = new HashMap<>();
	        for (Pedido pedido : pedidos) {
	            String tipo = pedido.getTipoPlato();
	            porTipo.put(tipo, porTipo.getOrDefault(tipo, 0) + 1);
	        }
	        estadisticas.put("porTipo", porTipo);

	        return estadisticas;
	    }

	    public List<Pedido> obtenerPedidosPorEstado(String estado) {
	        List<Pedido> filtrados = new ArrayList<>();
	        for (Pedido p : pedidos) {
	            if (p.getEstado().equalsIgnoreCase(estado)) {
	                filtrados.add(p);
	            }
	        }
	        return filtrados;
	    }

	    public int contarPendientes() {
	        int contador = 0;
	        for (Pedido p : pedidos) {
	            if (p.getEstado().equalsIgnoreCase("pendiente")) {
	                contador++;
	            }
	        }
	        return contador;
	    }

	    public List<Pedido> getHistorial() {
	        return historial;
	    }
	}






