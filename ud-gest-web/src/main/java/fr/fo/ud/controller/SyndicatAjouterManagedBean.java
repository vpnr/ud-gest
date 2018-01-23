package fr.fo.ud.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fo.ud.business.api.IBusinessBranche;
import fr.fo.ud.business.api.IBusinessFederation;
import fr.fo.ud.business.api.IBusinessSyndicat;
import fr.fo.ud.business.api.IBusinessUd;
import fr.fo.ud.business.api.IBusinessVille;
import fr.fo.ud.entity.Branche;
import fr.fo.ud.entity.Federation;
import fr.fo.ud.entity.Syndicat;
import fr.fo.ud.entity.UnionDepartemental;
import fr.fo.ud.entity.Ville;

@ManagedBean
@ViewScoped
public class SyndicatAjouterManagedBean {

    @Autowired
    private IBusinessSyndicat buSyndicat;
	
    @Autowired
    private IBusinessVille buVille;
    
    @Autowired
    private IBusinessFederation buFederation;
    
    @Autowired
    private IBusinessBranche buBranche;
    
    @Autowired
    private IBusinessUd buUd;
    
    private Syndicat syndicat;
    
    private List<Federation> federations;
    
    private List<Ville> villes;
    
    private List<UnionDepartemental> uds;
    
    private List<Branche> branches;
    
    @PostConstruct
    public void init() {
        syndicat = new Syndicat();
        syndicat.setVille(new Ville());
        syndicat.setBranche(new Branche());
        syndicat.setUd(new UnionDepartemental());
        syndicat.setFederation(new Federation());
        villes = buVille.getAll();
        uds = buUd.getAll();
        federations = buFederation.getAll();
        branches = buBranche.getAll();
    }

    public Syndicat getSyndicat() {
        return syndicat;
    }

    public void setSyndicat(Syndicat paramSyndicat) {
        syndicat = paramSyndicat;
    }

    public List<Federation> getFederations() {
        return federations;
    }

    public void setFederations(List<Federation> paramFederations) {
        federations = paramFederations;
    }

    public List<Ville> getVilles() {
        return villes;
    }

    public void setVilles(List<Ville> paramVilles) {
        villes = paramVilles;
    }

    public List<UnionDepartemental> getUds() {
        return uds;
    }

    public void setUds(List<UnionDepartemental> paramUds) {
        uds = paramUds;
    }

    public List<Branche> getBranches() {
        return branches;
    }

    public void setBranches(List<Branche> paramBranches) {
        branches = paramBranches;
    }
    
}
