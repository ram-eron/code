package exercicios;

import java.util.Scanner;

/*
Um Posto de combustíveis deseja determinar qual de seus produtos tem a preferência de seus clientes. Escreva
um algoritmo para ler o tipo de combustível abastecido (codificado da seguinte forma: 
1.Álcool 
2.Gasolina 
3.Diesel
4.Fim
). 
Caso o usuário informe um código inválido (fora da faixa de 1 a 4) deve ser solicitado um novo código (até
que seja válido). O programa será encerrado quando o código informado for o número 4. Deve ser escrito a
mensagem: "MUITO OBRIGADO" e a quantidade de clientes que abasteceram cada tipo de combustível, conforme
exemplo.
 */

public class PostoGasolinaPreferencia {

	static Scanner sc = new Scanner(System.in);
	static int gasolina = 0, alcool = 0, diesel = 0;

	public static void main(String[] args) {

		while (true) {
		
			switch (CombustivelAbastecido()) {
			case 1:
				alcool+=1;
				break;
			case 2:
				gasolina+=1;
				break;
			case 3:
				diesel+=1;
				break;
			case 4:
				System.out.println("Alcool = " + alcool);
				System.out.println("Gasolina = " + gasolina);
				System.out.println("Diesel = " + diesel);
				System.out.println("\n\nMUITO OBRIGADO");
				System.exit(0);
				break;

			default:
					System.out.println("Opcão Invalida");
			}
		}

	}

	static private int CombustivelAbastecido() {
		System.out.println("Informe o tipo de comustivel abastecido");
		System.out.println("1 - alcool ");
		System.out.println("2 - gasolina ");
		System.out.println("3 - diesel ");
		System.out.println("4 - SAIR ");
		return sc.nextInt();
	}

}
