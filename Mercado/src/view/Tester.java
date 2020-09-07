package view;

import model.Controller;

public class Tester {
	

	public static void main(String[] args) {
	

		Controller.Cadastrarproduto("bola", 1.99);
		Controller.Cadastrarproduto("tv", 1000.99);
		Controller.Cadastrarproduto("bike", 99.89);
		
		//ctr.MostrarEstoque();

		//ctr.EncontraProdutoNome("bola");
		Controller.ComprarProduto("bola");
		Controller.ComprarProduto("tv");
		Controller.ComprarProduto("bola");
		
		System.out.println(Controller.MostraCarrinho());
	}
}
