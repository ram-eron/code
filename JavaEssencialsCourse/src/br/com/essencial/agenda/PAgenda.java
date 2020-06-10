package br.com.essencial.agenda;

import java.io.IOException;
import java.util.Scanner;

public class PAgenda {

	public static void main(String[] args) throws IOException {

		ControleAgenda nome = new ControleAgenda();
		int qtdNomes;
		Scanner in = new Scanner(System.in);
		boolean inicia = true;
		int ctrInicia = 7;

		while (inicia) {

			try {
				nome.ReadFile(nome.getFile());

			} catch (Exception e) {
				nome.InsertInFile("0, NOME, TELEFONE, DIA, MES", nome.getFile());
			}

			nome.ReadFile(nome.getFile());
			
			System.out.println(" \n------ Menu ------ : \n\n" 
					+ "1 - Mostrar Contatos\n"
					+ "2 - Pesquisar Contato por nome\n" 
					+ "3 - Listar Contatos iniciados por letra\n"
					+ "4 - Aniversariantes do Mes\n" 
					+ "5 - Inserir Contato\n" 
					+ "6 - Remover Contato\n" 
					+ "0 - SAIR"
					+ "\n\n------------------ ");
			
			try {
				ctrInicia = in.nextInt();
			} catch (Exception e) {
			}

			switch (ctrInicia) {
			case 0:
				inicia = false;
				in.close();
				break;
				
					//Mostrar contatos
			case 1:
				for (int i = 0; i < nome.getlinhas().length; i++) {
					nome.setNomes(nome.getlinhas());
				}
				for (int i = 0; i < nome.getlinhas().length; i++) {
					System.out.println(nome.getNomes()[i]);
				}

				System.out.println("\nPressione qlqer tecla para sair: ");
				in.next();

				break;

					// Pesquisa contato pelo nome
			case 2:
					in.nextLine();
					System.out.println("Informe o contato: ");
						String contato = in.nextLine();
					nome.PesquisContato(contato);
				
				break;

					//Pesquisa pela Letra
			case 3:
					in.nextLine();
					System.out.println("Informe a LETRA: ");
					String letra = in.next();
					nome.PesquisContatoLetra(letra);
		
					break;

			case 4:
					//aniversariantes do mes corrente
					nome.Aniversariantes();
				
				break;

			case 5:
					//Inserindo Nomes
					System.out.println("Quantos nome deseja inserir ? ");
					qtdNomes = Integer.parseInt(in.next());
					// descarta a quebra de linha
					in.nextLine();
				
					int iteradorNome = 1;
				
				while (qtdNomes > 0) {
						
					System.out.println("Digite o " + iteradorNome + "º " + "nome : ");
					nome.setNome(in.nextLine());

					System.out.println("Digite o DIA do nascimento: ");
					nome.setDia(Integer.parseInt(in.nextLine()));

					System.out.println("Digite o MES do nascimento: ");
					nome.setMes(Integer.parseInt(in.nextLine()));

					System.out.println("Digite o telefone: ");
					nome.setTelefone(in.next());
					// descarta a quebra de linha
					in.nextLine();

					try {
						nome.InserirContato(nome.getNome(), nome.getTelefone(), nome.getDia(), nome.getMes());

					} catch (IOException e) {
						System.out.println("Erro na inserção do nome");
					}
					qtdNomes--;
					iteradorNome++;
				}
				break;

			case 6:
				int id;
				System.out.println("informe o ID do contado a remover: ");
				id = in.nextInt();
				try {
						nome.RemoveContato(id);

				} catch (Exception e) {
					System.out.println("Erro: Valor não corresponde a nenhum ID");
				}
				break;
				
			case 7 :
				System.out.println(" OPÇÃO INVALIDA ");
				in.next();

			}
		}
	}
	
}
