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
 * classe contem os clientes a partir do aquivo de configuração JSON
 * @author eron
 */

public class Clientes {
	
	// instaciando objetos para leitura do JSON
	JSONParser parserJS = new JSONParser();
	JSONArray  arrayJS = new JSONArray();
	JSONObject objJS = new JSONObject();

	private Map<String, String> cliMailMap = new HashMap<String, String>();

	public Map<String, String> getCliMailMap() {
		return cliMailMap;
	}

	public Clientes() {
		SetClientes();
	}

	public String EncontraEmail(String cliente) {
		return this.cliMailMap.get(cliente.toLowerCase());
	}
	
	
	//metodo para encontrar os clientes
	private void SetClientes() {
		try {
			//parseando o arquivo .json em um arrayJSON
			arrayJS = (JSONArray) parserJS.parse(new FileReader("/home/eron/Documents/Projects/StatusReport/clientes.json"));

			//inserindo os objetos do array no objeto Map<cliente, email> dessa classe
			for (Object object : arrayJS) {
				// para cada objeto do arrayJSON instancia um novo ObjJSON
				objJS = (JSONObject) object;
				
				//insereindo o objeto criado no Map
				this.cliMailMap.put((String)objJS.get("nome").toString().toLowerCase(),
								(String) objJS.get("email").toString().toLowerCase());
				}
		} 
		catch (FileNotFoundException e) {
			System.out.println("Arquivo de configuração nao encontrado" + " " + e.getMessage());
		} 
		catch (IOException e) {
			System.out.println("Falha no Arquivo" + " " + e.getMessage());
		} 
		catch (ParseException e) {
			System.out.println("Falha na conversão dos dados de configuração" + " " + e.getMessage());
		}
	}
	
	
	@Override
	public String toString() {
		return "Clientes [cliMailMap=" + cliMailMap + "]";
	}

}



