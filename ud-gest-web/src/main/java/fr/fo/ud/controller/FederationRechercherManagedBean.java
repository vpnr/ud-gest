package fr.fo.ud.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fo.ud.business.api.IBusinessFederation;
import fr.fo.ud.entity.Federation;

@ManagedBean
@ViewScoped
public class FederationRechercherManagedBean {
    
    @Autowired
    private IBusinessFederation bufederation;
    
    private String motCle;
    
    private List<Federation> federations;
    
    @PostConstruct
    public void init() {
        federations = bufederation.getAll();
    }
    
    public void getFederationByMotCle() {
        if (motCle.isEmpty()) {
            federations = bufederation.getAll();
        } else {
            federations = bufederation.getByMotCle(motCle);
        }
    }

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String paramMotCle) {
        motCle = paramMotCle;
    }

    public List<Federation> getFederations() {
        return federations;
    }

    public void setFederations(List<Federation> paramFederations) {
        federations = paramFederations;
    }

}
