package fr.fo.ud.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fo.ud.business.api.IBusinessEntreprise;
import fr.fo.ud.data.api.IDaoAdherent;
import fr.fo.ud.data.api.IDaoEntreprise;
import fr.fo.ud.data.api.IDaoEvent;
import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Entreprise;
import fr.fo.ud.entity.Event;

@Service
public class BusinessEntreprise implements IBusinessEntreprise{

	@Autowired
	private IDaoEntreprise daoEntreprise;
	
	@Autowired
	private IDaoAdherent daoAdherent;
	
	@Autowired
	private IDaoEvent daoEvent;
	
	@Override
	public Entreprise add(Entreprise paramEntreprise) {
		return daoEntreprise.add(paramEntreprise);
	}

	@Override
	public Entreprise update(Entreprise paramEntreprise) {
		return daoEntreprise.update(paramEntreprise);
	}

	@Override
	public Entreprise delete(int id) {
		Entreprise entrepriseToDel = daoEntreprise.findById(id);
		for (Adherent adherent : entrepriseToDel.getAdherents()) {
			adherent.setEntreprise(null);
			daoAdherent.update(adherent);
		}
		List<Event> events = daoEvent.findByEntreprise(entrepriseToDel);
		for (Event event : events) {
			daoEvent.delete(event);
		}
		return daoEntreprise.delete(entrepriseToDel);
	}

	@Override
	public Entreprise getById(Integer paramId) {
		return daoEntreprise.findById(paramId);
	}

	@Override
	public List<Entreprise> getAll() {
		return daoEntreprise.findAll();
	}

	@Override
	public List<Entreprise> getByMotCle(String paramMotCle) {
		return daoEntreprise.findByMotCle(paramMotCle);
	}

	@Override
	public List<Entreprise> getEntrepriseByAdherent(Adherent paramAdherent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<String> getAllLibelles() {
		return daoEntreprise.findAllLibelles();
	}

	@Override
	public List<String> getAllLibelleByMotCle(String motCle) {
		return daoEntreprise.findAllLibelleByMotCle(motCle);
	}

	@Override
	public Entreprise getByLibelle(String libelle) {
		return daoEntreprise.findByLibelle(libelle);
	}

	@Override
	public Long exist(String libelle) {
		return daoEntreprise.count(libelle);
	}

}
