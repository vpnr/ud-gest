package fr.fo.ud.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fo.ud.business.api.IBusinessSection;
import fr.fo.ud.entity.Section;

@ManagedBean
@ViewScoped
public class SectionRechercherManagedBean {

    @Autowired
    private IBusinessSection buSection;
    
    private List<Section> sections;
    
    private String motCle;
    
    @PostConstruct
    public void init() {
        sections = buSection.getAll();
    }
    
    public void getSectionsByMotCle() {
        if (motCle == null) {
            sections = buSection.getAll();
        }
        else {
            sections = buSection.getByMotCle(motCle);
        }
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> paramSections) {
        sections = paramSections;
    }

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String paramMotCle) {
        motCle = paramMotCle;
    }
    
}
