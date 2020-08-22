package model;

import java.util.ArrayList;

public class Estoque extends Produto {
	
	ArrayList<Produto> estoque = new ArrayList<Produto>();
	
	public void adicionaProduto(Produto produto ) {
		estoque.add(produto);	
	}

	public ArrayList<Produto> getEstoque() {
		return this.estoque;
	}	
	
	
	
}
