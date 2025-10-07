package Actividad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidoModelo {
	private List<Pedido> pedidos;
	public PedidoModelo() {
		pedidos = new ArrayList<>();
}
	public void agregarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void eliminarPedidos(Pedido pedido) {
		pedidos.remove(pedido);
	}
	 public void actualizarPedido(int indice, Pedido pedidoActualizado) {
	        if (indice >= 0 && indice < pedidos.size()) {
	            pedidos.set(indice, pedidoActualizado);
	        }
	    }
	 public Pedido buscarPedido(int indice) {
	        if (indice >= 0 && indice < pedidos.size()) {
	            return pedidos.get(indice);
	        }
	        return null;
	 }
	   public List<Pedido> buscarPedidos(String nombrePlato) {
	        List<Pedido> resultados = new ArrayList<>();
	        for (Pedido pedido : pedidos) {
	            if (pedido.getNombrePlato().toLowerCase().contains(nombrePlato.toLowerCase()) ||
	                pedido.getNombrePlato().toLowerCase().contains(nombrePlato.toLowerCase())) {
	                resultados.add(pedido);
	            }
	        }
	        return resultados;
	    }
	   public Map<String, Object> contarPedidos() {
	        Map<String, Object> estadisticas = new HashMap<>();
	        estadisticas.put("total", pedidos.size());
	        
	        // Contar por tipo
	        Map<String, Integer> porTipo = new HashMap<>();
	        for (Pedido pedido : pedidos) {
	            String tipo = pedido.getNombrePlato();
	            porTipo.put(tipo, porTipo.getOrDefault(tipo, 0) + 1);
	        }
	        estadisticas.put("porTipo", porTipo);
	        
	        return estadisticas;
	    }
	}






