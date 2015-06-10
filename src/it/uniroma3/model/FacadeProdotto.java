package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless(name= "facadeProdotto")
@NamedQuery(name = "trovaCatalogoProdotti", query = "SELECT p FROM Product p")
public class FacadeProdotto {

    @PersistenceContext(unitName = "unit-proggetto2015")
	private EntityManager em;
    
    
    /**
     * caso d'uso UC4, crea un nuovo prodotto se non presente nel catalogo
     * @param nome
     * @param codice
     * @param descrizione
     * @param prezzo
     * @return prodotto creato, se non presente nel catalogo, null se presente nel catalogo
     */
    public Prodotto creaProdotto(String nome, String codice, String descrizione, Float prezzo){
    	
    	Prodotto prodotto= new Prodotto(nome, codice, descrizione, prezzo);
    	Prodotto temp= this.em.find(Prodotto.class, prodotto.getCodice());
    	if(temp != null){
    		em.persist(prodotto);
        	return prodotto;
    	}
    	return null;
    }
    
    public List<Prodotto> cercaCatalogoProdotti(){
    	List<Prodotto> catalogo = new ArrayList<Prodotto>();
    	TypedQuery<Prodotto> query= this.em.createNamedQuery("trovaCatalogoProdotti", Prodotto.class);
    	catalogo = query.getResultList();
    	return catalogo;
    }
    
    public Prodotto cercaProdotto(Long id){
    	Prodotto prodotto=this.em.find(Prodotto.class, id);
    	return prodotto;
    }
	
}
