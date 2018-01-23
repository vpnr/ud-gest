package fr.fo.ud.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fo.ud.business.api.IBusinessBranche;
import fr.fo.ud.business.api.IBusinessFederation;
import fr.fo.ud.entity.Branche;
import fr.fo.ud.entity.Federation;

@ManagedBean
@ViewScoped
public class BrancheAjouterManagedBean {

    @Autowired
    private IBusinessBranche buBranche;
    
    @Autowired
    private IBusinessFederation buFederation;
    
    private ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
    
    private Branche branche;
    
    private List<Federation> federations;
    
    @PostConstruct
    public void init() {
        branche = new Branche();
        branche.setFederation(new Federation());
        federations = buFederation.getAll();
    }

    public void addBranche(){
        buBranche.add(branche);
        try {
            context.redirect("brancheRechercher.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<Federation> getFederations() {
        return federations;
    }

    public void setFederations(List<Federation> paramFederations) {
        federations = paramFederations;
    }

    public Branche getBranche() {
        return branche;
    }

    public void setBranche(Branche paramBranche) {
        branche = paramBranche;
    }
    
}
