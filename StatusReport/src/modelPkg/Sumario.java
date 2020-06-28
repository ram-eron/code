package modelPkg;

public class Sumario {
	private String email;
	private String sumario;
	StringBuilder sb = new StringBuilder();
	
	public Sumario(String email, String sumario) {
	
		this.email = email;
		this.sumario = sumario;
	}

	public String getEmail() {
		if (this.email == null) {
			return "";
		}
		else {
			return email;
		}
	}
	public String getSumario() {
		if (this.sumario ==  null) {
			return "";
		}else {
			return sumario;
		}
		
	}

	public void AppendSumario(String sumario) {
		this.sumario = sb.append(sumario).toString();
	}
	

}
