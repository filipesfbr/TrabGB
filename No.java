package AVLPesquisa;


public class No <T extends Comparable<T>>{

	public T chave;
	public int [] index;
	
	public No<T> direita;
	public No<T> esquerda;
	public int altura;
	
	public No(T chave) {
		this.chave = chave;
		this.direita = this.esquerda = null;
		this.altura = 0;
	}

	public T getChave() {
		return chave;
	}

	public void setChave(T chave) {
		this.chave = chave;
	}

	public int[] getIndex() {
		return index;
	}

	public void setIndex(int[] index) {
		this.index = index;
	}

	public No<T> getDireita() {
		return direita;
	}

	public void setDireita(No<T> direita) {
		this.direita = direita;
	}

	public No<T> getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No<T> esquerda) {
		this.esquerda = esquerda;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	

}
