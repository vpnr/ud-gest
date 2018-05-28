package fr.fo.ud.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fo.ud.business.api.IBusinessAdherent;
import fr.fo.ud.data.api.IDaoAdherent;
import fr.fo.ud.data.api.IDaoEntreprise;
import fr.fo.ud.data.api.IDaoFederation;
import fr.fo.ud.data.api.IDaoFormation;
import fr.fo.ud.data.api.IDaoMandat;
import fr.fo.ud.data.api.IDaoSyndicat;
import fr.fo.ud.data.api.IDaoUd;
import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Entreprise;
import fr.fo.ud.entity.Federation;
import fr.fo.ud.entity.Formation;
import fr.fo.ud.entity.Mandat;
import fr.fo.ud.entity.Syndicat;
import fr.fo.ud.entity.UnionDepartemental;

@Service
public class BusinessAdherent implements IBusinessAdherent {

	@Autowired
	private IDaoAdherent daoAdherent;
	
	@Autowired
	private IDaoEntreprise daoEntreprise;
	
	@Autowired
	private IDaoSyndicat daoSyndicat;
	
	@Autowired
	private IDaoFederation daoFederation;
	
	@Autowired
	private IDaoUd daoUd;
	
	@Autowired
	private IDaoFormation daoFormation;
	
	@Autowired
	private IDaoMandat daoMandat;
	
	@Override
	public Adherent add(Adherent adh) {
		
		Entreprise entreprise;
		Syndicat syndicat;
		Federation federation;
		UnionDepartemental ud;
		List<Mandat> mandats;
		List<Formation> formations;
		
		if (adh.getEntreprise().getId() == null){
			entreprise = daoEntreprise.add(adh.getEntreprise());
			adh.setEntreprise(entreprise);
		}
		
		if (adh.getSyndicat().getFederation().getId() == null) {
			federation = daoFederation.add(adh.getSyndicat().getFederation());
			adh.getSyndicat().setFederation(federation);
		}
		
		if (adh.getSyndicat().getUd().getId() == null) {
			ud= daoUd.add(adh.getSyndicat().getUd());
			adh.getSyndicat().setUd(ud);
		}
		
		if (adh.getSyndicat().getId() == null){
			syndicat = daoSyndicat.add(adh.getSyndicat());
			adh.setSyndicat(syndicat);
		}
		
		return daoAdherent.save(adh);
	}

	@Override
	public Adherent update(Adherent adh) {
		return daoAdherent.update(adh);
	}

	@Override
	public Adherent delete(Adherent adh) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adherent> getAll() {
		return daoAdherent.findAll();
	}
	
	@Override
	public Adherent getById(Integer paramId) {
		return daoAdherent.findById(paramId);
	}
	
	@Override
	public List<Adherent> getByMotCle(String paramMotCle) {
		return daoAdherent.findByMotCle(paramMotCle);
	}

	@Override
	public List<Adherent> getBySyndicat(Syndicat syndicat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adherent> getByEntreprise(Entreprise entreprise) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adherent> getByMandat(Mandat mandat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adherent> getByFormation(Formation formation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMandatAdherent(Mandat mandat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMandatAdherent(Mandat mandat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMandatAdherent(Mandat mandat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFormationAdherent(Formation formation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFormationAdherent(Formation formation) {
		// TODO Auto-generated method stub
		
	}

}
