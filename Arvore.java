package AVLPesquisa;

public class Arvore <T extends Comparable<T>> {
	
			public No<T> raiz;
			

			public Arvore() {
				raiz = null;
			}

			public boolean inserir(T valor) {
				No repetido = buscarCpf(valor);
				if (repetido == null) {
					raiz = inserir(valor, raiz);
					return true;
				} else {
					System.out.println("Valor ja consta na arvore!");
					return false;
				}
			}

			public No inserir(T valor, No<T> no) {
				if (no == null) {
					no = new No<T>(valor);
				} else if (valor < no.chave) {
					no.esquerda = inserir(valor, no.esquerda);
				} else if (valor > no.cpf) {
					no.direita = inserir(valor, no.direita);
				}

				no = balancear(no);
				return no;
			}
			

			private No ultimoEsquerda(No no) {
				No atual = no;
				while (atual.esquerda != null) {
					atual = atual.esquerda;
				}
				return atual;
			}


			// RETORNA O NO DO VALOR BUSCADO
			public No buscarCpf(int valor) {
				if (raiz == null) {
					return null;
				}
				No atual = raiz;

				if (atual.cpf == valor) {
					return atual;
				} else {

					while (valor != atual.cpf) {
						if (valor < atual.cpf) {
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

			
		// ------------------------------------- FUNCOES AUXILIARES -------------------------------------------------------//
			public int altura(No no) {
				if (no == null) {
					return -1;
				} else {
					return no.altura;
				}

			}

			public int fatorBalanceamento(No no) {
				return altura(no.esquerda) - altura(no.direita);
			}

			public No balancear(No no) {
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
			public No rotacaoDireita(No no) {
				No aux = no.esquerda;
				no.esquerda = aux.direita;
				aux.direita = no;
				no.altura = Math.max(altura(no.esquerda), altura(no.direita)) + 1;
				aux.altura = Math.max(altura(aux.esquerda), no.altura) + 1;
				return aux;
			}

			// ROTACAO ESQUERDA
			public No rotacaoEsquerda(No no) {
				No aux = no.direita;
				no.direita = aux.esquerda;
				aux.esquerda = no;
				no.altura = Math.max(altura(no.esquerda), altura(no.direita)) + 1;
				aux.altura = Math.max(altura(aux.direita), no.altura) + 1;
				return aux;
			}

			// DUPLA ROTACAO DIREITA
			public No duplaRotacaoDireita(No no) {
				no.esquerda = rotacaoEsquerda(no.esquerda);
				return rotacaoDireita(no);
			}

			// DUPLA ROTACAO ESQUERDA
			public No duplaRotacaoEsquerda(No no) {
				no.direita = rotacaoDireita(no.direita);
				return rotacaoEsquerda(no);
			}

		}

