package crud.pessoa.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Endereco")
public class Endereco {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 80)
	private String rua;

	@Column(nullable = false, length = 5)
	private int numero;
	
	@Column(nullable = false, length = 30)
	private String bairro;

    @Column(nullable = false, length = 30)
	private String cidade;

    @Column(nullable = false, length = 30)
	private String estado;

    @Column(nullable = false, length = 10) 
	private String cep;

	@JoinColumn
    @Column(nullable = false, length = 5)
	private Long id_pessoa;

	
	public Endereco(){}

	public Endereco(Long id, String rua, int numero, String bairro, String cidade, String estado, String cep, Long id_pessoa){
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.id_pessoa = id_pessoa;
	}

	public Long getId(){
		return this.id;
	}

	public String getRua(){
		return this.rua;
	}

	public void setRua(String rua){
		this.rua = rua;
	}

	public int getNumero(){
		return this.numero;
	}

	public void setNumero(int numero){
		this.numero = numero;
	}

	public String getBairro(){
		return this.bairro;
	}

	public void setBairro(String bairro){
		this.bairro = bairro;
	}

	public String getCidade(){
		return this.cidade;
	}

	public void setCidade(String cidade){
		this.cidade = cidade;
	}

	public String getEstado(){
		return estado;
	}

	public void setEstado(String estado){
		this.estado = estado;
	}

	public String getCep(){
		return cep;
	}

	public void setCep(String cep){
		this.cep = cep;
	}

	public Long getIdPessoa(){
		return id_pessoa;
	}

	
	@Override
    public String toString() {
        return "Endereço { " +
                " ID= " + this.getId() +
				" Rua= " + this.getRua() +
				" Numero= " + this.getNumero() +
				" Bairro= " + this.getBairro() +
				" Cidade= " + this.getCidade() +
				" Estado= " + this.getEstado() +
				" CEP= " + this.getCep() +
				" Residente= " + this.getIdPessoa() +
                '}';
    }

}
