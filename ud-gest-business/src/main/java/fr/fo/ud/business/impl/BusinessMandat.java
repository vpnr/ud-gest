package fr.fo.ud.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fo.ud.business.api.IBusinessMandat;
import fr.fo.ud.data.api.IDaoMandat;
import fr.fo.ud.entity.Mandat;

@Service
public class BusinessMandat implements IBusinessMandat{

	@Autowired
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
