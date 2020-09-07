package banking;

public class Conta {

	private String numeroConta;
	private double saldo;
	
	public Conta() {
	}
	
	 public Conta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public String getNumeroConta() {
		return numeroConta;
	}
	
	public void Depositar(double valor) {
		this.saldo = this.saldo + valor;
	}
	
	public void Sacar(double valor) {
		this.saldo = this.saldo - valor - 5;
	}
	
	
}
