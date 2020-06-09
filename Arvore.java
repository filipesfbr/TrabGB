package AVLPesquisa;

//Teste GIT+Eclipse
public class Arvore<T extends Comparable<T>> {

	private No<T> raiz;

	public boolean inserir(T valor) {
		No<T> repetido = buscar(valor);
		if (repetido == null) {
			raiz = inserir(valor, raiz);
			return true;
		} else {
			System.out.println("Valor ja consta na arvore!");
			return false;
		}
	}

	public No<T> inserir(T valor, No<T> no) {
		if (no == null) {
			no = new No<T>(valor);
		} else if (no.chave.compareTo(valor) < 0) {
			no.esquerda = inserir(valor, no.esquerda);
		} else if (no.chave.compareTo(valor) > 0) {
			no.direita = inserir(valor, no.direita);
		}

		no = balancear(no);
		return no;
	}

	public No<T> buscar(T valor) {
		if (raiz == null) {
			return null;
		}
		No<T> atual = raiz;

		if (atual.chave.compareTo(valor) == 0) {
			return atual;
		} else {

			while (atual.chave.compareTo(valor) != 0) {
				if (atual.chave.compareTo(valor) < 0) { // rever
					atual = atual.esquerda;
					if (atual == null) {
						return null;
					}
				} else {
					atual = atual.direita;
					if (atual == null) {
						return null;
					}
				}

			}
		}
		return atual;
	}

	// ------------------------ FUNCOES AUXILIARES---------------------------
	// -------------------------------//

	public int altura(No<T> no) {
		if (no == null) {
			return -1;
		} else {
			return no.altura;
		}

	}

	public int fatorBalanceamento(No<T> no) {
		return altura(no.esquerda) - altura(no.direita);
	}

	public No<T> balancear(No<T> no) {
		if (fatorBalanceamento(no) == 2) {
			if (fatorBalanceamento(no.esquerda) > 0)
				no = rotacaoDireita(no);
			else
				no = duplaRotacaoDireita(no);
		} else if (fatorBalanceamento(no) == -2) {
			if (fatorBalanceamento(no.direita) < 0)
				no = rotacaoEsquerda(no);
			else
				no = duplaRotacaoEsquerda(no);
		}
		no.altura = Math.max(altura(no.esquerda), altura(no.direita)) + 1;
		return no;
	}

	// ROTACAO DIREITA
	public No<T> rotacaoDireita(No<T> no) {
		No<T> aux = no.esquerda;
		no.esquerda = aux.direita;
		aux.direita = no;
		no.altura = Math.max(altura(no.esquerda), altura(no.direita)) + 1;
		aux.altura = Math.max(altura(aux.esquerda), no.altura) + 1;
		return aux;
	}

	// ROTACAO ESQUERDA
	public No<T> rotacaoEsquerda(No<T> no) {
		No<T> aux = no.direita;
		no.direita = aux.esquerda;
		aux.esquerda = no;
		no.altura = Math.max(altura(no.esquerda), altura(no.direita)) + 1;
		aux.altura = Math.max(altura(aux.direita), no.altura) + 1;
		return aux;
	}

	// DUPLA ROTACAO DIREITA
	public No<T> duplaRotacaoDireita(No<T> no) {
		no.esquerda = rotacaoEsquerda(no.esquerda);
		return rotacaoDireita(no);
	}

	// DUPLA ROTACAO ESQUERDA
	public No<T> duplaRotacaoEsquerda(No<T> no) {
		no.direita = rotacaoDireita(no.direita);
		return rotacaoEsquerda(no);
	}

}
