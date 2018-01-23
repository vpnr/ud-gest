package fr.fo.ud.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fo.ud.business.api.IBusinessSyndicat;
import fr.fo.ud.business.api.IBusinessVille;
import fr.fo.ud.entity.Syndicat;
import fr.fo.ud.entity.Ville;

@ManagedBean
@ViewScoped
public class SyndicatDetailManagedBean {

    private HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
    @Autowired
    private IBusinessSyndicat buSyndicat;
    
    @Autowired
    private IBusinessVille buVille;
    
    private List<Ville> villes;
    
    private Syndicat syndicat = new Syndicat();
    
    @PostConstruct
    public void init() {
        Integer id;
        id = Integer.parseInt(request.getParameter("id"));
        syndicat = buSyndicat.getById(id);
        villes = buVille.getAll();
    }
    
    public void getVillesByCP(){
        if (syndicat.getVille().getCp() == null) {
            villes = buVille.getAll();
        }
        else {
            villes = buVille.getByCodePostal(syndicat.getVille().getCp());
        }
    }
    
   public void getCpByVille() {
       syndicat.setVille(buVille.getById(syndicat.getVille().getId()));
    }
   
   public void updateSyndicat() {
       buSyndicat.update(syndicat);
   }

    public List<Ville> getVilles() {
        return villes;
    }

    public void setVilles(List<Ville> paramVilles) {
        villes = paramVilles;
    }

    public Syndicat getSyndicat() {
        return syndicat;
    }

    public void setSyndicat(Syndicat paramSyndicat) {
        syndicat = paramSyndicat;
    }
    
}
