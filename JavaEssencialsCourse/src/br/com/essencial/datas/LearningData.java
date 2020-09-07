package br.com.essencial.datas;

import java.text.Format;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LearningData {

	public static void main(String[] args) {

		LocalDate dt = LocalDate.now();
		LocalDateTime dh = LocalDateTime.now();
		
		DateTimeFormatter formatdate = DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm");
		
		
		System.out.println(dt);
		System.out.println(dh.getMinute());
		
		int minuto = 35;
		
		while (minuto != LocalDateTime.now().getMinute()) {
			System.out.println("o minuto é diferente do minuto atual ");
			
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("minuto é maior ou igual ao minuto atual");
		
		
		
		
		
	}

}
