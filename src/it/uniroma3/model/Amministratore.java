package it.uniroma3.model;

import javax.persistence.*;

@Entity
@Table(name="Tabella_Amministratore")
@NamedQuery(name = "findAllAmministratori", query = "SELECT a FROM Amministratore a")
public class Amministratore {
	
	@Column(nullable=false)
	private String id;
	
	@Column(nullable=false)
	private String password;
    
    public Amministratore(){}

	public Amministratore(String id, String password){
		this.id = id;
		this.password = password;
	}
	
	/* Getters and Setters */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
