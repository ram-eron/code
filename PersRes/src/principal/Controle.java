package principal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;

public class Controle {
	/**
	 * @author eron
	 * Objeto contem os metodos: 
	 * 		Run() - metodo cria arquivo1
	 *  	>> le o arquivo e verifica o valor
	 * 		>> atribui o valor ao contador para incremento
	 * 
	 * 		metodo privado CriaArquivo() para criar arquivo A caso nao exista
	 * 
	 * 		metodo CopiaArquivo(String file) Copia dado do Arquivo A para o B
	 * 		
	 *		metodo Comparador(String fileA, String fileB, String fileC ) compara arquivos e direciona saida para Arquivo C
	 *
	 *  	>> caso nao encontre o arquivo, cria um novo com indice 0 atravez do metodo CriaArquivo()
	 */		
	
	private String file;
	private int contador;
	float igual = 0f, dif = 0f; 
	private int contadorB; 

	
	public void InsereControl() {}
	
	public void InsereControl(String file) {
		/**
		 * le arquivo e incrementa contador
		 */
		this.file = file;
		Scanner lerF;
		PrintStream insF;
			
			try {
				lerF = new Scanner(new FileInputStream(file));
				this.contador = lerF.nextInt();	//atribui primeiro inteiro ao contador
				lerF.close();
			
				insF = new PrintStream(new FileOutputStream(file, false));
				this.contador++;			//incrementa contador
				insF.print(this.contador);		//insere valor ja incrementado no arquivoA
				System.out.println("log:" + file +  "  =  " + this.contador); // Debug(log)
				insF.close();
				
				Backup(file, "//home//eron//Temp//dataB.txt");
			
		} catch (FileNotFoundException e) {
			CriaArquivo(); // se o arquivo nao existir chama o metodo CriaArquivo()
			System.out.println("arquivo nao encontardo, contador zerado com novo arquivo");
		}
		
	}
	
	private void CriaArquivo() {
		/**
		 * @author eron
		 * classe somente para uso desse objeto
		 * metodo cria arquivo de controle com indice 0
		 */
		PrintStream c_file;
		try {
			c_file = new PrintStream(new FileOutputStream(file, false));
			c_file.append('0');
			c_file.close();

		} catch (FileNotFoundException e) {
			System.out.print("Erro na criação, verifique permissões do diretorio");
		}
	}
	
	
	private void Backup(String fileA, String fileB) {
	
		Scanner lerF;
		PrintStream insF;
		
			try {
				lerF = new Scanner(new FileInputStream(fileA));
				this.contadorB = lerF.nextInt();
				lerF.close();
			
				insF = new PrintStream(new FileOutputStream(fileB, false));
				insF.print(this.contadorB);
				
		}catch (FileNotFoundException e) {
				System.out.println("ERRO");
		}
		
}
	
	public void CopiaArquivo(String fileA, String fileB) {
		/**
		 * Le valor do arquivo A e insere no B
		 */
		Scanner lerF;
		PrintStream insF;
		
			try {
				lerF = new Scanner(new FileInputStream(fileA));
				this.contadorB = lerF.nextInt();
				lerF.close();
			
				insF = new PrintStream(new FileOutputStream(fileB, false));
				insF.print(this.contadorB);
				System.out.println("log:" + fileB +  "  =  " + this.contadorB); //debug (log)
				
		}catch (FileNotFoundException e) {
				System.out.println("ERRO");
		}
		
}
	
	public void Comparador(String fileA, String fileB, String fileC ) {
		/**
		 * Metodo comparador dos arquivos
		 * Cria arquivo C
		 */
		Scanner ler; 
		int a,b;
		PrintStream insF;
		Date data = new Date();
		try {
				ler = new Scanner(new FileInputStream(fileA));
				a = ler.nextInt(); // valor do arquivo A
				ler = new Scanner(new FileInputStream(fileB));
				b = ler.nextInt(); //valor do arquivo B
				String x;
				
				if (a==1) {
					this.dif = 0;
					this.igual = 0; 
				}

				
				if (a==b) {
					x = "IGUAIS";
					this.igual++;
				}else {
					x = "DIFERENTES";
					this.dif++;
				}
				
				//String x = (a==b)?"IGUAIS":"DIFERENTES"; // ternario: compara valores dos arquivos
				
				insF = new PrintStream(new FileOutputStream(fileC, true));
 				insF.println(data + " " + x );  	// saida para o arquivo de comparação 
 				System.out.println(data + " - " + x + "     [ PERCENTUAL OK: " + Math.round((this.igual/(this.igual+this.dif))*100)+ " ]"); //Debug (log)
				
				
				ler.close();
				
		}catch (FileNotFoundException e) {
				System.out.println("ERRO, verifique permissões no diretorio"); // em caso de erro de permissão no diretorio
		}
		
			
		
	}
	
	
}