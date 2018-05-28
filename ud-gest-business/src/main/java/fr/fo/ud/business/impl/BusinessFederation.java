package fr.fo.ud.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fo.ud.business.api.IBusinessFederation;
import fr.fo.ud.data.api.IDaoFederation;
import fr.fo.ud.data.api.IDaoSyndicat;
import fr.fo.ud.entity.Federation;
import fr.fo.ud.entity.Syndicat;

@Service
public class BusinessFederation implements IBusinessFederation {

	@Autowired
    private IDaoFederation daoFederation;
	
	@Autowired
    private IDaoSyndicat daoSyndicat;
	
    public Federation add(Federation paramFederation) {
        return daoFederation.add(paramFederation);
    }

    public Federation update(Federation paramFederation) {
        return daoFederation.update(paramFederation);
    }

    public Federation delete(int id) {
    	Federation federation = daoFederation.findById(id);
		for (Syndicat syndicat : federation.getSyndicats()) {
			syndicat.setFederation(null);
			daoSyndicat.update(syndicat);
		}
		return daoFederation.delete(federation);
    }
    
    public List<Federation> getAll() {
    	return daoFederation.findAll();
    }
    
    public Federation getById(Integer paramId) {
    	return daoFederation.findById(paramId);
    }

    public List<Federation> getByMotCle(String paramMotCle) {
        return daoFederation.findByMotCle(paramMotCle);
    }

	@Override
	public List<String> getAllLibelles() {
		return daoFederation.findAllLibelles();
	}

	@Override
	public Federation getByLibelle(String libelle) {
		return daoFederation.findByLibelle(libelle);
	}

}
