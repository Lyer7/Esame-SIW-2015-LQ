package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperProdotto;


import it.uniroma3.model.Prodotto;
import it.uniroma3.model.ProdottoFacade;

import javax.servlet.http.HttpServletRequest;

public class CreateProduct implements Action {

	public String perform(HttpServletRequest request) {
		
		HelperProdotto helper = new HelperProdotto();
		
		if (helper.isValid(request)) {
			String nome = request.getParameter("nome");
			String codice = request.getParameter("codice");
			String descrizione = request.getParameter("descrizione");
			Float prezzo = Float.parseFloat(request.getParameter("prezzo"));
			
			ProdottoFacade facade = new ProdottoFacade();
			Prodotto prodotto = facade.createProdotto(nome, codice, descrizione, prezzo);
			request.setAttribute("prodotto", prodotto);
			
			return "/prodotto.jsp";
		} else
			return "/newProdotto.jsp";
	}
}
