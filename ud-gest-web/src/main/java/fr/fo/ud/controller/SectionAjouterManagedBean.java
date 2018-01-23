package fr.fo.ud.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fo.ud.business.api.IBusinessSection;
import fr.fo.ud.business.api.IBusinessSyndicat;
import fr.fo.ud.business.api.IBusinessVille;
import fr.fo.ud.entity.Section;
import fr.fo.ud.entity.Syndicat;
import fr.fo.ud.entity.Ville;

@ManagedBean
@ViewScoped
public class SectionAjouterManagedBean {

    @Autowired
    private IBusinessSection buSection;
    
    @Autowired
    private IBusinessVille buVille;
    
    @Autowired
    private IBusinessSyndicat buSyndicat;
    
    private ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
    
    private Section section;
    
    private List<Ville> villes;

    private List<Syndicat> syndicats;
    
    @PostConstruct
    public void init() {
        section = new Section();
        section.setVille(new Ville());
        section.setSyndicat(new Syndicat());
        villes = buVille.getAll();
        syndicats = buSyndicat.getAll();
    }

    public void getVillesByCP(){
        if (section.getVille().getCp() == null) {
            villes = buVille.getAll();
        }
        else {
            villes = buVille.getByCodePostal(section.getVille().getCp());
        }
    }
    
     public void getCpByVille() {
         section.setVille(buVille.getById(section.getVille().getId()));
     }
     
    public void addSection(){
        buSection.add(section);
        try {
            context.redirect("sectionRechercher.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Section getSection() {
        return section;
    }

    public void setSection(Section paramSection) {
        section = paramSection;
    }

    public List<Ville> getVilles() {
        return villes;
    }

    public void setVilles(List<Ville> paramVilles) {
        villes = paramVilles;
    }

    public List<Syndicat> getSyndicats() {
        return syndicats;
    }

    public void setSyndicats(List<Syndicat> paramSyndicats) {
        syndicats = paramSyndicats;
    }
    
}
