package model;

import java.util.Scanner;

public class Menu {
	static Scanner scanSelection = new  Scanner(System.in);
	
	private static void MenuEscolha() {
		System.out.println();
		System.out.println();
		System.out.println("#############################\n"
				 + "###### MERCADO CARNEIRO #####\n"
				 + "#############################\n\n");

		System.out.println(" Selecione a opção: "
			+ "\n 1 - Cadastrar Produto"
			+ "\n 2 - Listar Produtos"
			+ "\n 3 - Comprar Produto"
			+ "\n 4 - Visualizar Carrinho"
			+ "\n 5 - Sair");
	}
	
	public static void getOpcao(){
		MenuEscolha();
		int i = scanSelection.nextInt();
		
		switch (i) {
		case 1: 
				System.out.println("Informe o nome do produto ");
				scanSelection.nextLine(); // bug do scanner
				String nome = scanSelection.nextLine();
				
				System.out.println("Informe o valor do produto ");
				double valor = scanSelection.nextDouble();
				
				Controller.Cadastrarproduto(nome, valor);
			break;

		case 2:
			Controller.MostrarEstoque();
			break;
			
		case 3:
			System.out.println("informe o nome do produto");
			scanSelection.nextLine();
			String nomeCompra = scanSelection.nextLine();
			
			Controller.ComprarProduto(nomeCompra);
			
			break;
		
		case 4:
				System.out.println(Controller.MostraCarrinho());
			break;
			
		case 5:
				System.out.println("Total gasto: " + Controller.MostraCarrinho());
				System.exit(0);
			break;
		
		}
		
	};
	
	
	
	
}
