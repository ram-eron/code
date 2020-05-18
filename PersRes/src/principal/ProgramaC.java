package principal;

public class ProgramaC {
	public static void main(String[] args) throws InterruptedException {
		/**
		  * @param args
		  * @throws InterruptedException
		  * executando o programa C 
		  * >>instaciando o obejeto Controle e invoca metodo CopiaArquivo()
		  * >> implementa thread para controle do tempo 
		 */
		String fileC = "//home//eron//Temp//dataC.txt"; // cada programa controla o diretorio do seu arquivo
		String fileA = "//home//eron//Temp//dataA.txt";
		String fileB = "//home//eron//Temp//dataB.txt";

		Controle c = new Controle();

		while (true) {
			c.Comparador(fileA, fileB, fileC);    // invocando metodo copia de segurança
			Thread.sleep(20000); // controle do tempo de execução
		}
		
	}
		
}
