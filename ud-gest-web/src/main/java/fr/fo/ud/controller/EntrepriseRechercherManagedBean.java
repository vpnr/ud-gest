package fr.fo.ud.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fo.ud.business.api.IBusinessEntreprise;
import fr.fo.ud.entity.Entreprise;

@ManagedBean
@ViewScoped
public class EntrepriseRechercherManagedBean {

	@Autowired
	private IBusinessEntreprise buEntreprise;
	
	private String motCle;
	
	private List<Entreprise> entreprises;
	
	@PostConstruct
	public void init() {
		entreprises = buEntreprise.getAll();
	}
	
	public void getEntrepriseByMotCle() {
		if (motCle.isEmpty()) {
			entreprises = buEntreprise.getAll();
		} else {
			entreprises = buEntreprise.getByMotCle(motCle);
		}
	}

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String paramMotCle) {
		motCle = paramMotCle;
	}

	public List<Entreprise> getEntreprises() {
		return entreprises;
	}

	public void setEntreprises(List<Entreprise> paramEntreprises) {
		entreprises = paramEntreprises;
	}
	
}
