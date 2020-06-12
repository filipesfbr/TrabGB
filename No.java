package AVLPesquisa;

public class No <T, U>{

    public T chave;
    public U conteudo;

    public No<T, U> direita;
    public No<T, U> esquerda;
    public int altura;

    public No(T chave, U conteudo) {
        this.chave = chave;
        this.conteudo = conteudo;
        this.direita = this.esquerda = null;
        this.altura = 0;
    }

    public T getChave() {
        return chave;
    }

    public void setChave(T chave) {
        this.chave = chave;
    }
    
    public U getConteudo() {
        return conteudo;
    }

    public void setConteudo(U conteudo) {
        this.conteudo = conteudo;
    }

    public No<T, U> getDireita() {
        return direita;
    }

    public void setDireita(No<T, U> direita) {
        this.direita = direita;
    }

    public No<T, U> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No<T, U> esquerda) {
        this.esquerda = esquerda;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}