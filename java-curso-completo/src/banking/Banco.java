package banking;

import java.util.Scanner;

public class Banco {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Cliente cliente01;
	
		System.out.println("Informe o cliente: " );
		String nome = sc.nextLine();
		System.out.println("Informe a conta: (formato XXXX-XX)" );
		String idConta = sc.next();
		
		cliente01 = new Cliente(nome, idConta);
		
		System.out.println(cliente01);
		
		cliente01.Depositar(200.00);
		cliente01.Depositar(200.00);
		cliente01.Depositar(200.00);
		
		System.out.println("após depositos: ");
		System.out.println(cliente01);
		
		System.out.println("após saques: ");
		cliente01.Sacar(100.00);
		cliente01.Sacar(100.00);
		cliente01.Sacar(100.00);
		cliente01.Sacar(100.00);
		cliente01.Sacar(100.00);
		cliente01.Sacar(100.00);
		cliente01.Sacar(100.00);
		cliente01.Sacar(100.00);
		cliente01.Sacar(100.00);
		
		System.out.println(cliente01);
		
		
		sc.close();
		
	}

}
