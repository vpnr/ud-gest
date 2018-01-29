package fr.fo.ud.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fo.ud.business.api.IBusinessFederation;
import fr.fo.ud.data.api.IDaoFederation;
import fr.fo.ud.entity.Federation;

@Service
public class BusinessFederation implements IBusinessFederation {

	@Autowired
    private IDaoFederation daoFederation;
    
    public Federation add(Federation paramFederation) {
        return daoFederation.add(paramFederation);
    }

    public Federation update(Federation paramFederation) {
        return daoFederation.update(paramFederation);
    }

    public Federation delete(Federation paramFederation) {
        return daoFederation.delete(paramFederation);
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

}
