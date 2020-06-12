package AVLPesquisa;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Pessoa {

    public String cpf, rg, nome;
    public Date data;
    public String cidade;

    public Pessoa(String cpf, String rg, String nome, java.util.Date date, String cidade) {
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.data = (Date) date;
        this.cidade = cidade;
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
    
    private static final String SEPARADOR = ";";
    
	@Override
    public String toString() {
      SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
      String dataString = formato.format(data);
      List<String> propriedades = Arrays.asList(
          cpf, rg, nome, dataString, cidade);
      return String.join(SEPARADOR, propriedades);
    }

}