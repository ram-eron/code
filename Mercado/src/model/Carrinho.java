package model;

import java.util.ArrayList;

public class Carrinho {

	ArrayList<Produto> listaCarrinho = new ArrayList<Produto>();
	private double valorTotal;
	
	public ArrayList<Produto> getListaCarrinho() {
		return listaCarrinho;
	}
	
	public void AdicionaValor(double valor) {
		this.valorTotal = this.valorTotal + valor;
	}
	
	public double getValorTotal() {
		return this.valorTotal;
	}
	
}
