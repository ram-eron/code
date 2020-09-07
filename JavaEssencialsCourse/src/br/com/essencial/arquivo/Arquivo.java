package br.com.essencial.arquivo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Arquivo {

	// private String file = "//home//eron//Documents//Javas//arq.txt";
	private String[] linhas;
	private PrintStream w;

	/**
	 * 
	 * @param texto
	 * @throws FileNotFoundException
	 */

	public void InsertInFile(String textoInserir, String arquivo) throws FileNotFoundException {
		/**
		 * Metodo insere texto no arquivo
		 */
		this.w = new PrintStream(new FileOutputStream(arquivo, true));
		w.println(textoInserir);
		w.close();
	}

	public void LimpaArquivo(String arquivo) throws FileNotFoundException {
		/**
		 * Metodo insere texto no arquivo
		 */
		this.w = new PrintStream(new FileOutputStream(arquivo, false));
		w.print("");
		w.close();
	}

	public String[] getlinhas() {
		return linhas;
	}

	public void ReadFile(String arquivo) throws IOException {
		/**
		 * Scanner obtem dados do arquivo e adidiona a variavel linha da classe
		 */
		Scanner lendo = new Scanner(new FileInputStream(arquivo));
		BufferedReader count = new BufferedReader(new FileReader(arquivo));

		int i = 0;
		this.linhas = new String[(int) count.lines().count()];
		while (lendo.hasNextLine()) {
			this.linhas[i] = lendo.nextLine();
			i++;
		}
		lendo.close();
		count.close();
	}

	public long CountLines(String arquivo) {
		/**
		 * Metodo conta linhas do arquivo
		 */
		BufferedReader r = null;
		long contalinha = 0;
		try {
			r = new BufferedReader(new FileReader(arquivo));
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo nao encontrado");
		}
		if (r != null) {
			contalinha = r.lines().count();
		}
		return contalinha;

	}

	public void InsereNomeNotas(String nome, int nota1, int nota2, int nota3, String arquivo) throws IOException {

		FileWriter escreve = new FileWriter(arquivo, true);
		StringBuilder sb = new StringBuilder();

		sb.append(nome);

		if (nome.toCharArray().length < 40) {
			for (int i = 0; i < 40 - nome.length(); i++) {
				char c = ' ';
				sb.append(c);
			}
			escreve.write(sb.toString() + "," + nota1 + "," + nota2 + "," + nota3 + "\n");
			escreve.close();
		} else {
			escreve.write(sb.toString().substring(0, 40) + "," + nota1 + "," + nota2 + "," + nota3 + "\n");
			escreve.close();
		}
	}

	public void RemoveFromFile(int id, String arquivo) {

	}

	public int ContaVogais(String arquivo, Character tipo) throws IOException {
		/**
		 * <a> Metodo retorna quantidade de vogais/consoante do arquivo<a>
		 */
		ReadFile(arquivo); // lendo arquivo
		int c_vogal = 0, c_consoante = 0;
		String s;
		Character vogal = '0';
		StringBuilder sB = new StringBuilder();

		// nesse loop - lendo o arquivo e atribuindo valores em variavel
		// usando StringBuilder
		for (int i = 0; i < linhas.length; i++) {
			s = linhas[i];
			sB.append(s);
		}

		// atribuindo a vogal o o charAt da String motada com StringBuilder
		for (int i = 0; i < sB.toString().toLowerCase().length(); i++) {
			vogal = sB.toString().toLowerCase().charAt(i);

			// Verifica se é letra.
			if (Character.isLetter(vogal)) {
				vogal = sB.toString().toLowerCase().charAt(i);
			}
			// verifica se é vogal e conta
			if (vogal == 'a' || vogal == 'e' || vogal == 'i' || vogal == 'o' || vogal == 'u') {
				c_vogal++;
			} else {
				// se nao é vogal conta consoante.
				c_consoante++;
			}
		}

		if (Character.toUpperCase(tipo) == 'C') {
			return c_consoante;

		} else if (Character.toUpperCase(tipo) == 'V') {
			return c_vogal;
		} else {
			return 0;
		}

	}

	public void Alteratexto(String arquivo, Character tipo, char troca) {
		/**
		 * construtor recebe arquivo, tipo: Vogal ou Consoante e tipo de caractere que
		 * vai substituir o valor do tipo determinado
		 * 
		 * @author eron
		 */
		Character.toLowerCase(tipo);

		if (Character.isLetter(tipo)) {

			try {
				Scanner ler = new Scanner(new FileInputStream(arquivo));
				String texto;

				if (tipo.equals('v')) {
					while (ler.hasNextLine()) {
						texto = ler.nextLine().toLowerCase().replace('a', troca).replace('e', troca).replace('i', troca)
								.replace('o', troca).replace('u', troca);
						System.out.println(texto);
					}
					ler.close();

				} else {
					while (ler.hasNextLine()) {
						texto = ler.nextLine().toLowerCase().replace('b', troca).replace('c', troca).replace('d', troca)
								.replace('f', troca).replace('g', troca).replace('h', troca).replace('j', troca)
								.replace('k', troca);
						System.out.println(texto);
					}
					ler.close();
				}
			} catch (FileNotFoundException e) {
				System.out.println("Arquivo nao encontrado");
			}
		} else {
			System.out.println("cacatere invalido: (" + troca + ") - só é permitido trocar letras");
		}

	}

}
