package AVLPesquisa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Programa {

    public Pessoa[] array;
    public Arvore<String, Pessoa> arvoreNome;
    public Arvore<String, Pessoa> arvoreCpf;
    public Arvore<Date, Pessoa> arvoreData;
    

    public Programa() {
        this.arvoreNome = new Arvore<String, Pessoa>();
        this.arvoreCpf = new Arvore<String, Pessoa>();
        this.arvoreData = new Arvore<Date, Pessoa>();
    }

    public int quantidadeLinhas(File file) throws FileNotFoundException, IOException {
        int linhas = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((br.readLine()) != null) {
                linhas++;
            }
        }
        return linhas;
    }
    
    public Date parseDate(String data) throws ParseException {
      SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
      return formato.parse(data);
    }

    public void carregar(File file) throws IOException, ParseException {
        array = new Pessoa[quantidadeLinhas(file)];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int index = 0;
            

            while ((line = br.readLine()) != null)
{

                if (index < array.length) {
                    String[] cols = line.split(";");

                    array[index++] = new Pessoa((cols[0]), // CPF
                            (cols[1]), // RG
                            cols[2], // NOME
                            (Date) parseDate(cols[3]), // DATA DE NASCIMENTO
                            cols[4]); // CIDADE NATAL

            }
                    
}
            for (int i = 0; i < array.length; i++) {
                arvoreCpf.inserir(array[i].getCpf(), array[i]);
                arvoreData.inserir(array[i].getData(), array[i]);
                arvoreNome.inserir(array[i].getNome(), array[i]);
            }
        }
    }
    
    public List<No<Date, Pessoa>> buscarTodosEntreDatas(Date inicio, Date fim, Arvore<Date, Pessoa> a) {
        List<No<Date, Pessoa>> retorno = new ArrayList<>();
        No<Date, Pessoa> atual;
        Date valorAtual = inicio;
        do  {
          atual = a.buscarMenorMaiorQue(valorAtual);
          if (null != atual && entreDatas(inicio, fim, atual.chave)) {
            retorno.add(atual);
            valorAtual = atual.chave;
          }
        } while (null != atual && entreDatas(inicio, fim, atual.chave));
        return retorno;
      }
    
    public boolean entreDatas(Date inicio, Date fim, Date data) {
        return data.compareTo(inicio) >= 0 && data.compareTo(fim) <= 0;
      }
    
    public List<No<String, Pessoa>> buscarTodosQueIniciamCom(String inicio, Arvore<String, Pessoa> a) {
        List<No<String, Pessoa>> retorno = new ArrayList<>();
        No<String, Pessoa> atual;
        String valorAtual = inicio;
        do  {
          atual = a.buscarMenorMaiorQue(valorAtual);
          if (null != atual && atual.chave.startsWith(inicio)) {
            retorno.add(atual);
            valorAtual = atual.chave;
          }
        } while (null != atual && atual.chave.startsWith(inicio));
        return retorno;
      }
      
    public No<String, Pessoa> buscarCpf(String valor, Arvore<String, Pessoa> arvoreCpf) {
    	return arvoreCpf.buscar(valor);
    }
//    public List<No<String, Pessoa>> buscarCPF(String cpf, Arvore<String, Pessoa> a) {
//        List<No<String, Pessoa>> retorno = new ArrayList<>();
//        No<String, Pessoa> atual;
//        String valorAtual = cpf;
//        do  {
//          atual = a.buscarMenorMaiorQue(valorAtual);
//          if (null != atual && atual.chave.compareTo(cpf) == 0) {
//            retorno.add(atual);
//            valorAtual = atual.chave;
//          }
//        } while (null != atual && atual.chave.compareTo(cpf) != 0);
//        return retorno;
//      }
//      
}