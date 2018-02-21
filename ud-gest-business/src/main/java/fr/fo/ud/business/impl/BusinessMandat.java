package fr.fo.ud.business.impl;

import java.util.List;

import fr.fo.ud.business.api.IBusinessMandat;
import fr.fo.ud.data.api.IDaoMandat;
import fr.fo.ud.entity.Mandat;

public class BusinessMandat implements IBusinessMandat{

    private IDaoMandat daoMandat;
    
    public Mandat add(Mandat mandat) {
        return daoMandat.add(mandat);
    }

    public Mandat update(Mandat mandat) {
        return daoMandat.update(mandat);
    }

    public Mandat delete(Mandat mandat) {
        return daoMandat.delete(mandat);
    }

    public List<Mandat> getAll() {
        return daoMandat.findAll();
    }

    public List<Mandat> getByMotCle(String paramMotCle) {
        return daoMandat.findByMotCle(paramMotCle);
    }

    public Mandat getById(Integer paramId) {
        return daoMandat.findById(paramId);
    }

}
