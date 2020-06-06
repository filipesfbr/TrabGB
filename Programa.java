package AVLPesquisa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jdk.nashorn.api.tree.ForInLoopTree;

public class Programa {

	private Pessoa[] array;

	public int quantidadeLinhas(File file) throws FileNotFoundException, IOException {
		int linhas = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				linhas++;
			}
		}
		return linhas;

	}

	public void carregar(File file) throws IOException, ParseException {
		array = new Pessoa[quantidadeLinhas(file)];
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			int index = 0;
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

			while ((line = br.readLine()) != null) {

				if (index < array.length) {
					String[] cols = line.split(";");

					array[index++] = new Pessoa(
							Integer.parseInt(cols[0]), // CPF
							Integer.parseInt(cols[1]), // RG
							cols[2], // NOME
							(Date) formato.parse(cols[3]), // DATA DE NASCIMENTO
							cols[4], // CIDADE NATAL
							index); // INDEX

				}
			}
		}
	}
	
	
	
	public void buscarNome(Pessoa [] pessoa) {
		for(int i = 0; i > pessoa.length; i++) {
			
		}
	}
	
	public void buscarCPF(Pessoa [] pessoa, int cpf) {
		Arvore a = new Arvore();
		for (int i = 0; i < pessoa.length; i++) {
			a.inserir(pessoa[i].getCpf(), i);
		}
		if(buscar() != 0) {
			
		}
		
	}
	
	public void buscaData(Pessoa [] pessoa) {
		
	}
	public void exibir() {
		
	}
}
