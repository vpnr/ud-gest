package fr.fo.ud.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fo.ud.business.api.IBusinessEntreprise;
import fr.fo.ud.business.api.IBusinessVille;
import fr.fo.ud.entity.Entreprise;
import fr.fo.ud.entity.Ville;

@ManagedBean
@ViewScoped
public class EntrepriseAjouterManagedBean {

	private List<Ville> villes;
	
	private Entreprise entreprise = new Entreprise();
	
	@Autowired
	private IBusinessEntreprise buEntreprise;
	
	@Autowired
	private IBusinessVille buVille;

	@PostConstruct
	public void init(){
		entreprise.setVille(new Ville());
		villes = buVille.getAll();
	}
	
	public void getVillesByCP(){
		if (entreprise.getVille().getCp() == null) {
			villes = buVille.getAll();
		}
		else {
			villes = buVille.getByCodePostal(entreprise.getVille().getCp());
		}
	}
	
	 public void getCpByVille() {
	     entreprise.setVille(buVille.getById(entreprise.getVille().getId()));
	 }
	 
	public void addEntreprise(){
		buEntreprise.add(entreprise);
	}
	
	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise paramEntreprise) {
		entreprise = paramEntreprise;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> paramVilles) {
		villes = paramVilles;
	}	
	
}
