package it.uniroma3.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "facadeOrdine")
public class FacadeOrdine {
	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;
	
	
	public Ordine creaOrdine(Cliente cliente){
		Ordine ordine = new Ordine(cliente);
		Cliente cl = this.em.find(Cliente.class, cliente.getEmail());
		cl.aggiungiOrdine(ordine);
		this.em.persist(ordine);
		return ordine;
	}
	
	public void aggiungiProdottoAOrdine(Prodotto prodotto, Ordine ordine, Integer qtaProdotto){
		RigaOrdine rigaOrdine = new RigaOrdine(prodotto, ordine, qtaProdotto);
		ordine.aggiungiRigaOrdine(rigaOrdine);
	}
}	