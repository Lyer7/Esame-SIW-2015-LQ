package it.uniroma3.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProdottoFacade {
	
	private Map<Long, Prodotto> prodotti;
	
	public ProdottoFacade()  {
		this.prodotti = new HashMap<Long, Prodotto>();
		Prodotto prodotto = new Prodotto("Yamaha F310P", "a beginner acoustic guitar pack.", "YMHF310P",  new Float(119.9));
		prodotto.setId(new Long(1));
		this.prodotti.put(prodotto.getId(), prodotto);
		
		prodotto = new Prodotto("Asus N55", "asus notebook", "CN200H",  new Float(890.0));
		prodotto.setId(new Long(2));
		this.prodotti.put(prodotto.getId(), prodotto);

		prodotto = new Prodotto("Mortal Kombat X PS4", "NetherRealm last fighting game", "BLES-0009307", new Float(59.9));
		prodotto.setId(new Long(3));
		this.prodotti.put(prodotto.getId(), prodotto);
	}

	public Prodotto createProdotto(String nome, String codice, String descrizione, Float prezzo) {
		
		Prodotto prodotto = new Prodotto(nome, codice, descrizione, prezzo);
		this.prodotti.put(new Long(prodotti.size()), prodotto);
		//TO COMPLETE should call a JPA persist method
		return prodotto;
	}
	
	public Prodotto getProdotto(Long id) {
		
		return prodotti.get(id);
	}
	
	public List<Prodotto> getAllProdotti() {
	
		return new LinkedList<Prodotto>(prodotti.values());
	}

	public void updateProdotto(Prodotto prodotto) {
	
		prodotti.put(prodotto.getId(), prodotto);
	}

	public void deleteProdotto(Long id) {

		prodotti.remove(id);
	}


}
