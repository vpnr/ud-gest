package fr.fo.ud.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fo.ud.business.api.IBusinessUd;
import fr.fo.ud.business.api.IBusinessVille;
import fr.fo.ud.entity.UnionDepartemental;
import fr.fo.ud.entity.Ville;

@ManagedBean
@ViewScoped
public class UdDetailManagedBean {

    @Autowired
    private IBusinessUd buUd;
    
    @Autowired
    private IBusinessVille buVille;
    
    private HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
    private UnionDepartemental ud = new UnionDepartemental();
    
    private List<Ville> villes;
    
    @PostConstruct
    public void init() {
        Integer id;
        id = Integer.parseInt(request.getParameter("id"));
        ud = buUd.getById(id);
        villes = buVille.getAll();
    }
    
    public void getVillesByCP(){
        if (ud.getVille().getCp() == null) {
            villes = buVille.getAll();
        }
        else {
            villes = buVille.getByCodePostal(ud.getVille().getCp());
        }
    }

    public void updateUd() {
        buUd.update(ud);
    }
    
    public void getCpByVille() {
        ud.setVille(buVille.getById(ud.getVille().getId()));
    }
    
    public UnionDepartemental getUd() {
        return ud;
    }

    public void setUd(UnionDepartemental paramUd) {
        ud = paramUd;
    }

    public List<Ville> getVilles() {
        return villes;
    }

    public void setVilles(List<Ville> paramVilles) {
        villes = paramVilles;
    }
    
}
