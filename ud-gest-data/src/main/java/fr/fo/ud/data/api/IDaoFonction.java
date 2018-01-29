package fr.fo.ud.data.api;

import java.util.List;

import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Mandat;

public interface IDaoFonction {

	Mandat add(Mandat fonction);
	
	Mandat update(Mandat fonction);
	
	Mandat delete(Mandat fonction);
	
	Mandat getById(Integer id);
	
	List<Mandat> getAll();
	
	List<Mandat> getByMotCle(String motCle);
	
	List<Mandat> getFonctionEntreprise();
	
	List<Mandat> getFonctionSyndicat();
	
	List<Mandat> getFonctionSection();
	
	List<Mandat> getFonctionBranche();
	
	List<Mandat> getFonctionUd();
	
	List<Mandat> getFonctionFederation();
	
	List<Mandat> getFonctionGroupement();
	
}
