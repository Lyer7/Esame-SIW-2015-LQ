package it.uniroma3.controller;

import java.util.List;

import it.uniroma3.model.Cliente;
import it.uniroma3.model.FacadeOrdine;
import it.uniroma3.model.Ordine;
import it.uniroma3.model.Prodotto;
import it.uniroma3.model.RigaOrdine;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "controllerOrdine", eager=true)
public class ControllerOrdine {

	@EJB
	private FacadeOrdine facadeOrdine;
	
	@ManagedProperty(value="#{controllerCliente}")
	private ControllerCliente controllerCliente;
	
	@ManagedProperty(value="#{controllerProdotto}")
	private ControllerProdotto controllerProdotto;
	
	private Cliente cliente;
	private Ordine ordine;
	private Integer qta;
	private List<RigaOrdine> righeOrdine;
	private List<Ordine> tuttiOrdini;
	
	public String creaOrdine() {
		this.ordine=this.facadeOrdine.creaOrdine(controllerCliente.getCliente());
		return controllerProdotto.listaProdotti();
	}
	
	public String cercaOrdine(String id){
		this.ordine = this.facadeOrdine.cercaOrdine(Long.parseLong(id));
		return this.getCarrello();
	}
	
	public String cercaClienteOrdine(String id){
		this.ordine = this.facadeOrdine.cercaOrdine(Long.parseLong(id));
		this.cliente = this.ordine.getCliente();
		return "success";
	}
	
	public String aggiungiProdotto(){
		Prodotto prodotto = this.controllerProdotto.getProdotto();
		this.facadeOrdine.aggiungiProdottoAOrdine(prodotto, ordine, qta);
		return this.getCarrello();
	}
	
	public String listaTuttiOrdini(){
		this.tuttiOrdini = this.facadeOrdine.tuttiOrdini();
		return "success";
	}
	
	public String ordiniCliente(){
		this.cliente = this.controllerCliente.getCliente();
		this.tuttiOrdini = this.facadeOrdine.ordiniCliente(this.cliente.getEmail());
		return "success";
	}
	
	public String evadiOrdine(){
		this.facadeOrdine.evadiOrdine(this.ordine.getId());
		return "success";
	}
	
	public String annullaOrdine(){
		this.facadeOrdine.rimuoviOrdine(this.ordine.getId());
		return "success";
	}
	
	public String chiudiOrdine(){
		this.facadeOrdine.chiudiOrdine(this.ordine.getId());
		return "success";
	}
	
	public ControllerCliente getControllerCliente() {
		return controllerCliente;
	}

	public void setControllerCliente(ControllerCliente controllerCliente) {
		this.controllerCliente = controllerCliente;
	}

	public ControllerProdotto getControllerProdotto() {
		return controllerProdotto;
	}

	public void setControllerProdotto(ControllerProdotto controllerProdotto) {
		this.controllerProdotto = controllerProdotto;
	}
	
	public String getCarrello(){
		this.righeOrdine = this.facadeOrdine.getRigheOrdine(ordine.getId());
		return "success";
	}
	
	/* Getters and Setters */

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public Integer getQta() {
		return qta;
	}

	public FacadeOrdine getFacadeOrdine() {
		return facadeOrdine;
	}

	public void setFacadeOrdine(FacadeOrdine facadeOrdine) {
		this.facadeOrdine = facadeOrdine;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<RigaOrdine> getRigheOrdine() {
		return righeOrdine;
	}

	public void setRigheOrdine(List<RigaOrdine> righeOrdine) {
		this.righeOrdine = righeOrdine;
	}

	public List<Ordine> getTuttiOrdini() {
		return tuttiOrdini;
	}

	public void setTuttiOrdini(List<Ordine> ordini) {
		this.tuttiOrdini = ordini;
	}

	public void setQta(Integer qta) {
		this.qta = qta;
	}

	
}
