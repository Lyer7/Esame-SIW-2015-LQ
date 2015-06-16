package it.uniroma3.model;

import javax.persistence.*;

import java.util.*;

@Entity
@NamedQuery(name = "findAllClienti", query = "SELECT c FROM Cliente c")
public class Cliente {

	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String nome;

	@Column(nullable=false)
	private String cognome;

	@Id
	@Column(nullable=false)
	private String email;

	@Temporal(TemporalType.DATE)
	private GregorianCalendar dataDiNascita;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDiRegistrazione;
	
	@Column(nullable=false)
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private Indirizzo indirizzo;
	
	@Column(nullable=false)
	private String password;
	
	@OneToMany(mappedBy="cliente", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Ordine> ordini;

	public Cliente(String nome, String cognome,Indirizzo indirizzo, GregorianCalendar dataDiNascita, String email, String password){
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.email = email;
		this.password = password;
		this.dataDiNascita= dataDiNascita;
		this.dataDiRegistrazione = new Date();
		this.ordini = new ArrayList<Ordine>();
	}

	public Long getId() {
		return id;
	}

	public Indirizzo getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public GregorianCalendar getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(GregorianCalendar dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Date getDataDiRegistrazione() {
		return dataDiRegistrazione;
	}

	public void setDataDiRegistrazione(Date dataDiRegistrazione) {
		this.dataDiRegistrazione = dataDiRegistrazione;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public void aggiungiOrdine(Ordine ordine) {
		this.ordini.add(ordine);
	}
	
	public boolean verificaCredenziali(String password){
		return this.password.equals(password);
	}
	
	public void rimuoviOrdine(Ordine ordine){
		this.ordini.remove(ordine);
	}
	
	public List<Ordine> getOrdini(){
		return this.ordini;
	}
}

