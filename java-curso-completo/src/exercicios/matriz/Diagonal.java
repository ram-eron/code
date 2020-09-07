package exercicios.matriz;

public class Diagonal {

	public static void main(String[] args) {
		
		int[][] mat = new int [3][3];
		
		int aux = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				mat[i][j] = aux;
				mat[i][j] = (aux > 3)?aux*-1:aux;
				aux++;
			}
		}
		
		int auxneg=0;
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j]);
				System.out.print("    ");
				if (mat[i][j] < 0) {
					auxneg++;
				}
			}
			System.out.println();
		}
	
		System.out.println("qtd de negativos: " + auxneg + "\n\n");
		
		System.out.print("diagonal: ");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print( mat[i][j] + " ");
				i++;
			}

		}
	
	
	}
}
