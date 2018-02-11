package fr.fo.ud.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fo.ud.business.api.IBusinessAdherent;
import fr.fo.ud.data.api.IDaoAdherent;
import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Entreprise;
import fr.fo.ud.entity.Formation;
import fr.fo.ud.entity.Mandat;
import fr.fo.ud.entity.Syndicat;

@Service
public class BusinessAdherent implements IBusinessAdherent {

	@Autowired
	private IDaoAdherent daoAdherent;
	
	@Override
	public Adherent add(Adherent adh) {
		return daoAdherent.add(adh);
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
