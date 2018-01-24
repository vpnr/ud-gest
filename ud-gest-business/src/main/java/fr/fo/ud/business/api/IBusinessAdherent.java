package fr.fo.ud.business.api;

import java.util.List;

import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Entreprise;
import fr.fo.ud.entity.Fonction;
import fr.fo.ud.entity.Formation;
import fr.fo.ud.entity.Syndicat;
import fr.fo.ud.entity.Ville;

public interface IBusinessAdherent {

	public Adherent add(Adherent adh);
	
	public Adherent update(Adherent adh);
	
	public Adherent delete(Adherent adh);
	
	public List<Adherent> getAll();
	
	public Adherent getById(Integer id);
	
	public List<Adherent> getByMotCle(String motCle);
	
	public List<Formation> getFormationByAdherent(Adherent adherent);
	
	public List<Fonction> getFonctionByAdherent(Adherent adherent);
	
	public List<Adherent> getByVille(Ville ville);
	
	public List<Adherent> getBySyndicat(Syndicat syndicat);
	
	public List<Adherent> getByEntreprise(Entreprise entreprise);
	
	public List<Adherent> getByFonction(Fonction fonction);
	
	public List<Adherent> getByFormation(Formation formation);
	
	public Adherent addFonctionAdherent(Fonction fonction);
	
	public Adherent deleteFonctionAdherent(Fonction fonction);
	
	public Adherent updateFonctionAdherent(Fonction fonction);
	
	public Adherent addFormationAdherent(Formation formation);
	
	
}
