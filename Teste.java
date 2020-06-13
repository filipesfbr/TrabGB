package AVLPesquisa;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Teste {
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Scanner ler = new Scanner(System.in);
		DateFormat data=DateFormat.getInstance();

		Programa programa = new Programa();
		try {
			programa.carregar(new File("/Users/filipeferreira/eclipse-workspace/TrabGB/src/AVLPesquisa/ARQUIVO.csv"));

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		

		System.out.println("Digite uma opção: " + "\n1 - buscar com CPF" + "\n2 - buscar por Nome"
				+ "\n3 - buscar por Data de Nascimento" + "\n0 - sair do programa");
		int opcao = ler.nextInt();

		while (opcao != 0) {
			switch (opcao) {

			case 1:
				System.out.println("Digite o CPF que deseja buscar: ");
				String cpfBuscado = ler.next();
				No<String, Pessoa> cpf = programa.buscarCpf(cpfBuscado, programa.arvoreCpf);

				if (cpf != null) {
					System.out.println("Regitro encontrado: \n");
					System.out.println(cpf.getConteudo());
				} else {
					System.out.println("CPF não encontrado!");
				}
				break;

			case 2:
				System.out.println("Digite o nome a ser buscado: ");
				String nomeBuscado = ler.next();
				List<No<String, Pessoa>> nomes = programa.buscarTodosQueIniciamCom(nomeBuscado, programa.arvoreNome);

				if (!nomes.isEmpty()) {
					System.out.println("Registros encontrados: \n");
					for (No<String, Pessoa> noNomes : nomes) {
						System.out.println(noNomes.getConteudo());
					}
				} else {
					System.out.println("Não existem dados para a busca realizada.");
				}
				break;

			case 3:
				System.out.println("Digite 2 datas para uma pesquisa entre elas: ");
				String dataInicio = ler.next();
				String dataFinal = ler.next();
			
				//List<No<Date, Pessoa>> entreDatas = programa.buscarTodosEntreDatas(dataInicio, dataFinal, programa.arvoreData);
				
				break;
				
			default:
				System.out.println("Digite apenas opções válidas!");
			}

			System.out.println("\n");
			System.out.println("Digite uma opção: " + "\n1 - buscar com CPF" + "\n2 - buscar por Nome"
					+ "\n3 - buscar por Data de Nascimento" + "\n0 - sair do programa");
			opcao = ler.nextInt();
		}

		
		
		
		//verificar o tipo de entrada no método de buscar entre datas
		
		
		
//		Long segundos = 1000L;
//		Long minutos = 60 * segundos;
//		Long horas = 60 * minutos;
//		Long dias = 24 * horas;
//		Date inicio = new Date(946692000000L); // Jan 01 2000
//		Date fim = new Date(946692000000L + 20 * dias); // Jan 21 2000
//		
//		List<No<Date, Pessoa>> entreDatas = programa.buscarTodosEntreDatas(inicio, fim, programa.arvoreData);
//		System.out.println("Temos " + entreDatas.size() + " elementos entre " + inicio + " e " + fim + ", esperamos 20.");
//		System.out.println("Estas pessoas são: ");
//		for (No<Date, Pessoa> noEntreDatas : entreDatas) {
//			System.out.println(noEntreDatas.getConteudo());
//		}
	}
}