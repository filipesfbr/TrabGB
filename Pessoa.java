package AVLPesquisa;

import java.sql.Date;

public class Pessoa {

	    private int cpf, rg;
	    private String nome;
	    private Date data;
	    private String cidade;
	    private int index;

	    
		public Pessoa(int cpf, int rg, String nome, Date date, String cidade, int index) {
			this.cpf = cpf;
			this.rg = rg;
			this.nome = nome;
			this.data = date;
			this.cidade = cidade;
			this.index = index;
		}
		
		public int getRg() {
			return rg;
		}
		public void setRg(int rg) {
			this.rg = rg;
		}
		public String getCidade() {
			return cidade;
		}
		public void setCidade(String cidade) {
			this.cidade = cidade;
		}
		public String getNome() {
	        return nome;
	    }
	    public void setNome(String nome) {
	        this.nome = nome;
	    }
	    public int getCpf() {
	        return cpf;
	    }
	    public void setCpf(int cpf) {
	        this.cpf = cpf;
	    }
	    public Date getData() {
	        return data;
	    }
	    public void setData(Date data) {
	        this.data = data;
	    }
}
