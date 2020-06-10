package br.com.essencial.arquivo;

import java.util.Calendar;

public class Calendario {

		Calendar c = Calendar.getInstance();
		
		int mes = c.get(Calendar.MONTH) + 1;
		
		public int getMes() {
			return mes;
		}
		
}
