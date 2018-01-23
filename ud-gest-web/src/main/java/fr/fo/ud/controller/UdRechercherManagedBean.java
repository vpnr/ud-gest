package fr.fo.ud.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fo.ud.business.api.IBusinessUd;
import fr.fo.ud.entity.UnionDepartemental;

@ManagedBean
@ViewScoped
public class UdRechercherManagedBean {

    @Autowired
    private IBusinessUd buUd;
    
    private String motCle;
    
    private List<UnionDepartemental> uds;
    
    @PostConstruct
    public void init() {
        uds = buUd.getAll();
    }
    
    public void getUdsByMotCle() {
        if (motCle == null) {
            uds = buUd.getAll();
        }
        else {
            uds = buUd.getByMotCle(motCle);
        }
    }

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String paramMotCle) {
        motCle = paramMotCle;
    }

    public List<UnionDepartemental> getUds() {
        return uds;
    }

    public void setUds(List<UnionDepartemental> paramUds) {
        uds = paramUds;
    }
    
}
