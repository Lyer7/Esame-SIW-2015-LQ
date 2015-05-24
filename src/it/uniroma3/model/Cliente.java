package it.uniroma3.model;

import javax.persistence.*;

import java.util.*;

@Entity
@Table(name="Tabella_Cliente")
@NamedQuery(name = "findAllClienti", query = "SELECT c FROM Cliente c")
public class Cliente {
	
	@Column(nullable=false)
	private String nickname;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String cognome;
	
	@Column(nullable=false)
	private String email;
	
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataDiNascita;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDiRegistrazione;
    
    public Cliente(){}

	public Cliente(String nickname, String nome, String cognome, String email){
		this.nickname = nickname;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}
	
	/* Getters and Setters */

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Date getDataDiRegistrazione() {
		return dataDiRegistrazione;
	}

	public void setDataDiRegistrazione(Date dataDiRegistrazione) {
		this.dataDiRegistrazione = dataDiRegistrazione;
	}
	

}
