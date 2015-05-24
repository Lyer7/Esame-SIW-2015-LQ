package it.uniroma3.controller.action;

import it.uniroma3.model.Prodotto;

import java.util.List;

import it.uniroma3.model.ProdottoFacade;

import javax.servlet.http.HttpServletRequest;

//controller/prodotti.list
public class ListProdotto implements Action {

	public String perform(HttpServletRequest request) {
		
		ProdottoFacade facade = new ProdottoFacade();
		List<Prodotto> prodotti = facade.getAllProdotti();
		request.setAttribute("prodotti", prodotti);	
		return "/prodotti.jsp";
	}
}
