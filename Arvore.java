package AVLPesquisa;

public class Arvore<T extends Comparable<T>, U> {

	public No<T, U> raiz;
	

	public boolean inserir(T valor, U conteudo) {
		No<T, U> repetido = buscar(valor);
		if (repetido == null) {
			raiz = inserir(valor, raiz, conteudo);
			return true;
		} else {
			System.out.println("Valor ja consta na arvore!");
			return false;
		}
	}

	public No<T, U> inserir(T valor, No<T, U> no, U conteudo) {
		if (no == null) {
			no = new No<T, U>(valor, conteudo);
		} else if (no.chave.compareTo(valor) < 0) {
			no.esquerda = inserir(valor, no.esquerda, conteudo);
		} else if (no.chave.compareTo(valor) > 0) {
			no.direita = inserir(valor, no.direita, conteudo);
		}

		no = balancear(no);
		return no;
	}
	
	public No<T, U> buscarMenorMaiorQue(T valor) {
    if (null == raiz) {
      return null;
    }
    
    if (null == raiz.esquerda && null == raiz.direita) {
      if (raiz.chave.compareTo(valor) > 0) {
        return raiz;
      } else {
        return null;
      }
    }
    
    if (raiz.chave.compareTo(valor) <= 0) {
      Arvore<T, U> esquerda = new Arvore<T, U>();
      esquerda.raiz = raiz.esquerda;
      return esquerda.buscarMenorMaiorQue(valor);
    }
    
    if (null != raiz.direita) {
      Arvore<T, U> direita = new Arvore<T, U>();
      direita.raiz = raiz.direita;
      No<T, U> menorMaiorDireita = direita.buscarMenorMaiorQue(valor);
      
     if (null != menorMaiorDireita) {
        return menorMaiorDireita;
      }
    }
    
    return raiz;
  }
	
	public No<T, U> buscar(T valor) {
		if (raiz == null) {
			return null;
		}
		No<T, U> atual = raiz;

		if (atual.chave.compareTo(valor) == 0) {
			return atual;
		} else {

			while (atual.chave.compareTo(valor) != 0) {
				if (atual.chave.compareTo(valor) < 0) {
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

	public int altura(No<T, U> no) {
		if (no == null) {
			return -1;
		} else {
			return no.altura;
		}

	}

	public int fatorBalanceamento(No<T, U> no) {
		return altura(no.esquerda) - altura(no.direita);
	}

	public No<T, U> balancear(No<T, U> no) {
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
	public No<T, U> rotacaoDireita(No<T, U> no) {
		No<T, U> aux = no.esquerda;
		no.esquerda = aux.direita;
		aux.direita = no;
		no.altura = Math.max(altura(no.esquerda), altura(no.direita)) + 1;
		aux.altura = Math.max(altura(aux.esquerda), no.altura) + 1;
		return aux;
	}

	// ROTACAO ESQUERDA
	public No<T, U> rotacaoEsquerda(No<T, U> no) {
		No<T, U> aux = no.direita;
		no.direita = aux.esquerda;
		aux.esquerda = no;
		no.altura = Math.max(altura(no.esquerda), altura(no.direita)) + 1;
		aux.altura = Math.max(altura(aux.direita), no.altura) + 1;
		return aux;
	}

	// DUPLA ROTACAO DIREITA
	public No<T, U> duplaRotacaoDireita(No<T, U> no) {
		no.esquerda = rotacaoEsquerda(no.esquerda);
		return rotacaoDireita(no);
	}

	// DUPLA ROTACAO ESQUERDA
	public No<T, U> duplaRotacaoEsquerda(No<T, U> no) {
		no.direita = rotacaoDireita(no.direita);
		return rotacaoEsquerda(no);
	}

}