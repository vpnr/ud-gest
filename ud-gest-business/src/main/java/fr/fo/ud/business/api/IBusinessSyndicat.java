package fr.fo.ud.business.api;

import java.util.List;

import fr.fo.ud.entity.Syndicat;

public interface IBusinessSyndicat {

	Syndicat add(Syndicat syndicat);
	
	Syndicat update(Syndicat syndicat);
	
	Syndicat delete(Syndicat syndicat);
	
	List<Syndicat> getAll();
	
	Syndicat getById(Integer id);
	
	List<Syndicat> getByMotCle(String motCle);
	
	
}
