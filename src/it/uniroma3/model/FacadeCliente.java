package it.uniroma3.model;

import java.util.GregorianCalendar;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "facadeCliente")
public class FacadeCliente {

	@PersistenceContext(unitName = "unit-progetto")
	private EntityManager em;
	
	public FacadeCliente(){}
	
	public Cliente creaCliente(String nome, String cognome, Indirizzo indirizzo, GregorianCalendar dataDiNascita, String email, String password){
		Cliente cliente = new Cliente(nome, cognome, indirizzo, dataDiNascita, email, password);
		this.em.persist(cliente);
		return cliente;
	}
	
	public boolean autenticaAutente(String email, String password){
		Cliente cliente =  this.em.find(Cliente.class, email);
		return cliente.verificaCredenziali(password);
	}
	
	public Cliente cercaCliente(String email){
		return this.em.find(Cliente.class, email);
	}
}