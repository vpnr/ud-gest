package fr.fo.ud.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fo.ud.business.api.IBusinessUd;
import fr.fo.ud.data.api.IDaoSyndicat;
import fr.fo.ud.data.api.IDaoUd;
import fr.fo.ud.entity.Syndicat;
import fr.fo.ud.entity.UnionDepartemental;

@Service
public class BusinessUd implements IBusinessUd{

	@Autowired
    private IDaoUd daoUd;
	
	@Autowired
    private IDaoSyndicat daoSyndicat;

    public UnionDepartemental add(UnionDepartemental paramUd) {
        return daoUd.add(paramUd);
    }

    public UnionDepartemental update(UnionDepartemental paramUd) {
        return daoUd.update(paramUd);
    }

    public UnionDepartemental delete(int id) {
    	UnionDepartemental ud = daoUd.findById(id);
		for (Syndicat syndicat : ud.getSyndicats()) {
			syndicat.setUd(null);
			daoSyndicat.update(syndicat);
		}
        return daoUd.delete(ud);
    }

    public UnionDepartemental getById(Integer paramId) {
        return daoUd.findById(paramId);
    }

    public List<UnionDepartemental> getAll() {
        return daoUd.findAll();
    }

    public List<UnionDepartemental> getByMotCle(String paramMotCle) {
        return daoUd.findByMotCle(paramMotCle);
    }
    
    public List<String> getAllLibelles() {
        return daoUd.findAllLibelles();
    }

	@Override
	public UnionDepartemental getByLibelle(String libelle) {
		return daoUd.findByLibelle(libelle);
	}
    
    
}
