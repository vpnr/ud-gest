package fr.fo.ud.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fo.ud.business.api.IBusinessSyndicat;
import fr.fo.ud.data.api.IDaoSyndicat;
import fr.fo.ud.entity.Syndicat;

@Service
public class BusinessSyndicat implements IBusinessSyndicat{

	@Autowired
	private IDaoSyndicat daoSyndicat;

	public Syndicat add(Syndicat paramSyndicat) {
	    return daoSyndicat.add(paramSyndicat);
	}

	public Syndicat update(Syndicat paramSyndicat) {
	    return daoSyndicat.update(paramSyndicat);
	}

	public Syndicat delete(Syndicat paramSyndicat) {
	    return daoSyndicat.delete(paramSyndicat);
	}

	public List<Syndicat> getAll() {
	    return daoSyndicat.findAll();
	}

	public Syndicat getById(Integer paramId) {
	    return daoSyndicat.findById(paramId);
	}

	public List<Syndicat> getByMotCle(String paramMotCle) {
	    return daoSyndicat.findByMotCle(paramMotCle);
	}

	@Override
	public List<String> getAllLibelles() {
		return daoSyndicat.findAllLibelles();
	}

}
