package exercicios;

import java.util.Scanner;

public class Maior {
	
	static int maior;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.println("informe o valor " + (i+1));
			verificaMaior(sc.nextInt());
		}
		sc.close();
		
		System.out.println(maior);
	}
	
	static private void verificaMaior(int valor) {
		if (valor > maior) {
			maior = valor;
		}
	}
}
