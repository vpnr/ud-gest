package fr.fo.ud.business.api;

import java.util.List;

import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Entreprise;
import fr.fo.ud.entity.Mandat;
import fr.fo.ud.entity.Formation;
import fr.fo.ud.entity.Syndicat;

public interface IBusinessAdherent {

	public Adherent add(Adherent adh);
	
	public Adherent update(Adherent adh);
	
	public Adherent delete(Adherent adh);
	
	public List<Adherent> getAll();
	
	public Adherent getById(Integer id);
	
	public List<Adherent> getByMotCle(String motCle);
	
	public List<Adherent> getBySyndicat(Syndicat syndicat);
	
	public List<Adherent> getByEntreprise(Entreprise entreprise);
	
	public List<Adherent> getByMandat(Mandat mandat);
	
	public List<Adherent> getByFormation(Formation formation);
	
	public void addMandatAdherent(Mandat mandat);
	
	public void updateMandatAdherent(Mandat mandat);

	public void deleteMandatAdherent(Mandat mandat);

	public void addFormationAdherent(Formation formation);
	
	public void updateFormationAdherent(Formation formation);
	
}
