package fr.fo.ud.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fo.ud.business.api.IBusinessBranche;
import fr.fo.ud.entity.Branche;

@ManagedBean
@ViewScoped
public class BrancheRechercherManagedBean {

    @Autowired
    private IBusinessBranche buBranche;
    
    private String motCle;
    
    private List<Branche> branches;
    
    @PostConstruct
    public void init() {
        branches = buBranche.getAll();
    }
    
    public void getBranchesByMotCle() {
        if (motCle == null) {
            branches = buBranche.getAll();
        } else {
            branches = buBranche.getByMotCle(motCle);
        }
    }

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String paramMotCle) {
        motCle = paramMotCle;
    }

    public List<Branche> getBranches() {
        return branches;
    }

    public void setBranches(List<Branche> paramBranches) {
        branches = paramBranches;
    }
    
}
