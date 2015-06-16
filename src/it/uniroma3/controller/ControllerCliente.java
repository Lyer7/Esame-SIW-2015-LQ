package it.uniroma3.controller;

import it.uniroma3.model.Cliente;
import it.uniroma3.model.FacadeCliente;
import it.uniroma3.model.Indirizzo;

import java.util.GregorianCalendar;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "controllerCliente", eager=true)
public class ControllerCliente {

	@EJB
	private FacadeCliente facadeCliente;

	private Cliente cliente;
	private String password;
	
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	
	private GregorianCalendar dataDiNascita;
	private Integer giorno;
	private Integer mese;
	private Integer anno;

	private String via;
	private String citta;
	private String regione;
	private String cap;
	private String stato;
	
	private Indirizzo indirizzo;

	public String creaCliente() {
		this.indirizzo = this.creaIndirizzo(via, citta, regione, cap, stato);
		this.dataDiNascita = new GregorianCalendar(anno,mese-1,giorno);
		this.cliente = this.facadeCliente.creaCliente(nome, cognome, indirizzo, dataDiNascita, email, password);
		if(this.cliente==null)
			return "failure";
		return "success";
	}

	public String autenticaCliente() {
		if(this.facadeCliente.autenticaAutente(email, password)){
			this.cliente=this.facadeCliente.cercaCliente(email);
			return "success";
		}
		return "failure";
	}
	
	public Indirizzo creaIndirizzo(String via, String citta, String regione, String codicePostale, String stato) {
		return new Indirizzo(via, citta, regione, codicePostale, stato);
	}
	
	/* Getters and Setters */

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getEmail() {
		return email;
	}

	public GregorianCalendar getDataDiNascita() {
		return dataDiNascita;
	}
	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public String getPassword() {
		return password;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDataDiNascita(GregorianCalendar dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	
	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Cliente getCliente(){
		return this.cliente;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Integer getGiorno() {
		return giorno;
	}

	public void setGiorno(Integer giorno) {
		this.giorno = giorno;
	}

	public Integer getMese() {
		return mese;
	}

	public void setMese(Integer mese) {
		this.mese = mese;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

}
