package exercicios;

import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;

//Escreva um programa que repita a leitura de uma senha até que ela seja válida. Para cada leitura de senha
//incorreta informada, escrever a mensagem "Senha Invalida". Quando a senha for informada corretamente deve ser
//impressa a mensagem "Acesso Permitido" e o algoritmo encerrado. Considere que a senha correta é o valor 2002.

public class VerificadorSenha {

	static Scanner sc = new Scanner(System.in);
	static String senhaInformada, senhaComparada, senhaTeste;
	
	
	public static void main(String[] args) {
		
		while(true) {
			boolean valida = true;
			
			CadastraSenha();
			VerificaSenha();
			
			if (!senhaInformada.equals(senhaComparada)) {
				System.out.println("informe novamente\n\n");
				valida = false;
			}else
				System.out.println("Casastrada com sucesso\n\n");

				
			while (valida) {
				if (Login().equals(senhaInformada)) {
					System.out.println("Acesso Permitido - valor é: " + senhaInformada);
					System.exit(0);
				}else {
					System.out.println("Senha Invalida\n\n");
				}
				
			}
		}
		
		
		
	}
	static private String CadastraSenha() {
		System.out.println("Informe sua senha");
		senhaInformada = sc.nextLine();
		return senhaInformada;
	}
	
	static private String VerificaSenha() {
		System.out.println("Repita ");
		senhaComparada = sc.nextLine();
		return senhaComparada;
	}

	static private String Login() {
		System.out.println("teste sua Senha ");
		senhaTeste = sc.nextLine();
		return senhaTeste;
	}
	
}
