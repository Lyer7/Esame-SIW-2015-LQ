package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperProdottoId;

import it.uniroma3.model.Prodotto;
import it.uniroma3.model.ProdottoFacade;

import javax.servlet.http.HttpServletRequest;

public class GetProduct implements Action {

	public String perform(HttpServletRequest request) {
		
		HelperProdottoId helper = new HelperProdottoId();
		
		if (helper.isValid(request)) {
			Long id = Long.parseLong(request.getParameter("id"));
			
			ProdottoFacade facade = new ProdottoFacade();
			Prodotto prodotto = facade.getProdotto(id);
			request.setAttribute("prodotto", prodotto);
			
			return "/prodotto.jsp";
		} else
			return "/invalid.jsp";
	}
}
