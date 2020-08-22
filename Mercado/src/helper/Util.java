package helper;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	static SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
	
	static NumberFormat nf = new DecimalFormat("R$ ##0.00");
	
	public static String getConvDate(Date date) {
		return dtf.format(date);
	}
	
	public static String getConNum(double valor) {
	 return	nf.format(valor);
	}
	
	
	
}
