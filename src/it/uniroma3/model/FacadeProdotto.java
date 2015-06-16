package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless(name = "facadeProdotto")
public class FacadeProdotto {
	
	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;
	
	//UC4
	public Prodotto creaProdotto(String nome, String codice, String descrizione, Float prezzo) {
		Prodotto prodotto = new Prodotto(nome,codice,descrizione,prezzo);	
//		Prodotto temp = this.em.find(Prodotto.class, prodotto.getCodice());
//		if(temp != null) {
		this.em.persist(prodotto);
		return prodotto;
//		}
//		return null;
	}
	
	//UC1,UC2
	public List<Prodotto> catalogoProdotti() {
		TypedQuery<Prodotto> query = this.em.createNamedQuery("catalogoProdotti", Prodotto.class);
		return query.getResultList();
	}
	
	public Prodotto cercaProdotto(Long idProdotto) {
		return this.em.find(Prodotto.class, idProdotto);
	}
	
	public void aggiungiQtaProdotto(Long idProdotto, Integer qtaMagazzino) {
		Prodotto prodotto = this.em.find(Prodotto.class, idProdotto);
		prodotto.aggiungiQtaMagazzino(qtaMagazzino);
	}
	
	public void riduciQtaProdotto(Long idProdotto, Integer qtaMagazzino) {
		Prodotto prodotto = this.em.find(Prodotto.class, idProdotto);
		prodotto.riduciQtaMagazzino(qtaMagazzino);
	}
	
}