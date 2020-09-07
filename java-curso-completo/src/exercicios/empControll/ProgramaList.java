package exercicios.empControll;

import java.util.ArrayList;
import java.util.Scanner;

public class ProgramaList {

	public static void main(String[] args) {

		int qtdCadastrar;
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Employee> emp = new ArrayList<Employee>();
		
		System.out.println("Informe a quantidade de empregados a cadastrar: ");
		qtdCadastrar = sc.nextInt();
		
		for (int i = 0; i < qtdCadastrar; i++) {
						
			System.out.println("informe o ID do funcionario: ");
			int id = sc.nextInt();
			
			for (Employee e : emp) {
				while (e.getId().equals(id)) {
					System.out.println("ID em uso, informe outro id");
					id = sc.nextInt();
				}
			}
			
			System.out.println("informe o nome do funcionario de ID: " + id);
			sc.nextLine();
			String nome = sc.nextLine();
				
			System.out.println("informe o Salario de [ " + nome + " ID: " + id +" ]");
			Double salario  = sc.nextDouble();
				
			emp.add(new Employee(id, nome, salario));
				
			}
		
		System.out.println("Informe o ID do funcionario para merito: ");
		int id = sc.nextInt();
		
		for (Employee e : emp) {
			if (e.getId().equals(id)) {
				System.out.println("informe a porcentagem: ");
				int pct = sc.nextInt();
				e.AumentoSalario(pct);
			}else {
				System.out.println("usuario nao existe ");
			}
			
		}
		
		
		for (Employee e : emp) {
			System.out.println(e.toString());
		}
		
		
		
		sc.close();
	}
	
	

}
