package model.logic;

public class Informacion {
	private String coordenada;
	private int idVertice;

	public Informacion(int idVertice, String coordenada )
	{
		this.setCoordenada(coordenada);
		this.setIdVertice(idVertice);
	}


	public boolean marked() {
		return true;
		// TODO Auto-generated method stub
		
	}

	public boolean isMarked() {
		boolean rta= true;
		while (marked()==false)
		{
			rta = false;
		}
		return rta;
		// TODO Auto-generated method stub
	}

	public String toString() {
		return "Vertice id" + idVertice + ", coordenadas" + coordenada;
	}


	public String getCoordenada() {
		return coordenada;
	}


	public void setCoordenada(String coordenada) {
		this.coordenada = coordenada;
	}


	public int getIdVertice() {
		return idVertice;
	}


	public void setIdVertice(int idVertice) {
		this.idVertice = idVertice;
	}
}