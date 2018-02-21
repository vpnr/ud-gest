package fr.fo.ud.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fo.ud.business.api.IBusinessEntreprise;
import fr.fo.ud.data.api.IDaoAdherent;
import fr.fo.ud.data.api.IDaoEntreprise;
import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Entreprise;

@Service
public class BusinessEntreprise implements IBusinessEntreprise{

	@Autowired
	private IDaoEntreprise daoEntreprise;
	
	@Autowired
	private IDaoAdherent daoAdherent;
	
	public Entreprise add(Entreprise paramEntreprise) {
		return daoEntreprise.add(paramEntreprise);
	}

	public Entreprise update(Entreprise paramEntreprise) {
		return daoEntreprise.update(paramEntreprise);
	}

	public Entreprise delete(int id) {
		Entreprise entrepriseToDel = daoEntreprise.findById(id);
		for (Adherent adherent : entrepriseToDel.getAdherents()) {
			adherent.setEntreprise(null);
			daoAdherent.update(adherent);
		}
		return daoEntreprise.delete(entrepriseToDel);
	}

	public Entreprise getById(Integer paramId) {
		return daoEntreprise.findById(paramId);
	}

	public List<Entreprise> getAll() {
		return daoEntreprise.findAll();
	}

	public List<Entreprise> getByMotCle(String paramMotCle) {
		return daoEntreprise.findByMotCle(paramMotCle);
	}

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

}
