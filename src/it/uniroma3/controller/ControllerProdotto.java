package it.uniroma3.controller;

import java.util.List;

import it.uniroma3.model.FacadeProdotto;
import it.uniroma3.model.Prodotto;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "controllerProdotto", eager=true)
public class ControllerProdotto {
	
	@EJB
	private FacadeProdotto facadeProdotto;
	
	private Long id;
	private String nome;
	private String codice;
	private String descrizione;
	private Float prezzo;	
	private Integer qtaMagazzino;
	private Prodotto prodotto;
	private List<Prodotto> catalogoProdotti;
	
	public String creaProdotto() {
		this.prodotto = this.facadeProdotto.creaProdotto(nome, codice, descrizione, prezzo);
		if(this.prodotto==null)
			return "failure";
		return "success";
	}
	
	public String listaProdotti() {
		this.catalogoProdotti = this.facadeProdotto.catalogoProdotti();
		return "success";
	}
	
	public String cercaProdotto(String id) {
		this.prodotto = this.facadeProdotto.cercaProdotto(Long.parseLong(id));
		return "success";
	}
	
	public String aggiungiQtaProdotto(String id) {
		this.facadeProdotto.aggiungiQtaProdotto(Long.parseLong(id), qtaMagazzino);
		return "success";
	}
	
	public String riduciQtaProdotto() {
		this.facadeProdotto.riduciQtaProdotto(prodotto.getId(), qtaMagazzino);
		return this.listaProdotti();
	}
	
	public List<Prodotto> getCatalogoProdotti() {
		return catalogoProdotti;
	}

	public void setCatalogoProdotti(List<Prodotto> catalogoProdotti) {
		this.catalogoProdotti = catalogoProdotti;
	}
	
	/* Getters and Setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getQtaMagazzino() {
		return qtaMagazzino;
	}

	public void setQtaMagazzino(Integer qtaMagazzino) {
		this.qtaMagazzino = qtaMagazzino;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	
}
