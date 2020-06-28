package RunPkg;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailApp {

	private Properties props = new Properties();
	private DateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Parâmetros de conexão com servidor Gmail
	 */

	public MailApp() {

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true"); //TLS

	}

	// Ativa Debug para sessão

	public void MontaMensagem(String endeDe, String endPara, String mensagem ) {
		try {
			  	Session session = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() 
				{
					return new PasswordAuthentication("eron.palmeiras@gmail.com","Her@nd1l30");
				}
			});
			  	
			//session.setDebug(true);
			System.out.println( "- Log - " + session.getDebugOut()); //implementar saida do log de email
			
			//instanciando objeto Messagem para montar email
			Message message = new MimeMessage(session);
			
			//setando email origem
			message.setFrom(new InternetAddress(endeDe)); 

			//Destinatário (nesse metodo o construtor permite somente um email de destino)
			Address[] endsTo = InternetAddress.parse(endPara);

			message.setRecipients(Message.RecipientType.TO, endsTo);

			//Assunto
			message.setSubject("[Suporte a Sistemas] - Status Report" 
									+ " " + formatData.format(Calendar.getInstance().getTime()));
			
			message.setContent(mensagem, "text/html");
			
			//Método para enviar a mensagem criada
			System.out.println("- Log - " + " enviando email para o cliente: " + endPara + "\n");
			Transport.send(message);

			//log
			System.out.println("- Log - " + " enviado email para: " + endPara);

		} catch (MessagingException e) {
			
			throw new RuntimeException(e);
		}
	}

}