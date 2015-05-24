package it.uniroma3.model;

import it.uniroma3.model.Cliente;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ClienteFacade {
	
	private Map<String, Cliente> clienti;

	
	public ClienteFacade()  {
		this.clienti = new HashMap<String, Cliente>();
		Cliente cliente = new Cliente("MR1", "Mario", "Rossi", "m.rossi@gmail.com");
		this.clienti.put(cliente.getNickname(), cliente);
		
		cliente = new Cliente("GV2", "Giuseppe", "Verdi", "g.verdi@gmail.com");
		this.clienti.put(cliente.getNickname(), cliente);
		
		cliente = new Cliente("CB3", "Claudio", "Bruni", "bruni3@hotmail.it");
		this.clienti.put(cliente.getNickname(), cliente);
		
		cliente = new Cliente("LU33", "Luca", "Ecce", "lecce@tiscali.it");
		this.clienti.put(cliente.getNickname(), cliente);
	}

	public Cliente createCliente(String nickname, String nome, String cognome, String email) {
		Cliente cliente = new Cliente(nickname, nome, cognome, email);
		this.clienti.put(clienti.get(nickname).getNickname(), cliente);
		//TO COMPLETE should call a JPA persist method
		return cliente;
	}
	
	public Cliente getCliente(String nickname) {

		return clienti.get(nickname);
	}
	
	public List<Cliente> getAllClienti() {
	
		return new LinkedList<Cliente>(clienti.values());
	}

	public void updateCliente(Cliente cliente) {
		
		clienti.put(cliente.getNickname(), cliente);
	}

	public void deleteCliente(String nickname) {
		
		clienti.remove(nickname);
	}


}
