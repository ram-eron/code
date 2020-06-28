package modelPkg;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * classe contem os sistemas a partir do aquivo de configuração JSON
 * @author eron
 */
public class Sistemas {
	
	//instanciando os objetos par leitura do JSON de configuração
	JSONParser parserJS = new JSONParser();
	JSONArray arrayJS = new JSONArray();
	JSONObject objJS = new JSONObject();
		
	// cria map para classe com o nome do sistema e a equipe
	private Map<String, String> sistema = new HashMap<String, String>();

	/**
	 * Construtor ja inicia o map com os valores da classe
	 */

	public Sistemas() {
		setSistemas();
	}

	public Map<String, String> getSistema() {
		return sistema;
	}
	
	public String BuscaEquipe(String s) {
		return sistema.get(s);
	}
	

	private void setSistemas() {

		try {
			// parseando o arquivo json para um arrayJSON
			arrayJS = (JSONArray) parserJS.parse(new FileReader("sistemas.json"));
			
			//para cada objeto do array, cria um novo objetoJSON
			for (Object object : arrayJS) {
				objJS = (JSONObject) object;
			//aqui insere o objeto relacionado no Map criado para esta classe
				sistema.put((String) objJS.get("sistema").toString().toLowerCase(), 
							(String) objJS.get("equipe").toString().toLowerCase());
			}
		}

		catch (FileNotFoundException e) {
			System.out.println("Arquivo de configuração nao encontrado" + " " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Falha no Arquivo" + " " + e.getMessage());
		} catch (ParseException e) {
			System.out.println("Falha na conversão dos dados de configuração" + " " + e.getMessage());
		}

	}

	@Override
	public String toString() {
		return "Sistemas [sistema=" + sistema + "]";
	}

	
	
}
