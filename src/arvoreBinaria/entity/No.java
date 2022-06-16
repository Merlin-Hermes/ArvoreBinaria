package arvoreBinaria.entity;

public class No {

	private int valor;
	private No esquerdo;
	private No direito;
	private int nivel;

	public No(int valor) {		//construtor
		this.valor = valor;
	}

	public boolean noFolha() {			//metodo
		return (direito == null && esquerdo == null);
	}

	public void finalize() {
		System.out.println("LIBERADO");
	}


	public int getNivel() {
		return nivel;
	} //get nivel

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}//set nivel

	public int getValor() {
		return valor;
	} // get valor

	public No getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}

	public No getDireito() {
		return direito;
	}

	public void setDireito(No direito) {
		this.direito = direito;
	}


}
