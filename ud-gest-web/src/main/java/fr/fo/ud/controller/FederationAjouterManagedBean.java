package fr.fo.ud.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fo.ud.business.api.IBusinessFederation;
import fr.fo.ud.business.api.IBusinessVille;
import fr.fo.ud.entity.Federation;
import fr.fo.ud.entity.Ville;

@ManagedBean
@ViewScoped
public class FederationAjouterManagedBean {

    @Autowired
    private IBusinessFederation buFederation;
    
    @Autowired
    private IBusinessVille buVille;
    
    private List<Ville> villes;
    
    private Federation federation = new Federation();
    
    private ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
    
    @PostConstruct
    public void init() {
        federation.setVille(new Ville());
        villes = buVille.getAll();
    }
    
    public void getVillesByCP(){
        if (federation.getVille().getCp() == null) {
            villes = buVille.getAll();
        }
        else {
            villes = buVille.getByCodePostal(federation.getVille().getCp());
        }
    }
    
     public void getCpByVille() {
         federation.setVille(buVille.getById(federation.getVille().getId()));
     }
     
    public void addFederation(){
        buFederation.add(federation);
        try {
            context.redirect("federationRechercher.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Ville> getVilles() {
        return villes;
    }

    public void setVilles(List<Ville> paramVilles) {
        villes = paramVilles;
    }

    public Federation getFederation() {
        return federation;
    }

    public void setFederation(Federation paramFederation) {
        federation = paramFederation;
    }
    
}
