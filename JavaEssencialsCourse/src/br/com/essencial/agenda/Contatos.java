package br.com.essencial.agenda;

import br.com.essencial.arquivo.Arquivo;

public class Contatos extends Arquivo {

	private String nome;
	private String telefone;
	private int dia, mes;
	
	String[] nomes;

	public void setContato(String nome,	String telefone,int dia, int mes ) {
		this.nome = nome;
		this.telefone = telefone;
		this.dia = dia;
		this.mes = mes;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public String getTelefone() {
		return telefone;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNomes(String[] nomes) {
		this.nomes = nomes;
	}

	public String[] getNomes() {
		return nomes;
	}
	
	public void setIndice(int indice, String texto) {
		nomes[indice] = texto;
	}
}
