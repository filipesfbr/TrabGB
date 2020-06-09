package AVLPesquisa;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teste {

	public static void main(String[] args) {

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Programa programa = new Programa();
		try {
			programa.carregar(new File("c:/teste.csv"));

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		System.out.println(programa.arvoreNome.buscar("Fulano de Tal"));
		
		}
	}


