package model;

public class Controller {

	static Estoque estoque = new Estoque();
	static Carrinho carrinho = new Carrinho();

	public static void Cadastrarproduto(String nome, double preco) {
		estoque.adicionaProduto(new Produto(nome, preco));

	}

	public static void MostrarEstoque() { 
		if (estoque.getEstoque().isEmpty()) {
			System.out.println("Nenhum produto cadastrado");
		}else {
			for (Produto produto : estoque.getEstoque()) {
				System.out.println(produto.getNome() + " " + produto.getPreco());
			}
		}
	}

	public static void ComprarProduto(String nomeProduto) {		
		carrinho.AdicionaValor(EncontraProdutoNome(nomeProduto));
	}

	private static double EncontraProdutoNome(String nomeProduto) {
		for (Produto produto : estoque.getEstoque()) {
			if (nomeProduto.equals(produto.getNome())) {
				System.out.println("produto escolhido: " + produto.getNome());
				return produto.getPreco();
			}
		}
		return 0;
	}

	public static double MostraCarrinho() {
		return carrinho.getValorTotal();
	}

}
