package fr.fo.ud.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fo.ud.business.api.IBusinessAdherent;
import fr.fo.ud.business.api.IBusinessEntreprise;
import fr.fo.ud.business.api.IBusinessFonction;
import fr.fo.ud.business.api.IBusinessFormation;
import fr.fo.ud.business.api.IBusinessSyndicat;
import fr.fo.ud.business.api.IBusinessVille;
import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Entreprise;
import fr.fo.ud.entity.Fonction;
import fr.fo.ud.entity.Formation;
import fr.fo.ud.entity.Syndicat;
import fr.fo.ud.entity.Ville;

@ManagedBean
@SessionScoped
public class AdherentAjouterManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IBusinessSyndicat buSyndicat;
	
	@Autowired
	private IBusinessFonction buFonction;
	
	@Autowired
	private IBusinessFormation buFormation;
	
	@Autowired
	private IBusinessAdherent buAdh;
	
	@Autowired
	private IBusinessVille buVille;
	
	@Autowired
	private IBusinessEntreprise buEntreprise;
	
	private String motCle;
	
	private String libelleVille;
	
	private String cpVille;
	
	private Adherent adherent;
	
	private Entreprise entreprise;
	
	private Ville ville;
	
	private List<Ville> villes;
	
	private List<Fonction> fonctions;
	
	private List<Fonction> selectedFonctions;
	
	private List<String> selectedFonctionsLibelle;
	
	private List<Entreprise> entreprises;
	
	private List<Syndicat> syndicats;
	
	private List<Formation> formations;
	

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent paramAdherent) {
		adherent = paramAdherent;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> paramVilles) {
		villes = paramVilles;
	}

	public void setVille(Ville paramVille) {
		ville = paramVille;
	}

	public Ville getVille() {
		return ville;
	}
	
	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String paramMotCle) {
		motCle = paramMotCle;
	}

	@PostConstruct
	public void onLoad(){
		
	    adherent = new Adherent();
	    entreprise = new Entreprise();
	    fonctions = buFonction.getAll();
	    entreprises = buEntreprise.getAll();
	    syndicats = buSyndicat.getAll();
	    
		adherent.setVille(ville);
		adherent.setEntreprise(entreprise);
		villes = buVille.getAll();
		
		adherent.setNom("toto");
		adherent.setPrenom("toto");
		adherent.setDob(new Date());
		adherent.setNumeroRue("toto");
		adherent.setLibelleRue("toto");
		adherent.setTel("toto");
		adherent.setMail("toto");
		adherent.setNom("toto");
		adherent.setVille(buVille.getById(1));
		adherent.setEntreprise(buEntreprise.getById(1));
		
		
	}
	
	public void addSelectedFonction(){
	    System.out.println("toutes les fonctions :" + selectedFonctions);
	    System.out.println("toutes les fonctions :" + fonctions);
	}
	
	public void getVilleByMotCle(){
		if (libelleVille == "") {
			villes = buVille.getAll();
		}
		else {
			villes = buVille.getByMotCle(libelleVille);
		}
	}

	public String getLibelleVille() {
		return libelleVille;
	}

	public void setLibelleVille(String paramLibelleVille) {
		libelleVille = paramLibelleVille;
	}

	public String getCpVille() {
		return cpVille;
	}

	public void setCpVille(String paramCpVille) {
		cpVille = paramCpVille;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise paramEntreprise) {
		entreprise = paramEntreprise;
	}

    public List<Fonction> getFonctions() {
        return fonctions;
    }

    public void setFonctions(List<Fonction> paramFonctions) {
        fonctions = paramFonctions;
    }

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> paramFormations) {
        formations = paramFormations;
    }

    public List<Fonction> getSelectedFonctions() {
        return selectedFonctions;
    }

    public void setSelectedFonctions(List<Fonction> paramSelectedFonctions) {
        selectedFonctions = paramSelectedFonctions;
    }

    public List<Entreprise> getEntreprises() {
        return entreprises;
    }

    public void setEntreprises(List<Entreprise> paramEntreprises) {
        entreprises = paramEntreprises;
    }

    public List<Syndicat> getSyndicats() {
        return syndicats;
    }

    public void setSyndicats(List<Syndicat> paramSyndicats) {
        syndicats = paramSyndicats;
    }

}
