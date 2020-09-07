package banking;

public class Cliente extends Conta {
	private String nome;
	private Conta conta;
	
	public Cliente(String nome, String idConta) {
		conta = new Conta(idConta);
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Conta getConta() {
		return conta;
	}
	
	@Override
	public double getSaldo() {
		return super.getSaldo();
	}
	
	
	@Override
	public String toString() {
		return this.nome + "\nconta: " + conta.getNumeroConta() + "\nsaldo inicial: " + getSaldo();
	}

}
