package fr.fo.ud.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.fo.ud.business.api.IBusinessEntreprise;
import fr.fo.ud.data.api.IDaoEntreprise;
import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Entreprise;

@Service
public class BusinessEntreprise implements IBusinessEntreprise{

	@Autowired
	private IDaoEntreprise daoEntreprise;
	
	public Entreprise add(Entreprise paramEntreprise) {
		return daoEntreprise.add(paramEntreprise);
	}

	public Entreprise update(Entreprise paramEntreprise) {
		// TODO Auto-generated method stub
		return null;
	}

	public Entreprise delete(Entreprise paramEntreprise) {
		// TODO Auto-generated method stub
		return null;
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
	public List<String> getAllLibelleByMotCle(String motCle) {
		return daoEntreprise.findAllLibelleByMotCle(motCle);
	}

}
