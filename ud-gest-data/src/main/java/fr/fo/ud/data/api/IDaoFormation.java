package fr.fo.ud.data.api;

import java.util.List;

import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Formation;

public interface IDaoFormation {

	public Formation add(Formation formation);
	
	public Formation update(Formation formation);
	
	public Formation delete(Formation formation);
	
	public Formation findById(Integer id);
	
	public List<Formation> findAll();
	
	public List<Formation> findByMotCle(String motCle);
	
	public List<Formation> findByAdherent(Adherent adherent);
	
}
