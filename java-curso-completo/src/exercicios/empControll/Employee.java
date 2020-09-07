package exercicios.empControll;

public class Employee {
	
	private Integer id;
	private String nome;
	private Double salario;
	
	
	public Employee() {
	
	}
	
	public Employee(Integer id, String nome, Double salario){
		/**Construtor com todos os atributos
		 * */
		this.salario = salario;
		this.nome = nome;
		this.id = id;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSalario() {
		return salario;
	}
	
	public void AumentoSalario(int pct) {
		this.salario += (this.salario * pct/100);

	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", nome=" + nome + ", salario=" + salario + "]";
	}
	

}
