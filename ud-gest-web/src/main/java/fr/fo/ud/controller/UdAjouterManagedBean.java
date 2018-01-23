package fr.fo.ud.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fo.ud.business.api.IBusinessUd;
import fr.fo.ud.business.api.IBusinessVille;
import fr.fo.ud.entity.UnionDepartemental;
import fr.fo.ud.entity.Ville;

@ManagedBean
@ViewScoped
public class UdAjouterManagedBean {

    @Autowired
    private IBusinessVille buVille;
    
    @Autowired
    private IBusinessUd buUd;
    
    private List<Ville> villes;
    
    private UnionDepartemental ud;
    
    private String motCle;
    
    private ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
    
    @PostConstruct
    public void init() {
        villes = buVille.getAll();
        ud = new UnionDepartemental();
        ud.setVille(new Ville());
    }
    
    public void getVillesByCp() {
        if (ud.getVille().getCp() == null) {
            villes = buVille.getAll();
            ud.getVille().setLibelle("");
        }
        else {
            villes = buVille.getByCodePostal(ud.getVille().getCp());
        }
    }
    
    public void getCpByVille() {
        ud.setVille(buVille.getById(ud.getVille().getId()));
    }
    
    public void addUd() {
        buUd.add(ud);
        try {
            context.redirect("accueil.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public IBusinessVille getBuVille() {
        return buVille;
    }

    public void setBuVille(IBusinessVille paramBuVille) {
        buVille = paramBuVille;
    }

    public IBusinessUd getBuUd() {
        return buUd;
    }

    public void setBuUd(IBusinessUd paramBuUd) {
        buUd = paramBuUd;
    }

    public List<Ville> getVilles() {
        return villes;
    }

    public void setVilles(List<Ville> paramVilles) {
        villes = paramVilles;
    }

    public UnionDepartemental getUd() {
        return ud;
    }

    public void setUd(UnionDepartemental paramUd) {
        ud = paramUd;
    }

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String paramMotCle) {
        motCle = paramMotCle;
    }
    
}
