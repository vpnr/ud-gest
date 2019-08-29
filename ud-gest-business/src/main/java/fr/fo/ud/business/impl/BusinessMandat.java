package fr.fo.ud.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fo.ud.business.api.IBusinessMandat;
import fr.fo.ud.data.api.IDaoAdherent;
import fr.fo.ud.data.api.IDaoMandat;
import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Mandat;

@Service
public class BusinessMandat implements IBusinessMandat{

	@Autowired
    private IDaoMandat daoMandat;
	
	@Autowired
	private IDaoAdherent daoAdherent;
    
	@Override
    public Mandat add(Mandat mandat) {
        return daoMandat.add(mandat);
    }

    @Override
    public Mandat update(Mandat mandat) {
        return daoMandat.update(mandat);
    }

    @Override
    public Mandat delete(Mandat mandat) {
//        List<Adherent> adherents = daoAdherent.findByMandat(mandat);
//    	for (Adherent adherent : adherents) {
//			adherent.setMandats(mandats);
//		}
    	return daoMandat.delete(mandat);
    }

    @Override
    public List<Mandat> getAll() {
        return daoMandat.findAll();
    }

    @Override
    public List<Mandat> getByMotCle(String paramMotCle) {
        return daoMandat.findByMotCle(paramMotCle);
    }

    @Override
    public Mandat getById(Integer paramId) {
        return daoMandat.findById(paramId);
    }


}
