package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	
	public List<Ordine> ordiniCliente(String email){
		TypedQuery<Ordine> query = this.em.createNamedQuery("tuttiOrdini", Ordine.class );
		for(Ordine ordine: query.getResultList()){
			if(ordine.getDataChiusura()==null){
				Cliente cliente = ordine.getCliente();
				cliente.rimuoviOrdine(ordine);
				this.em.remove(ordine);
			}
		}
		
		return this.em.find(Cliente.class, email).getOrdini();
	}
	
	public List<Ordine> tuttiOrdini(){
		TypedQuery<Ordine> query = this.em.createNamedQuery("tuttiOrdini", Ordine.class);
		return query.getResultList();
	}
	
	public List<RigaOrdine> getRigheOrdine(Long id){
		Ordine ordine = this.em.find(Ordine.class, id);
		return ordine.getRigheOrdine();
	}
	
	public Ordine cercaOrdine(Long id){
		return this.em.find(Ordine.class, id);
	}
	
	public void evadiOrdine(Long id){
		Ordine ordine = this.em.find(Ordine.class, id);
		ordine.setDataEvasione();
		for(RigaOrdine ro: 	ordine.getRigheOrdine()){
			ro.getProdotto().riduciQtaMagazzino(ro.getQtaOrdinata());
		}	
	}
	
	public void rimuoviOrdine(Long id){
		Ordine ordine = this.em.find(Ordine.class, id);
		this.em.remove(ordine);
	}
	
	public void chiudiOrdine(Long id){
		Ordine ordine = this.em.find(Ordine.class, id);
		ordine.setDataChiusura();
	}

}	