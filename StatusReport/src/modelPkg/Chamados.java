package modelPkg;

public class Chamados {
	
	private short equipe;
	private short estado;
	private int chamado;
	private String usuario;
	private String sumario;
	private String abertoEm;
	private String modificadoEm;
	private String analista;
	private String sistema;
	private String areaCliente;
	private String detalhamento;

	public int getChamado() {
		return chamado;
	}
	public void setChamado(int chamado) {
		this.chamado = chamado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		if (usuario == null) {
			this.usuario =  "";
		}else {
			this.usuario = usuario;
		}
	}
	public String getSumario() {
		return sumario;
	}
	public void setSumario(String sumario) {
		if (sumario == null) {
			this.sumario =  "";
		}else {
			this.sumario = sumario.toLowerCase();
		}
	}
	public String getAbertoEm() {
		return abertoEm;
	}
	public void setAbertoEm(String abertoEm) {
		if (abertoEm == null) {
			this.abertoEm =  "";
		}else {
			this.abertoEm = abertoEm.toLowerCase();
		}
	}
	public String getEstado()  {
		switch (this.estado) {
		case 0: 
				return "Aberto";
		case 1: 
			return "Em Atendimento";
		case 2: 
			return "Encaminhado";
		case 3: 
			return "Pendente Usuario";
		case 4: 
			return "Pendente";
		case 5: 
			return "Reaberto";
		case 6: 
			return "Resolvido";
		case 7: 
			return "Fechado";
		case 8: 
			return "Aguardando Implantação";
		default:
			return this.estado + "" ;

		}
		
		
	}
	public void setEstado(short estado) {
		this.estado = estado;
	}
	public String getAnalista() {
		return analista;
	}
	public void setAnalista(String analista) {

		if (analista == null) {
			this.analista = "";
		}else {
			this.analista = analista;
		}
	}
	public String getSistema() {
		return sistema;
	}
	public void setSistema(String sistema) {
		if (sistema == null) {
			this.sistema = "";
		}else {
			this.sistema = sistema;
		}
	}
	public short getEquipe() {
		return equipe;
	}
	public void setEquipe(short equipe) {
		this.equipe = equipe;
	}
	public String getAreaCliente() {
		return areaCliente;
	}
	public void setAreaCliente(String areaCliente) {
		if (areaCliente == null) {
			this.areaCliente = "";
		}else {
			this.areaCliente = areaCliente;
		}

	}

	public String getModificadoEm() {
		return modificadoEm;
	}
	public void setModificadoEm(String modificadoEm) {

		if (modificadoEm == null) {
			this.modificadoEm = "";
		}else {
			this.modificadoEm = modificadoEm;
		}
	}

	public String getDetalhamento() {
		return detalhamento;
	}
	public void setDetalhamento(String detalhamento) {
		if (detalhamento == null) {
			this.detalhamento = "";
		}else {
			this.detalhamento = detalhamento;
		}
		
		this.detalhamento = detalhamento;
	}
	
	@Override
	public String toString() {
		return "Chamados [chamado=" + chamado + ", usuario=" + usuario + ", sumario=" + sumario + ", abertoEm="
				+ abertoEm + ", modificadoEm=" + modificadoEm + ", estado=" + estado + ", analista=" + analista
				+ ", sistema=" + sistema + ", equipe=" + equipe + ", areaCliente=" + areaCliente + "]";
	}
	
}
