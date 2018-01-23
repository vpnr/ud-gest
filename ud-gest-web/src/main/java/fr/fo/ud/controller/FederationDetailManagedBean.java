package fr.fo.ud.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fo.ud.business.api.IBusinessBranche;
import fr.fo.ud.business.api.IBusinessFederation;
import fr.fo.ud.business.api.IBusinessVille;
import fr.fo.ud.entity.Branche;
import fr.fo.ud.entity.Federation;
import fr.fo.ud.entity.Ville;

@ManagedBean
@ViewScoped
public class FederationDetailManagedBean {

    @Autowired
    private IBusinessFederation buFederation;
    
    @Autowired
    private IBusinessVille buVille;
    
    @Autowired
    private IBusinessBranche buBranche;
    
    private List<Ville> villes;
    
    private Federation federation = new Federation();
    
    private Branche branche = new Branche();

    private List<Branche> branches;
    
    private HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
    @PostConstruct
    public void init(){
        Integer id;
        id = Integer.parseInt(request.getParameter("id"));
        federation = buFederation.getById(id);
        branches = buFederation.getBranchesByFederation(federation);
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
    
    public void updateFederation(){
        buFederation.update(federation);
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

    public List<Branche> getBranches() {
        return branches;
    }

    public void setBranches(List<Branche> paramBranches) {
        branches = paramBranches;
    }

    public Branche getBranche() {
        return branche;
    }

    public void setBranche(Branche paramBranche) {
        branche = paramBranche;
    }

}
