package it.uniroma3.model;


import javax.persistence.*;

import java.util.*;

@Entity
@Table(name="Tabella_Clienti")
@NamedQuery(name = "findAllClienti", query = "SELECT c FROM Cliente c")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataDiNasciata;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDiRegistrazione;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Indirizzo indirizzo;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Ordine> ordini;

    public Cliente() {}

    public Cliente(String nome, String cognome, String email, Date dataDiNascita){
    	this.nome = nome;
    	this.cognome = cognome;
    	this.email = email;
    	this.dataDiNascita = dataDiNascita;
    }

}
