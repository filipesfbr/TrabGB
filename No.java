package AVLPesquisa;

import java.sql.Date;

public class No<T extends Comparable<T>> {

	public T chave;
	public No<T> direita;
	public No<T> esquerda;
	public int altura;
	public int index;
	public int[] indexNomes;

	public No(Pessoa p) {
		this.chave = (T) p.getNome();
		this.direita = this.esquerda = null;
		this.index = 0;
	}

	public No(T cpf, int i) {
		this.chave = cpf;
		this.index = i;
		this.direita = this.esquerda = null;

	}
	public No(T data) {

	}

	public T getChave() {
		return chave;
	}

	public void setChave(T chave) {
		this.chave = chave;
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int[] getIndexNomes() {
		return indexNomes;
	}

	public void setIndexNomes(int[] indexNomes) {
		this.indexNomes = indexNomes;
	}

}
