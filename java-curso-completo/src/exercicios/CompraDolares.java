package exercicios;

import java.util.Scanner;

public class CompraDolares {

	static double precoDolar = 3.10;
	static double imposto = 0.06;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Amount to be paid in reais: " + CovercaoReal(EntradaDados()));
		
		
	}

	static private double EntradaDados() {
		System.out.println("How many dollars will be bought? ");
		double qtdDollares = sc.nextDouble();
		sc.close();
		return qtdDollares;
	}
	
	static private double CovercaoReal(double valorCompra) {
		double conv = valorCompra * precoDolar;
		return (conv * imposto) + conv;
	}
	
}
