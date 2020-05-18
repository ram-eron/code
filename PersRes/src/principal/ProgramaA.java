package 	principal;

public class ProgramaA {
	/** 
	 * @param args
	 * @throws InterruptedException
	 * executando o programa A 
	 * >>instaciando o obejeto Controle e invoca metodo Run ( extensão da classe Thread)
	 * >> implementa thread para controle do tempo 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		Controle c = new Controle();
		String file = "//home//eron//Temp//dataA.txt"; // cada programa controla o diretorio do seu arquivo
		char sch = '5';
		while (true) {
			
			c.InsereControl(file);	//invoca a criação do controle
			
			
			if (sch == '1' ) {
				Thread.sleep(5000); // executando em 5 seg
				sch = '5';
			}else {
				Thread.sleep(1000); // executando em 1 seg
				sch = '1';
					
			}

		
			}

	}

}