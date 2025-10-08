package Actividad;

public class Pedido {
	private String nombrePlato;
	private String tipoPlato;
	private String estado;
	
	public Pedido(String nombrePlato, String tipoPlato) {
	    this.nombrePlato = nombrePlato;
	    this.tipoPlato = tipoPlato;
	    this.estado = "Pendiente";
	}
	public String getNombrePlato() {
		return nombrePlato;
	}
	public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }
	public String getTipoPlato() {
		return tipoPlato;
	}
	public void setTipoPlato (String tipoPlato) {
		this.tipoPlato = tipoPlato;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

    @Override
    public String toString() {
        return "Pedido: " + nombrePlato + "Categoria: " + tipoPlato + "Estado: " + estado;
    }
	
}
