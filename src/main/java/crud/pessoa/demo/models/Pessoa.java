package crud.pessoa.demo.models;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Pessoa")
public class Pessoa {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 80)
	private String nome;

	@Column(nullable = true, length = 11)
	private String nascimento;
	
	@Column(nullable = false, length = 15, unique = true)
	private String cpf;

	@OneToMany(cascade = CascadeType.REMOVE)
	private List<Endereco> enderecos;

	@Transient //Anotação usada para garantir que esse atributo não seja salvo no banco
	private LocalDate anoAtual = LocalDate.now();

	@Transient
	private int idade;

	public Pessoa(){};

	public Pessoa(Long id,String nome, String nascimento, String cpf, List<Endereco> enderecos){
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.cpf = cpf;
	}

	public long getId(){
		return this.id;
	}

	public String getNome(){
		return this.nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public String getNascimento(){
		return this.nascimento;
	}

	public void setNascimento(String nascimento){
		this.nascimento = nascimento;
	}

	public String getCpf(){
		return this.cpf;
	}

	public void setCpf(String cpf){
		this.cpf = cpf;
	}

	public LocalDate getAnoAtual(){
		return this.anoAtual;
	}

	public int getIdade(){
		return this.idade;
	}

	public void setIdade(int idade){
		this.idade = idade;
	}

	public void calculaIdade(){

	}

	@Override
    public String toString() {
        return "Pessoa { " +
                " ID= " + this.getId() +
				" Nome= " + this.getNome() +
				" Nascimento= " + this.getNascimento() +
				" CPF= " + this.getCpf() +
				" Idade= " + this.getIdade() +
                '}';
    }

}
