package exercicios.matriz;

import java.util.Scanner;

public class Vizinhanca {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int [][] mat;
		
		System.out.println("informe quantas colunas :");
		int colu = sc.nextInt();
		System.out.println("informe quantas colunas :");
		int linhas = sc.nextInt();
		
		mat = new int[colu][linhas];
		int aux = 0;
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = aux;
				System.out.print(mat[i][j]+ "\t");
				aux++;
			}
			aux *= 3;
			System.out.println();
		}
		//reiniciando a variavel aux
		aux=0;
		
		System.out.println("\ndigite um numero contido na matriz: ");
			aux = sc.nextInt();
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				
				if (aux == mat[i][j]) {
					System.out.println("posição: " + i + "," + j);
					
					//left
					if(j > 0 ) {
						System.out.println("left: " + mat[i][j-1]);
					}else{
						System.out.println("left: _");
					}
					
					//right
					if(j < mat[j].length ) {
						System.out.println("right: " + mat[i][j+1]);
					}else{
						System.out.println("right: _");
					}
					
					//up
					if(i > 0 ) {
						System.out.println("up: " + mat[i-1][j]);
					}else{
						System.out.println("up: _");
					}
					
					//down
					if(i < mat[i].length ) {
						System.out.println("down: " + mat[i+1][j]);
					}else{
						System.out.println("down: _");
					}
					
				}
				
			}
		}
		
		sc.close();
	}

}
