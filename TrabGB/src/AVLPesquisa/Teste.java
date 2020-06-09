package AVLPesquisa;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teste {

	public static void main(String[] args) {

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Programa programa = new Programa();
		try {
		programa.carregar(new File("c:/TESTE.csv"));
		
		Date data1 = formato.parse("01/01/2019");
		Date data2 = formato.parse("01/01/2019");
		System.out.println(data1.compareTo(data2) == 0);
		
		
		System.out.println(programa.arvoreData.buscar(formato.parse("25/12/2972")));
		
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
