package AVLPesquisa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Programa {

	public Pessoa[] array;
	public Arvore<String> arvoreNome;
	public Arvore<String> arvoreCpf;
	public Arvore<Date> arvoreData;
	

	public Programa() {
		this.arvoreNome = new Arvore<String>();
		this.arvoreCpf = new Arvore<String>();
		this.arvoreData = new Arvore<Date>();
	}

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

					array[index++] = new Pessoa((cols[0]), // CPF
							(cols[1]), // RG
							cols[2], // NOME
							(Date) formato.parse(cols[3]), // DATA DE NASCIMENTO
							cols[4], // CIDADE NATAL
							index); // INDEX

				}
				
					
				}
			for (int i = 0; i < array.length; i++) {
				arvoreCpf.inserir(array[i].getCpf());
				arvoreData.inserir(array[i].getData());
			}
		}
	}
	
}