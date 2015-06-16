package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import it.uniroma3.model.Ordine;
import it.uniroma3.model.Prodotto;

@Entity
@NamedQuery(name = "findAllRigheOrdine", query = "SELECT r FROM RigaOrdine r")
public class RigaOrdine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Float prezzoUnitario;

    @Column(nullable = false)
    private Integer qtaOrdinata;

    @ManyToOne
    private Ordine ordine;

    @OneToOne
    private Prodotto prodotto;
    
    public RigaOrdine(){}

    public RigaOrdine(Prodotto prodotto, Ordine ordine, int qta){
    	this.prodotto=prodotto;
    	this.qtaOrdinata=qta;
    	this.ordine=ordine;
    	this.prezzoUnitario=prodotto.getPrezzo();
    }
    
    /* Getters and Setters */
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(Float prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

	public Integer getQtaOrdinata() {
		return qtaOrdinata;
	}

	public void setQtaOrdinata(Integer qtaOrdinata) {
		this.qtaOrdinata = qtaOrdinata;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
}
    