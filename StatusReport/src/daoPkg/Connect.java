package daoPkg;
import java.sql.*;


public class Connect {  
	private Connection conexao;  
	public Statement statement;  
	public ResultSet resultset;  
	public PreparedStatement prep;  


	public boolean conecta()  {  

		try {
			Class.forName("org.sqlite.JDBC");  
			//banco de dados da conexão
			conexao =  
					DriverManager.getConnection("jdbc:sqlite:/usr/sqllite/databases/cpi_Ms.db");  

			statement = conexao.createStatement(); 

			conexao.setAutoCommit(false);  
			conexao.setAutoCommit(true);  
			
			return true;

		} catch (Exception e) {
			System.out.println("Erro ao conectar no banco de dados" + " " + e.getMessage());
			return false;
		}
	}  

	// query 
	public void exec(String sql) throws Exception {  
		try {
			this.resultset = statement.executeQuery(sql);  

		} catch (NullPointerException e) {
			System.out.println("loga null pointer" + e.getMessage());
		}
	} 

	public void desconecta()  
	{  
		boolean result = true;  
		try  
		{  
			conexao.close();
			//System.out.println("Conexao com Banco de dados encerrada");
		}  
		catch(SQLException fecha)  
		{  //System.out.println("Conexao com Banco de dados encerrada" + fecha.getMessage());
			result = false;  
		}  

	}  
} 
