package it.uniroma3.controller;

import it.uniroma3.model.FacadeOrdine;
import it.uniroma3.model.Ordine;
import it.uniroma3.model.Prodotto;

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
	private Long id;
	private Ordine ordine;
	private Integer qta;
	
	public String creaOrdine() {
		this.ordine=this.facadeOrdine.creaOrdine(controllerCliente.getCliente());
		return controllerProdotto.listinoProdotti();
	}

	public String aggiungiProdotto(){
		Prodotto p = this.controllerProdotto.getProdotto();
		this.facadeOrdine.aggiungiProdottoAOrdine(p, ordine, qta);
		return controllerProdotto.riduciQtaProdotto();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public Integer getQta() {
		return qta;
	}

	public void setQta(Integer qta) {
		this.qta = qta;
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
	
}
