package it.uniroma3.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import it.uniroma3.model.Indirizzo;
import it.uniroma3.model.Prodotto;


@Entity
@NamedQuery(name = "findAllFornitori", query = "SELECT f FROM Fornitori f")
public class Fornitore {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
	private String partitaIva;
    
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private Indirizzo indirizzo;
    
    @Column(nullable = false)
	private String telefono;
    
    @Column(nullable = false)
	private String email;
	
    @ManyToMany
	private List<Prodotto> prodotti;
    
    public Fornitore() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public List<Prodotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}

}
