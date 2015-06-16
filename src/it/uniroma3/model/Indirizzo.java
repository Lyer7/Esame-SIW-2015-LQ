package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findAllIndirizzi", query = "SELECT i FROM Indirizzo i")
public class Indirizzo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String via;

    @Column(nullable = false)
    private String citta;

    @Column(nullable = false)
    private String regione;

    @Column(nullable = false)
    private String codicePostale;

    @Column(nullable = false)
    private String stato;
    
    public Indirizzo(){}

    public Indirizzo(String via, String citta, String regione, String codicePostale, String stato) {
    	this.via = via;
    	this.citta = citta;
    	this.regione = regione;
    	this.codicePostale = codicePostale;
    	this.stato = stato;
    }
    
    /* Getters and Setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getCodicePostale() {
		return codicePostale;
	}

	public void setCodicePostale(String codicePostale) {
		this.codicePostale = codicePostale;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

}
