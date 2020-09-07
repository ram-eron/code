package RunPkg;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import daoPkg.Connect;
import modelPkg.Chamados;
import modelPkg.Clientes;
import modelPkg.Sumario;

public class Main {

	static Connect con = new Connect();
	static Short captura = 0; //"cm"
	static String emailCaptura = "eron.palmeiras@gmail.com";
	
	//query para capturar os dados da tabela
	static String query = "SELECT * FROM MAIN.cpi_MS WHERE ESTADO <> 6 and ESTADO <> 7";


	public static void main(String[] args) throws Exception {

		
		//iniciando variaveis de controle da execução
		short horaDoEnvio = 8;
		short diaAtual = (short) (Calendar.getInstance().get(Calendar.DAY_OF_WEEK));
		short hora = (short) (Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
		boolean executado = true;
		//short horaExecutado = horaAtual ;
		short diaExecutado = diaAtual;
		
		while (true) {
			
			// verificando data
			diaAtual = (short) (Calendar.getInstance().get(Calendar.DAY_OF_WEEK));
			hora = (short) (Calendar.getInstance().get(Calendar.HOUR_OF_DAY));

			if (diaExecutado != diaAtual) {
				executado = true;
				
				System.out.println("- Log - " + Calendar.getInstance().getTime() + " Dia Reiniciado " 
					 +  " email programado para envio as " + horaDoEnvio + " horas");
			}
			
			if ( hora == horaDoEnvio && executado == true ) {
				try {
						Executa();
				} catch (Exception e) {
					
					System.out.println("Loga erro no envio do email");
				}finally {
					executado = false;
				}
				
				diaExecutado = (short) (Calendar.getInstance().get(Calendar.DAY_OF_WEEK));;
				executado = false;
			
			}
			
			else {
				System.out.println("- Log - " + Calendar.getInstance().getTime() + "  Aguardando momento da execução " 
						+ "- Programado para as " + horaDoEnvio + " horas" );
			}
				
			try {
					Thread.sleep(900000);//15 min
					
			} catch (InterruptedException e) {
				System.out.println("- Log - " + " processo interromp " + e.getMessage());
			}
		}			
	}
	
	
	///metodo do main	
	
	private static void Executa() throws Exception {
		System.out.println("- Log - " + "Conectando com banco de dados");
		
		if (con.conecta() == false) {
			//em caso de falha aborta o sistema
			System.out.println("- Log - " + " houve falha no programa ao tentar acesso ao banco");
			System.exit(0);
		};
		
		System.out.println("- Log - " + "Executando query");
		
		//inicia a query
		con.exec(query);

		//list<Chamados> onde serao armazenados os dados da query
		//Classe Chamados possui os atributos que serao obtidos da query
		ArrayList<Chamados> arrayMS = new ArrayList<Chamados>();
		
		//resultset com os dados obtidos do banco de dados
		System.out.println("- Log - " + "montando Lista com resultados do banco");
		while (con.resultset.next()) {
			//a cada execução um novo objeto é criado para poder ser adicionado no array
			Chamados ms = new Chamados();
			
			//associando dados ao objeto Chamados
			ms.setChamado(con.resultset.getInt("CHAMADO_MS"));
			ms.setUsuario(con.resultset.getString("USUARIO"));
			ms.setAbertoEm(con.resultset.getString("ABERTO_EM"));
			ms.setModificadoEm(con.resultset.getString("MODIFICADO_EM"));
			ms.setSumario(con.resultset.getString("SUMARIO"));
			ms.setAnalista(con.resultset.getString("ANALISTA_RESPONSAVEL"));
			ms.setEquipe(con.resultset.getShort("SUBCELULA"));
			ms.setEstado(con.resultset.getShort("ESTADO"));
			ms.setSistema(con.resultset.getString("SISTEMA"));
			ms.setAreaCliente(con.resultset.getString("AREA_CLIENTE"));
			ms.setDetalhamento(con.resultset.getString("DETALHAMENTO"));

			//add os resultsets dentro do array de dados do MS
			arrayMS.add(ms);
		}
		
		//fecha conexão com banco
		System.out.println("- Log - " + "Desconectando do Banco de dados");
		con.desconecta();
		
		//instaciando objetos das classe sistemas e clientes
		Clientes cliente = new Clientes();

		//array sumario para agrupar os dados do clientes
		ArrayList<Sumario> listaSumario = new ArrayList<Sumario>();
		ArrayList<Sumario> listaSumarioC = new ArrayList<Sumario>();
				
		//map onde ficarao os dados do sumario, a chave é o email do cliente
		HashMap<String, String> dadosReport = new HashMap<String, String>();
		
		//verifica se a equipe do sistema é captura				
				for (int i = 0; i < arrayMS.size();i++) {
					
					//verifica se o chamado é da captura
					if (arrayMS.get(i).getEquipe()==captura) {
					String area = arrayMS.get(i).getAreaCliente(); // area recebe do array o valor do nome area
					String emailarea = cliente.EncontraEmail(area); //emailarea recebe o email da area

					//monta o campo sumario
					System.out.println("- Log - " + "Montando campo sumario para o cliente: " + area);
					String mapSumario =					
						    "<tr>" +
							    "<td><strong>" + arrayMS.get(i).getChamado()  + "</strong></td>" +
						        "<td>" + arrayMS.get(i).getEstado()   + "</td>" +
						        "<td>" + arrayMS.get(i).getAbertoEm() + "</td>" +
						    	"<td>" + arrayMS.get(i).getAnalista() + "</td>" +
					            "<td>" + arrayMS.get(i).getAreaCliente()  + " </td>" +
					            "<td>" + arrayMS.get(i).getSumario()  + "</td>" +
					            "<td>" + arrayMS.get(i).getDetalhamento()+ "</td>" +
						    "</tr>";

					//Monta o primeiro array com o email da area e o sumario dos chamados
						listaSumario.add(new Sumario(emailarea, mapSumario));
					}	
				}
				
				//strig de apoio para montar o cabeçalho do email
				String headSumario = 
						"<p><strong><span style=\"color: #003300;\">Caro Cliente, </span></strong></p>" +
						"<p><span style=\"color: #003300;\">este &eacute; o Status Report semanal de seus chamados com o <strong>Suporte a Sistemas.</strong></span></p>" +
						"<p>&nbsp;</p>" +
						"<p>&nbsp;</p>" +
						"<table border=\"1\">" +
							   "<tr>" + 
							        "<td bgcolor=\"GREEN;\"><strong><span style=\"color: #ffffff;\">CHAMADO</span></strong></td>" +
							        "<td bgcolor=\"GREEN;\"><strong><span style=\"color: #ffffff;\">ESTADO</span></strong></td>" +
							        "<td bgcolor=\"GREEN;\"><strong><span style=\"color: #ffffff;\">DATA DE ABERTURA</span></strong></td>" +
							    	"<td bgcolor=\"GREEN;\"><strong><span style=\"color: #ffffff;\">ANALISTA</span></strong></td>" +
						            "<td bgcolor=\"GREEN;\"><strong><span style=\"color: #ffffff;\">AREA</span></strong></td>" +
						            "<td bgcolor=\"GREEN;\"><strong><span style=\"color: #ffffff;\">SUMARIO</span></strong></td>" +
						            "<td bgcolor=\"GREEN;\"><strong><span style=\"color: #ffffff;\">DETALHAMENTO</span></strong></td>" +
							    "</tr>" ;
				
				//String de apoio para montar o final do email
				String bottomSumario =
						"</table>" +
								"<p>&nbsp;</p>" +
						"<p><span style=\"color: #003300;\">Estamos atuando para solu&ccedil;&atilde;o o mais breve poss&iacute;vel</span></p>" ;
				
			//array de apoio recebe os dados do primeiro array 
			listaSumarioC = listaSumario;
			
			System.out.println("- Log - " + "associando cada area com seu respectivo conteudo");
			//loop para preencher o Map com os dados do array ja organizados
			for (int i = 0; i < listaSumario.size(); i++) {
					
				//a cada iteração um novo objeto suamrio é criado
				Sumario s = new Sumario(listaSumarioC.get(i).getEmail(), listaSumarioC.get(i).getSumario());
					
				for (int j = 0; j < listaSumarioC.size(); j++) {
						
					//agrupa o sumario dos chamados pelo email da area para inserir no map
					//no Map, para cada email (key) um sumario com todos os chamados (value)
					if (listaSumarioC.get(j).getEmail().equals(listaSumario.get(i).getEmail())) {
						s.AppendSumario(listaSumario.get(j).getSumario());
						
						System.out.println("- Log - " + "inserindo no MAP de emails o conteudo do email do cliente: " + s.getEmail());
						dadosReport.put(s.getEmail(), s.getSumario());
					}
				}
			}
				
		//objeto classe email
		MailApp report = new  MailApp();
		
		//enviando os emails para cada objeto do map
		System.out.println("- Log - " + "enviando emails para os clientes ");
		dadosReport.forEach((k,v) -> {
					System.out.println(dadosReport);
					report.MontaMensagem(emailCaptura, k , headSumario + v + bottomSumario);
					System.out.println("- Log - " + "email para equipe: " + k + " enviado! ");
		});
		//System.out.println(dadosReport);
	}
		
}
