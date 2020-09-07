package br.com.essencial.leitorLog;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Leitor  {

	String file = "//home//eron//Documents//Projects//leitorLog//10399//server.log";


	public void LeitorLog() {

		try {
			 BufferedReader bfLog = new BufferedReader(new FileReader(file)); 

			try {
				while (bfLog.ready()) {
					
					String log = bfLog.readLine();
						
					String log2 = log.trim().replace(" ", "").replace("id:", "NSU=");
					
					System.out.println(log2);
					
					
					
					
					

				}
				
			bfLog.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}

			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}





}
