package exercicios;

import java.util.Scanner;


/*
Leia 1 valor inteiro N, que representa o número de casos de teste que vem a seguir. 
Cada caso de teste consiste de 3 valores reais, cada um deles com uma casa decimal. 
Apresente a média ponderada para cada um destes conjuntos de 3 valores, sendo que o primeiro valor tem peso 2, 
o segundo valor tem peso 3 e o terceiro valor tem
peso 5.
*/

public class MediaLoop {

	static Scanner sc = new Scanner(System.in);
	static int qtdCasos = 0;
	
	public static void main(String[] args) {
		
		InformaQtdCasos();	
		
		double[] arrayApoio = new double[qtdCasos]; 
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < arrayApoio.length; j++) {
				System.out.println("informe o valor " + (j+1));
				arrayApoio[j] = sc.nextDouble();
			}
			
		}
		
		for (int i = 0; i < qtdCasos; i++) {
			System.out.println(CalculaMedia(arrayApoio));
		}
		
	}

	static int InformaQtdCasos() {
		System.out.println("informe a quantidade de casos: ");
		return qtdCasos = sc.nextInt();
	}
	
	static double CalculaMedia(double[] arrayApoio) {
		double media = 0;
		for (int i = 0; i < arrayApoio.length; i++) {
			media += arrayApoio[i];
		}
		return media = media/arrayApoio.length;
	}
	
}
