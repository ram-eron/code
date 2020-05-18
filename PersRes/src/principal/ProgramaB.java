package principal;

public class ProgramaB {

	public static void main(String[] args) throws InterruptedException {
		/**
		  * @param args
		  * @throws InterruptedException
		  * executando o programa B 
		  * >>instaciando o obejeto Controle e invoca metodo CopiaArquivo()
		  * >> implementa thread para controle do tempo 
		 */
		String fileA = "//home//eron//Temp//dataA.txt";  //Arquivo programa A, usado para comparação
		String fileB = "//home//eron//Temp//dataB.txt"; // cada programa controla o diretorio do seu arquivo

		Controle b = new Controle();
		while (true) {
			b.CopiaArquivo(fileA, fileB);    // invocando metodo copia de segurança
			Thread.sleep(500); // controle do tempo de execução
		}
		
	}

}
