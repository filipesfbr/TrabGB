package AVLPesquisa;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Programa programa = new Programa();
		try {
			programa.carregar(new File("C:\\Users\\Lenon\\Desktop\\test.csv"));

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
//		Scanner ler = new Scanner(System.in);
//		String nome = ler.next();
		
		Scanner ler2 = new Scanner(System.in);
		String cpf = ler2.next();
		
//		List<No<String, Pessoa>> nomes = programa.buscarTodosQueIniciamCom(nome, programa.arvoreNome);
		No<String, Pessoa> cpfs = programa.buscarCpf(cpf, programa.arvoreCpf);
		System.out.println(cpfs.getConteudo());
		
//		for (No<String, Pessoa> noNomes : nomes) {
//			System.out.println(noNomes.getConteudo()); 
//		}
//		
		
//		List<No<String, Pessoa>> iniciamComMar = programa.buscarTodosQueIniciamCom("Mar", programa.arvoreNome);
//		System.out.println("Procurando por 'Mar', temos " + iniciamComMar.size() + " elementos, esperamos 27500.");
//
//		Long segundos = 1000L;
//		Long minutos = 60 * segundos;
//		Long horas = 60 * minutos;
//		Long dias = 24 * horas;
//		Date inicio = new Date(946692000000L); // Jan 01 2000
//		Date fim = new Date(946692000000L + 20 * dias); // Jan 21 2000
//		List<No<Date, Pessoa>> entreDatas = programa.buscarTodosEntreDatas(inicio, fim, programa.arvoreData);
//		System.out.println("Temos " + entreDatas.size() + " elementos entre " + inicio + " e " + fim + ", esperamos 20.");
//		System.out.println("Estas pessoas são: ");
//		for (No<Date, Pessoa> noEntreDatas : entreDatas) {
//		System.out.println(noEntreDatas.getConteudo()); 
		}
	}