package fr.fo.ud.business.impl;

import java.util.List;

import fr.fo.ud.business.api.IBusinessFederation;
import fr.fo.ud.business.api.IBusinessFonction;
import fr.fo.ud.data.api.IDaoFonction;
import fr.fo.ud.entity.Mandat;

public class BusinessFonction implements IBusinessFonction{

    private IDaoFonction daoFonction;
    
    public Mandat add(Mandat paramFonction) {
        return daoFonction.add(paramFonction);
    }

    public Mandat update(Mandat paramFonction) {
        return daoFonction.update(paramFonction);
    }

    public Mandat delete(Mandat paramFonction) {
        return daoFonction.delete(paramFonction);
    }

    public List<Mandat> getAll() {
        return daoFonction.getAll();
    }

    public List<Mandat> getByMotCle(String paramMotCle) {
        return daoFonction.getByMotCle(paramMotCle);
    }

    public Mandat getById(Integer paramId) {
        return daoFonction.getById(paramId);
    }

}
