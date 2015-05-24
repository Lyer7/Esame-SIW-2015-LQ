package it.uniroma3.controller.helper;

import javax.servlet.http.HttpServletRequest;

public class HelperProdotto {

	public boolean isValid(HttpServletRequest request) {
		
		String nome = request.getParameter("nome");
		String codice = request.getParameter("codice");
		String prezzo = request.getParameter("prezzo");
		boolean errors = false;

		if ( nome == null || nome.equals("")) {
			request.setAttribute("nomeErr","Campo Obbligatorio");
			errors = true;
		}

		if ( codice == null || codice.equals("")) {
			request.setAttribute("codiceErr","Campo Obbligatorio");
			errors = true;
		}

		if ( prezzo == null || prezzo.equals("")) {
			request.setAttribute("prezzoErr","Campo Obbligatorio");
			errors = true;
		}
		else {
			try{
				Float.parseFloat(prezzo);
			}
			catch (NumberFormatException e) {
				request.setAttribute("prezzoErr","Il Prezzo deve essere un Numero");
				errors = true;
			}
		}
		return !errors;
	}
}
