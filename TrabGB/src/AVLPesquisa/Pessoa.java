package AVLPesquisa;

import java.util.Date;

public class Pessoa {

	public String cpf, rg, nome;
	public Date data;
	public String cidade;
	public int index;

	public Pessoa(String cpf, String rg, String nome, java.util.Date date, String cidade, int index) {
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
		this.data = (Date) date;
		this.cidade = cidade;
		this.index = index;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}