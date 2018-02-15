package fr.fo.ud.data.api;

import java.util.List;

import fr.fo.ud.entity.Adherent;
import fr.fo.ud.entity.Mandat;

public interface IDaoMandat {

	public Mandat add(Mandat mandat);
	
	public Mandat update(Mandat mandat);
	
	public Mandat delete(Mandat mandat);
	
	public Mandat getById(Integer id);
	
	public List<Mandat> getAll();
	
	public List<Mandat> getByMotCle(String motCle);
	
}
