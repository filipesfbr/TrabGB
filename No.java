package AVLPesquisa;

public class No {

	public String chave;
	public No direita;
	public No esquerda;
	public int altura;
	public int [] index;
	
	public No(Pessoa p) {
		this.chave = p.getNome();
		this.direita = this.esquerda = null;
		this.index = null;
	}
	



	public No getDireita() {
		return direita;
	}

	public void setDireita(No direita) {
		this.direita = direita;
	}

	public No getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}
}
