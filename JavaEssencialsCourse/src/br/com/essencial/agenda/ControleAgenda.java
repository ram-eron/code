package br.com.essencial.agenda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import br.com.essencial.arquivo.Calendario;

/**
 * Classe de controle da Agenda
 * 
 * @author eron
 *
 */
public class ControleAgenda extends Contatos {

	private String file = "//home//eron//Documents//Javas//Exercises//Agenda//agenda.txt";
	private String fileBkp = "//home//eron//Documents//Javas//Exercises//Agenda//agendabckp.txt";
	private int contador = 1;

	public String getFile() {
		return file;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public int getContador() {
		return contador;
	}

	/**
	 * Metodo insere contato
	 * 
	 * @param nome
	 * @throws IOException
	 */
	public void InserirContato(String nome, String telefone, int dia, int mes) throws IOException {
		try {
			ReadFile(this.file);
			this.contador = Integer.parseInt(getlinhas()[(int) CountLines(file) - 1].split(",")[0]);
		} catch (IOException e) {
		}

		InsertInFile(++this.contador + ", " + nome + ", " + telefone + ", " + dia + ", " + mes, file);
	}

	/**
	 * Remove usuario passado no parametro ID
	 * 
	 * @param id
	 * @param nome
	 * @throws IOException
	 */
	public void RemoveContato(int id) throws IOException {

		String nome, telefone, dia, mes;
		int idver;
		
		copyFile(this.file, this.fileBkp); // bkp
		LimpaArquivo(file); // limpa atual

		for (int i = 0; i < getNomes().length; i++) {
			idver = Integer.parseInt(getNomes()[i].split(",")[0].trim());

			if (id == idver) {
				setIndice(i, "LIVRE");
				}
			}

		for (int i = 0; i < getNomes().length; i++) {
			if (getNomes()[i] != "LIVRE") {
				id = Integer.parseInt(getNomes()[i].split(",")[0].trim());

				nome = getNomes()[i].split(",")[1].trim();
				telefone = getNomes()[i].split(",")[2].trim();
				dia = getNomes()[i].split(",")[3].trim();
				mes = getNomes()[i].split(",")[4].trim();

				InsertInFile(id + ", " + nome + ", " + telefone + ", " + dia + ", " + mes, getFile());

				}
			}
		}
	
	/**
	 * Metodo Pesquisa contato
	 * @param contato
	 */

	public void PesquisContato(String contato) {
		String nomepesquisado = "";
		
		for (int i = 0; i < getlinhas().length; i++) {
			setNomes(getlinhas());
		}
		
		for (int i = 0; i < getNomes().length; i++) {
			if (contato.trim().equals(getNomes()[i].split(",")[1].trim())) {
				nomepesquisado = (getNomes()[i]);
			}
		}
		if (!nomepesquisado.isEmpty()) {
			System.out.println(nomepesquisado);
		}else 
			System.out.println("Nome nao econtrado");
	}
	
	/**
	 * Metodo lista contatos pela primeira letra do nome
	 * @param letra
	 */
	public void PesquisContatoLetra(String letra) {
		String letraVerificada;
		
		for (int i = 0; i < getlinhas().length; i++) {
			setNomes(getlinhas());
		}
		
		for (int i = 0; i < getNomes().length; i++) {
			letraVerificada = getNomes()[i].split(",")[1].trim().split("")[0];
			if (letraVerificada.toUpperCase().equals(letra.toUpperCase())) {
				System.out.println(getNomes()[i]);
			}
		}
	}
	
	
	public void Aniversariantes() {
		Calendario anivMes = new Calendario();
		
		for (int i = 0; i < getlinhas().length; i++) {
			setNomes(getlinhas());
		}
		
		for (int j = 1; j < getNomes().length; j++) {
		int mesNiverContatos = Integer.parseInt(getNomes()[j].split(",")[4].trim());
		
		if (mesNiverContatos == anivMes.getMes() ) {
			System.out.println(getNomes()[j]);
			
			}
		
		}
		
	}
	
	/**
	 * copia segura do arquivo na exclusão
	 * 
	 * @param file
	 * @param fileBKP
	 * @throws IOException
	 */
	private void copyFile(String file, String fileBKP) throws IOException {

		File source = new File(file);
		File destination = new File(fileBKP);

		if (destination.exists())
			destination.delete();

		FileChannel sourceChannel = null;
		FileChannel destinationChannel = null;

		try {
			sourceChannel = new FileInputStream(source).getChannel();
			destinationChannel = new FileOutputStream(destination).getChannel();
			sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);

		} finally {

			if (sourceChannel != null && sourceChannel.isOpen())
				sourceChannel.close();
			if (destinationChannel != null && destinationChannel.isOpen())
				destinationChannel.close();
		}
	}

}
