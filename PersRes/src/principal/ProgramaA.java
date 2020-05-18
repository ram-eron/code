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
		String file = "//home//eron//Temp//dataA.txt";
		char sch = '5';
		while (true) {
			
			c.InsereControl(file);	//invoca a criação do controle
			
			
			if (sch == '1' ) {
				Thread.sleep(5000);
				System.out.println(sch);
				sch = '5';
			}else {
				Thread.sleep(1000);
				System.out.println(sch);
				sch = '1';
					
			}

		
			}

	}

}