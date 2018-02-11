package fr.fo.ud.business.api;

import java.util.List;

import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Entreprise;

public interface IBusinessEntreprise {

	public Entreprise add(Entreprise entreprise);
	
	public Entreprise update(Entreprise entreprise);
	
	public Entreprise delete(int id);
	
	public Entreprise getById(Integer id);
	
	public List<Entreprise> getAll();
	
	public List<Entreprise> getByMotCle(String motCle);
	
	public List<Entreprise> getEntrepriseByAdherent(Adherent adherent);
	
	public List<String> getAllLibelleByMotCle(String motCle);
	
}
